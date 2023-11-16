package org.example.objects;

public class Hero extends GameObject {

    private char direction = 'E';
    private int numberOfArrows;
    private boolean hasGold = false;

    public Hero(int x, int y, char direction) {
        super(x, y);
        this.direction = direction;
    }

    public boolean isHasGold() {
        return hasGold;
    }

    public void setHasGold(boolean hasGold) {
        this.hasGold = hasGold;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getNumberOfArrows() {
        return numberOfArrows;
    }

    public void setNumberOfArrows(int numberOfArrows) {
        this.numberOfArrows = numberOfArrows;
    }

    @Override
    public String getName() {
        return "HERO|"+getDirection();
    }

    public ObjectTypes getType() {
        return ObjectTypes.HERO;
    }

    public String getSaveAbleName() {
        return getName();
    }

}
