package etch.a.sketch;

public class Cursor {

    private int xPos = 0;
    private int yPos = 0;
    private final int VELO = 5;
    private int direction;

    public int getxpos() {
        return xPos;
    }

    public void setxpos(int a) {
        xPos = a;
    }

    public int getypos() {
        return yPos;
    }

    public void setypos(int b) {
        yPos = b;
    }

    public int getDirection1() {
        return direction;
    }

    public void setDirection(int a) {
        direction = a;
    }

    public void move1() throws InterruptedException {
        if (direction == 1) {
            xPos -= VELO;
        } else if (direction == 2) {
            yPos -= VELO;
        } else if (direction == 3) {
            xPos += VELO;
        } else if (direction == 4) {
            yPos += VELO;
        }
    }
}
