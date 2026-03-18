package org.example.models;

import java.util.UUID;

public class Player {
    private UUID id;
    private int currentPos;
    private int consecutiveSixes;

    public Player(UUID id) {
        this.id = id;
        this.currentPos = 0;
        this.consecutiveSixes = 0;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
