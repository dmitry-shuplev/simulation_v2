package game_map;


import java.util.Objects;

public class Coordinate {
    private int posX;
    private int posY;

    public Coordinate(int x, int y) {
        posX = x;
        posY = y;
    }
    public Coordinate(Coordinate c){
        posX = c.getPosX();
        posY = c.getPosY();
    }


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isCorrect() {
        return this.posX >= 0 && this.posX < app_main.Settings.GAME_FIELD_X_MAX &&
                this.posY >= 0 && this.posY < app_main.Settings.GAME_FIELD_Y_MAX;
    }


    @Override
    public String toString() {
        return "Coordinate/" +
                "posX=" + posX +
                ": posY=" + posY +
                '/';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return posX == that.posX && posY == that.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }
}
