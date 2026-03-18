package org.example.models;

public class Player {
    String id;
    int currentPos;
    int consecutiveSixes;

    public Player(String id) {
        this.id = id;
        this.currentPos = 0;
        this.consecutiveSixes = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public int getConsecutiveSixes() {
        return consecutiveSixes;
    }

    public void setConsecutiveSixes(int consecutiveSixes) {
        this.consecutiveSixes = consecutiveSixes;
    }

    public void resetConsecutiveSixes(){
        this.consecutiveSixes = 0;
    }

    public void incrementConsecutiveSixes() {
        this.consecutiveSixes++;
    }

    public boolean hasWon(int n){
        return currentPos == n*n;
    }
}
