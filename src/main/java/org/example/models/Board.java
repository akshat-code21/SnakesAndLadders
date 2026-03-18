package org.example.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private final Map<Integer,Integer> snakeMap;
    private final Map<Integer,Integer> ladderMap;

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
            int ladderBottom = l.getStart();
            int ladderTop = l.getEnd();
            ladderMap.put(ladderBottom,ladderTop);
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

    public Map<Integer, Integer> getSnakeMap() {
        return snakeMap;
    }

    public Map<Integer, Integer> getLadderMap() {
        return ladderMap;
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

        for (Snake snake : snakes) {
            int headRow = (snake.getStart() - 1) / size;
            int tailRow = (snake.getEnd() - 1) / size;
            if (headRow == tailRow) {
                System.out.println("Invalid: Snake is horizontal (same row) at positions "
                        + snake.getStart() + " -> " + snake.getEnd());
                return false;
            }
        }

        for (Ladder ladder : ladders) {
            int bottomRow = (ladder.getStart() - 1) / size;
            int topRow = (ladder.getEnd() - 1) / size;
            if (bottomRow == topRow) {
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
