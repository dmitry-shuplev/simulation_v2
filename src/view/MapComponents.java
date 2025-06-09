package view;

import app_main.Settings;
import entities.Entity;
import game_map.Coordinate;
import game_map.GameMap;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MapComponents extends JComponent {
    private GameMap gameMap;
    private int width = Settings.VIEW_WIDTH;
    private int height = Settings.VIEW_HEIGHT;
    private int mapWidth = Settings.GAME_FIELD_X_MAX;
    private int mapHeight = Settings.GAME_FIELD_Y_MAX;
    private Image predatorImage;
    private Image herbivoreImage;
    private Image grassImage;
    private Image treeImage;
    private Image rockImage;


    public MapComponents(GameMap gm) {
        this.gameMap = gm;
    loadImages();
    }

    private void loadImages() {
        predatorImage = new ImageIcon(getClass().getResource("/images/predator.png")).getImage();
        herbivoreImage = new ImageIcon(getClass().getResource("/images/rabit1.png")).getImage(); // Исправлено имя файла
        grassImage = new ImageIcon(getClass().getResource("/images/grass3.png")).getImage();
        treeImage = new ImageIcon(getClass().getResource("/images/tree.png")).getImage();
        rockImage = new ImageIcon(getClass().getResource("/images/rock2.png")).getImage();
    }

    @Override
    public void paint(Graphics g) {
super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);


        int cellSize = getWidth() / mapWidth;

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {


                switch (getSwitcher(x,y)) {
                    case "Predator":
                        g.setColor(Color.RED);
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(predatorImage, x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2), this);
                        break;
                    case "Herbivore":
                        g.setColor(Color.PINK);
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(herbivoreImage, x * cellSize, y * cellSize, (int) (cellSize / 1.5), (int) (cellSize / 1.5), this);
                        break;
                    case "Grass":
                        g.setColor(new Color(144, 238, 144));
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(grassImage, x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2), this);
                        break;
                    case "Tree":
                        g.setColor(Color.GREEN);
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(treeImage, x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2), this);
                        break;
                    case "Rock":
                        g.setColor(new Color(139, 69, 19));
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(rockImage, x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2), this);
                        break;
                    case "Path":
                        g.setColor(Color.DARK_GRAY);
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        break;
                    case "Emptiness":
                        g.setColor(Color.LIGHT_GRAY);
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        break;
                    default:
                        break;
                }
            }
        }


    }

    private String getSwitcher(int x, int y){
        Coordinate coordinate = new Coordinate(x,y);
        String swithcer;
        Entity answer = gameMap.getEntity(coordinate);
        swithcer = (answer!= null) ? answer.getClass().getSimpleName() : "Emptiness";
        if(gameMap.path.contains(coordinate)){swithcer = "Path";}
        return swithcer;
    }
}
