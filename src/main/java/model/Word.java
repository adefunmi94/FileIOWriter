package model;

import com.sun.source.doctree.SeeTree;
import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Word {

    private String word;



    public Word(String word) {
        word = word.trim().toLowerCase();
        this.word = word;
    }

    public int getLength() {
        return word.length();
    }

    public int numberOfVowel(){
        int value = 0;
        for (char c : word.toCharArray())
            if (Arrays.stream(Vowel.values()).map(t->String.valueOf(t)).collect(Collectors.toSet()).contains(String.valueOf(c)))
                value+=1;

        return value;
    }


    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }

    public Set<Character> getVowels(){
        Set<Character> res = new HashSet<>();
        for (char c : word.toCharArray())
            if (Arrays.stream(Vowel.values()).
                    map(t->String.valueOf(t)).
                    collect(Collectors.toSet()).
                    contains(String.valueOf(c)))
                res.add(c);
        return res;
    }

}
