package game_map;

import app_main.Settings;

import java.util.LinkedList;
import java.util.List;

public class CoordinateUtils {
    public static int getDistance(Coordinate a, Coordinate b){
        return Math.abs(a.getPosX()- b.getPosX())+Math.abs(a.getPosX()- b.getPosX());
    }

    public static Coordinate getCoorFromDirection(Coordinate current, Settings.Direction dir){
        Coordinate c = new Coordinate(current);
        switch (dir) {
            case UP:
                c.setPosY(c.getPosY() - 1);
                break;
            case DOWN:
                c.setPosY(c.getPosY() + 1);
                break;
            case LEFT:
                c.setPosX(c.getPosX() - 1);
                break;
            case RIGHT:
                c.setPosX(c.getPosX() + 1);
                break;
        }
        return c;
    }

    public static Settings.Direction getDirFromCoordinate(Coordinate current, Coordinate destinatinon) {
        if(current==null||destinatinon==null) return Settings.Direction.HOLD_POSITION;
        if (current.getPosX() == destinatinon.getPosX() && current.getPosY() < destinatinon.getPosY()) {
            return Settings.Direction.DOWN;
        } else if (current.getPosX() == destinatinon.getPosX() && current.getPosY() > destinatinon.getPosY()) {
            return Settings.Direction.UP;
        } else if (current.getPosX() > destinatinon.getPosX() && current.getPosY() == destinatinon.getPosY()) {
            return Settings.Direction.LEFT;
        } else if (current.getPosX() < destinatinon.getPosX() && current.getPosY() == destinatinon.getPosY()) {
            return Settings.Direction.RIGHT;
        } else return Settings.Direction.HOLD_POSITION;
    }
public static List<Coordinate> getNaigborsCoordinates(Coordinate current){
        List<Coordinate> naighborsCoordinates = new LinkedList<>();
        for(Settings.Direction dir: Settings.Direction.values() ){
            Coordinate c = getCoorFromDirection(current, dir);
            if(c.isCorrect()){
                naighborsCoordinates.add(c);
            }
        }
        return naighborsCoordinates;
}

}
