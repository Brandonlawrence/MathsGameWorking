package com.g.android.mathsgameworking;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private ArrayList<String> questionsArrayList = new ArrayList<>();
    private Random randomNumber = new Random();


    public Game(){

        int randomInteger1 = randomNumber.nextInt(10) + 1;
        int randomInteger2 = randomNumber.nextInt(10) + 1;




    }

    public ArrayList<String> getQuestionsArrayList() {
        return questionsArrayList;
    }
}
