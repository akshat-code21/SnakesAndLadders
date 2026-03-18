package org.example.game;

import org.example.models.Board;
import org.example.models.Dice;
import org.example.strategy.GameStrategy;

import java.util.LinkedList;

public class EasyGame extends Game{
    public EasyGame(int n,int x,Board b,GameStrategy strategy){
        super(n,x,b,strategy);
    }
}
