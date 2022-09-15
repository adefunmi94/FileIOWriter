package service;

import model.Word;

import java.io.*;
import java.util.*;

public class WordServicrImpl implements WordService{

    final static String FileInput = "fileInput.txt";

    final static String OUTPUT = "Output.txt";


    @Override
    public Map<Integer, List<Word>> fileProcessing() throws IOException {
        File file = new File(FileInput);
        List<Word> list = new ArrayList<>();
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String word = "";
        String st;
        while ((st = br.readLine()) != null)
            word = st;
        String[] words = word.split("\\W+");

        Arrays.stream(words).forEach(t->list.add(new Word(t)));
//        System.out.println(groupWords(list));;
        return groupWords(list);
    }

    @Override
    public void writeOutputIntoFile(String printOut) throws IOException {

        FileWriter fileWriter = new FileWriter(OUTPUT);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(printOut);

        printWriter.close();

    }

    private static Map<Integer, List<Word>> groupWords(List<Word> words){
        Map<Integer,List<Word>> wordGroup = new HashMap<>();
        for (Word word: words ) {
            if(wordGroup.containsKey(word.getLength()))
                wordGroup.get(word.getLength()).add(word);
            else {
                List<Word> start = new ArrayList<>();
                start.add(word);
                wordGroup.put(word.getLength(), start);
            }
        }
        return  wordGroup;
    }


    private String formatResponse(Map.Entry<Integer,List<Word>> entry){

        return "("+getGroupVowels(entry.getValue())+" , "+ entry.getKey()+") ->"+Utility.getGroupAverage(entry.getValue()) + "\n";
    }


    public static String getGroupVowels(List<Word> words){
        Set<Character> res = new HashSet<>();
        words.forEach(word -> res.addAll(word.getVowels()));
        Set<String> stringSet = new HashSet<>();
        res.forEach(x -> stringSet.add(String.valueOf(x)));
        String printVowel= String.join(", ", stringSet);

        return "{"+printVowel + "}";
    }

     public String outPutFormatter(Map<Integer, List<Word>> groupedWords){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OUTPUT");
        stringBuilder.append("\n");
        for (Map.Entry<Integer,List<Word>> entry: groupedWords.entrySet() ) {
//            System.out.println(formatResponse(entry));

            stringBuilder.append(formatResponse(entry));

        }
      return stringBuilder.toString();
    }

}
