
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

        WordServicrImpl wordServicr = new WordServicrImpl();
        Map<Integer, List<Word>> words = wordServicr.fileProcessing();

       Assertions.assertThat(words).isNotNull();


        System.out.println("Test Index =="+Utility.getGroupAverage(words.get(5)));
        Assertions.assertThat(Utility.getGroupAverage(words.get(6))).isEqualTo(2.5);

        String fileOutput = wordServicr.outPutFormatter(words);
        System.out.println(fileOutput);


       Assertions.assertThat(fileOutput).isNotNull();

       wordServicr.writeOutputIntoFile(fileOutput);

    }



}
