package org.example.strategy;

import org.example.models.Player;

public class EasyGameStrategy implements GameStrategy{
    @Override
    public boolean shouldRollAgain(int diceValue) {
        return diceValue == 6;
    }

    @Override
    public boolean isTurnVoid(int consecutiveSixes) {
        return false;
    }

    @Override
    public void resetTurn(Player p) {
        p.resetConsecutiveSixes();
    }
}
