package org.example.factory;

import org.example.game.EasyGame;
import org.example.game.Game;

public class GameFactory {
    public static Game getGame(int n,int x,String type){
        return new EasyGame();
    }
}
