package com.company;

import java.util.*;

class Pair {
    ArrayList<String> listOfPairs = new ArrayList<>();

    public List<String> makePairList(List A, List B, List C, int D) {
        for (int i = 0; i < A.size(); i++) {
            float freq = (float) (int) C.get(i) / D;
            String readyPair = "{(" + A.get(i) + "), " + B.get(i) + "} = " + String.format("%.2f", freq) + " (" + C.get(i) + "/" + D + ")";
            listOfPairs.add(readyPair);
        }
        return listOfPairs;
    }
}

class Solution {

    ArrayList<List> listOfCombinationsLists = new ArrayList<>();
    ArrayList<Integer> listOfWordLength = new ArrayList<>();
    ArrayList<Integer> listOfcounter = new ArrayList<>();
    LinkedHashSet<String> setLogic = new LinkedHashSet<>();


    public void solution(String phrase) {
        setLogic.add("L");
        setLogic.add("O");
        setLogic.add("G");
        setLogic.add("I");
        setLogic.add("C");
        phrase = phrase.toUpperCase();


        String[] words = phrase.split("\\s");
        int foundLettersCounter = 0;
        for (int i = 0; i < words.length; i++) {
            ArrayList<String> smallListofCombinationFromSet = new ArrayList<>();
            for (String letter : setLogic) {
                if (words[i].contains(letter)) {

                    for (int j = 0; j < words[i].length(); j++) {
                        if (Character.toString(words[i].charAt(j)).equals(letter)) {
                            foundLettersCounter += 1;

                            if (!smallListofCombinationFromSet.contains(letter)) {
                                smallListofCombinationFromSet.add(letter);
                            }
                        }
                    }
                }
            }
            int counterOfLettersInSmallCombList = smallListofCombinationFromSet.size();
            listOfcounter.add(counterOfLettersInSmallCombList);
            listOfCombinationsLists.add(smallListofCombinationFromSet);
            listOfWordLength.add(words[i].length());

        }
        Pair pair = new Pair();
        List A = pair.makePairList(listOfCombinationsLists, listOfWordLength, listOfcounter, foundLettersCounter);

        for (int i = 0; i < A.size(); i++) {
            System.out.printf("\n" + A.get(i));
        }

        int lengthOfInputLetters = phrase.length() - (words.length - 1);
        float totalFrequency = (float) foundLettersCounter / lengthOfInputLetters;
        System.out.printf("\nTOTAL Frequency: " + String.format("%.2f", totalFrequency));
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution;
        solution = new Solution();
        String A = "I would love to work in global logic";
        solution.solution(A);
    }
}
