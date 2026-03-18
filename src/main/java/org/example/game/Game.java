package org.example.game;

import org.example.models.Board;
import org.example.models.Dice;
import org.example.models.Player;
import org.example.strategy.GameStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Game {
    protected int n;
    protected int x;
    protected Dice d;
    protected Board b;
    protected GameStrategy strategy;
    protected List<Player> activePlayers;
    protected Queue<Player> turnOrder;

    public Game(int n,int x,Board b,GameStrategy strategy){
        this.n = n;
        this.x = x;
        this.d = Dice.getInstance();
        this.b = b;
        this.strategy = strategy;
        this.turnOrder = new LinkedList<>();
        this.activePlayers = new ArrayList<>();
    }

    void addPlayer(Player p){
        activePlayers.add(p);
        this.turnOrder.add(p);
    }

    public void startGame(){
        System.out.println("=== Game Started! ===");
        System.out.println("Board size: " + n + "x" + n + " (" + (n * n) + " cells)");
        System.out.println("Players: " + activePlayers.size());
        System.out.println("Snakes: " + b.getSnakes().size() + ", Ladders: " + b.getLadders().size());

    }

    public boolean checkWinCondition(Player p){
        return p.hasWon(n);
    }

    public boolean isValidMove(int from,int roll){
        return from + roll <= n * n;
    }

    public boolean isGameOver(){
        return this.activePlayers.size() < 2;
    }

    public abstract void makeMove();

}
