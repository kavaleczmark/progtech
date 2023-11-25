package org.example.objects;

public class Hero extends GameObject {

    private char direction = 'E';
    private int numberOfArrows;
    private boolean hasGold = false;
    private boolean isWon = false;
    private boolean isDead;

    public Hero(int x, int y, char direction) {
        super(x, y);
        this.direction = direction;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
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
        if(isDead){
            return "DEAD";
        }
        return "HERO|"+getDirection();
    }

    public ObjectTypes getType() {
        return ObjectTypes.HERO;
    }

    public String getSaveAbleName() {
        return getName();
    }

    public void setDead() {
        this.isDead = true;
    }

    public boolean isDead() {
        return isDead;
    }
}
