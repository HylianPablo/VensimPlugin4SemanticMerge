package es.uva.inf.grammar.comment;


import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import es.uva.inf.grammar.Comment;

public class CommentTest {

    @Test
    public void lecturaCorrecta() {
        // 16-10-2020: File name is written inside the code and not from parameter from
        // now. Its easier for manual testing. CAREFUL
        // Until refactor, this test uses SHODOR/Bunny.mdl
        String[] args = new String[0];
        Comment.main(args);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("VensimExampleModels/SHODOR/Bunny.mdl"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            assertSame(122,lines); //Last newline is not counted

            reader = new BufferedReader(new FileReader("out.mdl"));
            for(int i=0;i<4;i++){
                reader.readLine();
            }
            String line = reader.readLine();
            assertTrue(line.indexOf("View 1")!=-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lecturaIncorrecta(){
        //It will fail until program is modified to red from parameter.
        String[] args = new String[0];
        assertThrows(IOException.class, () -> {
			Comment.main(args);
		});

    }
}
