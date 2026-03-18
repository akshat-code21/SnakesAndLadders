package org.example.game;

import org.example.models.Board;
import org.example.models.Player;
import org.example.strategy.GameStrategy;

public class EasyGame extends Game {
    public EasyGame(int n, int x, Board b, GameStrategy strategy) {
        super(n, x, b, strategy);
    }

    @Override
    public void makeMove() {
        if (turnOrder.isEmpty()) return;
        Player currentPlayer = turnOrder.poll();

        boolean rollAgain;

        do {
            int diceValue = d.roll();
            rollAgain = false;
            System.out.println(currentPlayer.getId() + " rolled a " + diceValue
                    + " (currently at " + currentPlayer.getCurrentPos() + ")");
            if (isValidMove(currentPlayer.getCurrentPos(), diceValue)) {
                int newPos = currentPlayer.getCurrentPos() + diceValue;
                newPos = b.getFinalPosition(newPos);

                currentPlayer.setCurrentPos(newPos);

                System.out.println("  " + currentPlayer.getId() + " moved to " + newPos);
                if (checkWinCondition(currentPlayer)) {
                    System.out.println("*** " + currentPlayer.getId() + " wins! ***");
                    activePlayers.remove(currentPlayer);
                    return;
                }

                if (strategy.shouldRollAgain(diceValue)) {
                    System.out.println("  " + currentPlayer.getId() + " gets another turn!");
                    rollAgain = true;
                }
            } else {
                System.out.println("  Move not possible (would go beyond "
                        + (n * n) + "). " + currentPlayer.getId() + " stays at "
                        + currentPlayer.getCurrentPos());
            }
        } while (rollAgain);

        turnOrder.add(currentPlayer);
    }
}
