package Interfaces;

import actions.Randomiser;
import app_main.Settings;
import entities.Path;
import game_map.*;

import java.util.*;

public interface PathFinder {

    public default Coordinate findPreyCoordinate(GameMap gameMap) {
        List<Coordinate> wasChecked = new LinkedList<>();
        List<Coordinate> queue = new LinkedList<>();
        queue.add(this.getCoordinate());
        while (!queue.isEmpty()) {
            Coordinate currentNodeCoordinate = queue.remove(0);
            wasChecked.add(currentNodeCoordinate);
            for (Coordinate nodeCoordinate : CoordinateUtils.getNaigborsCoordinates(currentNodeCoordinate)) {
                if (!wasChecked.contains(nodeCoordinate) && !queue.contains(nodeCoordinate)) {
                    if (!gameMap.isCoordinateFree(nodeCoordinate) &&
                            gameMap.getEntity(nodeCoordinate).getClass().getSimpleName().equals(getFoodMarker())) {
                        return nodeCoordinate;
                    }
                    queue.add(nodeCoordinate);
                }
            }
        }
        //stub
        return new Randomiser(gameMap).getFreeCoordinate();
    }

    public default List<Coordinate> findPath(GameMap gameMap, Coordinate targerCoordinate) {
        ArrayList<Coordinate> path = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<Node> wasCheked = new ArrayList<>();
        Node rootNode = new Node(this.getCoordinate());
        int stepCounter = 0;
        queue.add(rootNode);
        Node processedNode = new Node();
        baseLoop:
        while (!queue.isEmpty()) {
            stepCounter++;
            /*
            if (stepCounter > SEARCH_AREA) {
                break baseLoop;
            } Можно реализовать механизм ограничения территории поиска*/
            processedNode = queue.remove(0);
            for (Coordinate nodeCoordinate : CoordinateUtils.getNaigborsCoordinates(processedNode.getCoordinate())) {
                if (nodeCoordinate.equals(targerCoordinate)) {
                    break baseLoop;
                }
                if (gameMap.isCoordinateFree(nodeCoordinate)) {
                    Node newNode = new Node(nodeCoordinate);
                    if (wasCheked.contains(newNode)) {
                        continue;
                    }
                    newNode.setParantNode(processedNode);
                    newNode.setCostMove(processedNode.getCostMove() + Settings.MOVE_COST);
                    newNode.setCostMoveHeuristic(CoordinateUtils.getDistance(nodeCoordinate, targerCoordinate));
                    newNode.setCostMoveTotal(newNode.getCostMove() + newNode.getCostMoveHeuristic());
                    Node duplicateNode = newNode.getDuplicateFrom(queue);
                    if (duplicateNode == null) {
                        queue.add(newNode);
                    } else if (duplicateNode.getCostMoveTotal() > newNode.getCostMoveTotal()) {
                        queue.remove(duplicateNode);
                        queue.add(newNode);
                    }
                }
            }
            wasCheked.add(processedNode);
            Comparator<Node> sortByMoveCost = Comparator.comparing(Node::getCostMoveTotal).thenComparingInt(Node::getCostMoveHeuristic);
            Collections.sort(queue, sortByMoveCost);
        }
        while (!processedNode.equals(rootNode)) {
            path.add(0, processedNode.getCoordinate());
            processedNode = processedNode.getParantNode();
        }
        return path;

    }

    public default Settings.Direction getNextStepDirection(GameMap gameMap) {

        Coordinate targerCoordinate = findPreyCoordinate(gameMap);
        List<Coordinate> path = findPath(gameMap, targerCoordinate);
        gameMap.path.clear();
        if (!path.isEmpty()) {
            targerCoordinate = path.remove(0);
        }


        return CoordinateUtils.getDirFromCoordinate(getCoordinate(), targerCoordinate);
    }

    Coordinate getCoordinate();

    String getFoodMarker();

    void setCoordinate(Coordinate coordinate);
}
