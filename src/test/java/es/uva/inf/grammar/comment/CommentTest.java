package es.uva.inf.grammar.comment;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import es.uva.inf.grammar.Comment;

public class CommentTest {

    @Test
    public void lecturaCorrectaSimple() {
        String[] args = new String[2];
        args[0]="VensimExampleModels/SHODOR/Bunny.mdl";
        args[1]="outputs/comment/test1.mdl";
        BufferedReader reader;
        try {
            Comment.main(args);
            reader = new BufferedReader(new FileReader("VensimExampleModels/SHODOR/Bunny.mdl"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            assertSame(127,lines); //Last newline is not counted

            reader = new BufferedReader(new FileReader("outputs/comment/test1.mdl"));
            Set<Integer> positions = new HashSet<Integer>();
            positions.addAll(Arrays.asList(new Integer[] {4, 9, 15, 21, 26, 31, 36, 41})); 
            for(int i=0;i<43;i++){
                String line = reader.readLine();
                if(positions.contains(i)){
                    assertTrue(line.indexOf("View 1")!=-1);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lecturaCorrectaEcuacionDescriptiva() {
        String[] args = new String[2];
        args[0]="VensimExampleModels/SHODOR/examples.mdl";
        args[1]="outputs/comment/test2.mdl";
        BufferedReader reader;
        try {
            Comment.main(args);
            reader = new BufferedReader(new FileReader("VensimExampleModels/SHODOR/examples.mdl"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            assertEquals(244,lines); //Last newline is not counted

            reader = new BufferedReader(new FileReader("outputs/comment/test2.mdl"));
            Set<Integer> positions = new HashSet<Integer>();
            positions.addAll(Arrays.asList(new Integer[] {4, 10, 16, 22, 28, 34, 40, 46, 52, 58, 63, 68, 73, 78, 83, 88, 93, 98, 103, 108})); 
            for(int i=0;i<118;i++){
                String line = reader.readLine();
                if(positions.contains(i)){
                    assertTrue(line.indexOf("View 1")!=-1);
                }
                if(i==115){
                    assertTrue(line.indexOf("View 1")==-1);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lecturaCorrectaConComentarios() {
        String[] args = new String[2];
        args[0]="VensimExampleModels/SHODOR/examplesComments.mdl";
        args[1]="outputs/comment/test3.mdl";
        BufferedReader reader;
        try {
            Comment.main(args);
            reader = new BufferedReader(new FileReader("VensimExampleModels/SHODOR/examplesComments.mdl"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            assertEquals(249,lines); //Last newline is not counted

            reader = new BufferedReader(new FileReader("outputs/comment/test3.mdl"));
            Set<Integer> positions = new HashSet<Integer>();
            positions.addAll(Arrays.asList(new Integer[] {4, 10, 16, 22, 28, 34, 40, 46, 52, 58, 63, 68, 74, 80, 86, 91, 96, 101, 106, 111})); 
            for(int i=0;i<118;i++){
                String line = reader.readLine();
                if(positions.contains(i)){
                    assertTrue(line.indexOf("View 1")!=-1);
                }
                if(i==68|i==74|i==80){
                    assertTrue(line.indexOf("|")==-1);
                }else{
                    if(positions.contains(i)){
                        assertTrue(line.indexOf("|")!=-1);
                    }
                }
                if(i==115){
                    assertTrue(line.indexOf("View 1")==-1);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lecturaCorrectaVariasVistas() {
        String[] args = new String[2];
        args[0]="VensimExampleModels/SHODOR/sociology101_mod.mdl";
        args[1]="outputs/comment/test4.mdl";
        BufferedReader reader;
        try {
            Comment.main(args);
            reader = new BufferedReader(new FileReader("VensimExampleModels/SHODOR/sociology101_mod.mdl"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            assertEquals(145,lines); //Last newline is not counted

            reader = new BufferedReader(new FileReader("outputs/comment/test4.mdl"));
            Set<Integer> positions1 = new HashSet<Integer>();
            positions1.addAll(Arrays.asList(new Integer[] {5, 11, 27, 32, 37, 42, 47})); 
            Set<Integer> positions2 = new HashSet<Integer>();
            positions2.addAll(Arrays.asList(new Integer[] {17, 21})); 
            for(int i=0;i<50;i++){
                String line = reader.readLine();
                if(positions1.contains(i)){
                    assertTrue(line.indexOf("View 1")!=-1);
                }else if(positions2.contains(i)){
                    assertTrue(line.indexOf("View 2")!=-1);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lecturaCorrectaCaracteresEspeciales() {
        String[] args = new String[2];
        args[0]="VensimExampleModels/SHODOR/BunnyUnderscores.mdl";
        args[1]="outputs/comment/test5.mdl";
        BufferedReader reader;
        try {
            Comment.main(args);
            reader = new BufferedReader(new FileReader("VensimExampleModels/SHODOR/BunnyUnderscores.mdl"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            assertEquals(137,lines); //Last newline is not counted

            reader = new BufferedReader(new FileReader("outputs/comment/test5.mdl"));
            Set<Integer> positions1 = new HashSet<Integer>();
            positions1.addAll(Arrays.asList(new Integer[] {3, 8, 13, 19, 25, 30, 35, 40, 45})); 
            for(int i=0;i<50;i++){
                String line = reader.readLine();
                if(positions1.contains(i)){
                    assertTrue(line.indexOf("View 1")!=-1);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lecturaCorrectaYaComentado() {
        String[] args = new String[2];
        args[0]="VensimExampleModels/SHODOR/alreadyCommented.mdl";
        args[1]="outputs/comment/test6.mdl";
        BufferedReader reader;
        try {
            Comment.main(args);
            reader = new BufferedReader(new FileReader("VensimExampleModels/SHODOR/alreadyCommented.mdl"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            assertEquals(139,lines); //Last newline is not counted

            reader = new BufferedReader(new FileReader("outputs/comment/test6.mdl"));
            Set<Integer> positions1 = new HashSet<Integer>();
            positions1.addAll(Arrays.asList(new Integer[] {3, 7, 13, 19, 26, 33, 39, 45})); 
            for(int i=0;i<50;i++){
                String line = reader.readLine();
                if(positions1.contains(i)){
                    String subline = line.substring(11);
                    assertTrue(subline.indexOf("<[VIEW]>:")==-1);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lecturaIncorrecta(){
        String[] args = new String[2];
        args[0]="VensimExampleModels/SHODOR/jeokdfjf.mdl";
        args[1]="outputs/comment/testFail.mdl";
        assertThrows(IOException.class, () -> {
			Comment.main(args);
		});

    }
}
