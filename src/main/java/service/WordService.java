package service;

import model.Word;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface WordService {

    public Map<Integer, List<Word>> fileProcessing() throws IOException;

    public void writeOutputIntoFile(String printOut) throws IOException;



}
