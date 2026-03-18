package org.example.models;

import java.util.Random;

public class Dice {
    private static volatile Dice INSTANCE;
    private final int[] faces = {1,2,3,4,5,6};
    private static Random random = new Random();

    private Dice() {
        if (INSTANCE != null) {
            throw new RuntimeException("Use getInstance() instead");
        }
    }

    public static Dice getInstance(){
        if(INSTANCE == null){
            synchronized (Dice.class){
                if(INSTANCE==null){
                    INSTANCE = new Dice();
                }
            }
        }
        return INSTANCE;
    }

    public int roll(){
        int randomIdx = random.nextInt(faces.length);
        return faces[randomIdx];
    }
}
