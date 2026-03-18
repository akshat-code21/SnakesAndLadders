package org.example.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    int size;
    List<Snake> snakes;
    List<Ladder> ladders;
    Map<Integer,Integer> snakeMap;
    Map<Integer,Integer> ladderMap;

    public Board(int size,List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.snakeMap = new HashMap<>();
        this.ladderMap = new HashMap<>();

        for(Snake s : snakes){
            int snakeHead = s.getStart();
            int snakeTail = s.getEnd();
            snakeMap.put(snakeHead,snakeTail);
        }

        for(Ladder l : ladders){
            int ladderStart = l.getStart();
            int ladderEnd = l.getEnd();
            ladderMap.put(ladderEnd,ladderStart);
        }
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public boolean isOccupied(int pos){
        return snakeMap.containsKey(pos) || ladderMap.containsKey(pos);
    }

    public int getFinalPosition(int newPos){
        if(snakeMap.containsKey(newPos)){
            int finalPos = snakeMap.get(newPos);
            System.out.println("Bitten by snake! ");
            return finalPos;
        }
        if(ladderMap.containsKey(newPos)){
            int finalPos = ladderMap.get(newPos);
            System.out.println("Stepped on ladder");
            return finalPos;
        }
        return newPos;
    }

    public boolean validatePlacement() {
        int maxPos = size * size;

        // Check snakes are vertical (head and tail on different rows)
        for (Snake snake : snakes) {
            if (snake.getStart() == snake.getEnd()) {
                System.out.println("Invalid: Snake is horizontal (same row) at positions "
                        + snake.getStart() + " -> " + snake.getEnd());
                return false;
            }
        }

        // Check ladders are vertical (top and bottom on different rows)
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == ladder.getEnd()) {
                System.out.println("Invalid: Ladder is horizontal (same row) at positions "
                        + ladder.getStart() + " -> " + ladder.getEnd());
                return false;
            }
        }

        for (int pos : snakeMap.keySet()) {
            if (pos == 1 || pos == maxPos) {
                System.out.println("Invalid: Snake head at position " + pos);
                return false;
            }
            if (ladderMap.containsKey(pos)) {
                System.out.println("Invalid: Snake head and Ladder bottom at same position " + pos);
                return false;
            }
        }
        for (int pos : ladderMap.keySet()) {
            if (pos == 1 || pos == maxPos) {
                System.out.println("Invalid: Ladder bottom at position " + pos);
                return false;
            }
        }
        // Check for cycles: a snake tail should not be at a ladder bottom and vice-versa
        for (int tailPos : snakeMap.values()) {
            if (ladderMap.containsKey(tailPos)) {
                int ladderEnd = ladderMap.get(tailPos);
                if (snakeMap.containsKey(ladderEnd)) {
                    System.out.println("Warning: Potential cycle detected at positions " + tailPos + " -> " + ladderEnd);
                    return false;
                }
            }
        }
        return true;
    }

}
