package org.example.factory;

import org.example.game.EasyGame;
import org.example.game.Game;
import org.example.game.HardGame;
import org.example.models.Board;
import org.example.models.Ladder;
import org.example.models.Snake;
import org.example.strategy.EasyGameStrategy;
import org.example.strategy.HardGameStrategy;
import java.util.Random;
import java.util.*;

public class GameFactory {
    private static Random random = new Random();
    public static Game getGame(int n,int x,String type){
        Set<Integer> occupiedPositions = new HashSet<>();

        occupiedPositions.add(1);
        occupiedPositions.add(n * n);

        List<Snake> snakes = new ArrayList<>();
        int maxPos = n * n;
        for (int i = 0; i < n; i++) {
            Snake snake;
            int attempts = 0;
            do {
                int headPos = random.nextInt(maxPos - 2) + 2;
                int tailPos = random.nextInt(headPos - 1) + 1;
                snake = new Snake(headPos,tailPos);
                attempts++;
                if (attempts > 1000) {
                    throw new RuntimeException("Unable to place snake #" + (i + 1) + " after 1000 attempts");
                }
            } while (occupiedPositions.contains(snake.getStart()));
            occupiedPositions.add(snake.getStart());
            snakes.add(snake);
        }

        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Ladder ladder;
            int attempts = 0;
            do {
                int bottomPos = random.nextInt(maxPos - 2) + 2;
                int topPos = random.nextInt(maxPos - bottomPos) + bottomPos + 1;
                ladder = new Ladder(bottomPos,topPos);
                attempts++;
                if (attempts > 1000) {
                    throw new RuntimeException("Unable to place ladder #" + (i + 1) + " after 1000 attempts");
                }
            } while (occupiedPositions.contains(ladder.getStart()));
            occupiedPositions.add(ladder.getStart());
            ladders.add(ladder);
        }

        Board board = new Board(n, snakes, ladders);

        if (!board.validatePlacement()) {
            System.out.println("Warning: Board validation failed. Regenerating...");
            return getGame(n, x, type);
        }

        if(type.equals("easy"))
            return new EasyGame(n,x,board,new EasyGameStrategy());
        else
            return  new HardGame(n,x,board,new HardGameStrategy());
    }
}
