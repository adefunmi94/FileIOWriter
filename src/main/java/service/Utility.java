package service;

import model.Word;

import java.util.*;

public class Utility {




    public static double getGroupAverage(List<Word> words){
        double len = words.size();

        double avr = words.stream()
                .map(Word::numberOfVowel).
                reduce(0, (a, b) -> a + b) / len;
        return avr;
    }



    public static String getGroupVowels(List<Word> words){
        Set<Character> res = new HashSet<>();
        words.forEach(word -> res.addAll(word.getVowels()));
        Set<String> stringSet = new HashSet<>();
        res.forEach(x -> stringSet.add(String.valueOf(x)));
        String printVowel= String.join(", ", stringSet);

        return "{"+printVowel + "}";
    }

    public static String formatResponse(Map.Entry<Integer,List<Word>> entry){

        return "("+getGroupVowels(entry.getValue())+" , "+ entry.getKey()+") ->"+Utility.getGroupAverage(entry.getValue()) + "\n";
    }
}
