
import lombok.extern.slf4j.Slf4j;
import model.Word;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import service.Utility;
import service.WordServicrImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static org.junit.Assert.assertThat;


public class FileInputOutputTest {


    @Test
    public void testCases() throws IOException {

        WordServicrImpl wordService = new WordServicrImpl();
        Map<Integer, List<Word>> words = wordService.fileProcessing();

       Assertions.assertThat(words).isNotNull();


        System.out.println("Test Index =="+ words);
        Assertions.assertThat(Utility.getGroupAverage(words.get(6))).isEqualTo(2.5);
//
        String fileOutput = wordService.outPutFormatter(words);
        System.out.println(fileOutput);


       Assertions.assertThat(fileOutput).isNotNull();

       wordService.writeOutputIntoFile(fileOutput);

    }



}
