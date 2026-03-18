package org.example.game;

import org.example.models.Board;
import org.example.models.Dice;
import org.example.strategy.GameStrategy;

public class HardGame extends Game{
    public HardGame(int n,int x,Board b,GameStrategy strategy){
        super(n,x,b,strategy);
    }
}
