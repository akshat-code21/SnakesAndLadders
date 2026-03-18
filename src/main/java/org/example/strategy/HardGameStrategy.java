package org.example.strategy;

import org.example.models.Player;

public class HardGameStrategy implements GameStrategy{
    private static final int MAX_CONSECUTIVE_SIXES = 3;
    @Override
    public boolean shouldRollAgain(int diceValue) {
        return diceValue == 6;
    }

    @Override
    public boolean isTurnVoid(int consecutiveSixes) {
        return consecutiveSixes >= MAX_CONSECUTIVE_SIXES;
    }

    @Override
    public void resetTurn(Player p) {
        // make user stay there
        p.resetConsecutiveSixes();
    }
}
