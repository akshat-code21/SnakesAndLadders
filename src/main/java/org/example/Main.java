package org.example;
import org.example.factory.GameFactory;
import org.example.game.Game;
import org.example.models.Player;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the board");
        int n = sc.nextInt();
        System.out.println("Enter the no. of players playing the game: ");
        int x = sc.nextInt();
        Game game = GameFactory.getGame(n,x,"easy");

        for (int i = 1; i <= x; i++) {
            game.addPlayer(new Player(UUID.randomUUID()));
        }

        System.out.println();

        game.startGame();
    }
}