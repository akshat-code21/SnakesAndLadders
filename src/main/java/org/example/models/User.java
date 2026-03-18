package org.example.models;

public class User {
    String id;
    int currentPos;
    int consecutiveSixes;

    public User(String id, int currentPos, int consecutiveSixes) {
        this.id = id;
        this.currentPos = currentPos;
        this.consecutiveSixes = consecutiveSixes;
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
}
