package org.example.factory;

import org.example.game.EasyGame;
import org.example.game.Game;
import org.example.game.HardGame;
import org.example.models.Board;
import org.example.strategy.EasyGameStrategy;
import org.example.strategy.HardGameStrategy;

public class GameFactory {
    public static Game getGame(int n,int x,String type){
        if(type.equals("easy"))
            return new EasyGame(n,x,new Board(),new EasyGameStrategy());
        else
            return  new HardGame(n,x,new Board(),new HardGameStrategy());
    }
}
