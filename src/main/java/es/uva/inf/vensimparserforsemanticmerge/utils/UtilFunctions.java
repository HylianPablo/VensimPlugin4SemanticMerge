package es.uva.inf.vensimparserforsemanticmerge.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UtilFunctions {
    /**
     * Counts the number of lines of a file.
     * @param input Relative URI of the file to be read.
     * @return Integer number which represents the number of lines of the file.
     */
    public static int countFileLines(String input) {
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            while (reader.readLine() != null)
                lines++;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Checks which equations have a blank newline ofter its definition.
     * @param input Relative URI of the file to be read.
     * @return List which elements are boolean values that indicates if the equation has a newline after its definition ({@code true}), or not ({@code false}).
     */
    public static ArrayList<Boolean> checkForNewLines(String input) {
        ArrayList<Boolean> array = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String line;
            while (true) {
                line = reader.readLine();
                if (line.indexOf("\t.Control") != -1) {
                    break;
                } else if (line.indexOf("|") != -1) {
                    String nextLine = reader.readLine();
                    array.add(nextLine.trim().isEmpty());
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Check which elements of equations field are macros.
     * @param input Relative URI of the file to be read.
     * @return List which elements are boolean values that indicates if the equation element is a macro definition ({@code true}), or not ({@code false}).
     */
    public static ArrayList<Boolean> checkForMacros(String input) {
        ArrayList<Boolean> array = new ArrayList<>();
        try {
            String text = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);
            String[] noControl = text.split("\\\\\\---", 2);
            String[] equations = noControl[0].split("\\|");
            for (int i = 0; i < equations.length; i++) {
                array.add(equations[i].indexOf(":MACRO:") != -1);
            }
            for (int i = 0; i < 4; i++) { // TIME STEP equations
                array.add(false);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return array;
    }

    /**
     * Counts the number of lines in a text until it reaches a certain expression.
     * @param text Text to be read. Plain text.
     * @param line Expression to be found. It is not a regular expression, it is simply plain text.
     * @return Integer number which represents the number of lines in the text until the expression is found.
     */
    public static int linesUntilText(String text, String line) {
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains(line)) {
                return (i + 1);
            }
        }
        return -1;
    }

    /**
     * Calculates the n index of a certain substring in a String
     * @param str String where to search the substring.
     * @param substr String to be found.
     * @param n Index of occurrence of the substring.
     * @return Index in the String passed as an argument.
     */
    public static int ordinalIndexOf(String str, String substr, int n) {
        int pos = -1;
        do {
            pos = str.indexOf(substr, pos + 1);
        } while (n-- > 0 && pos != -1);
        return pos;
    }

    //método para calcular el número de veces que se repite un carácter en un String

    /**
     * Counts the number of occurrences of a character in a String.
     * @param str String where to search the number of occurrences of a character.
     * @param character Character to be found.
     * @return Integer number that represents the number of occurrences of the character.
     */
    public static int countCharacters(String str, char character) {
        int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = str.indexOf(character);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++; //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada
            posicion = str.indexOf(character, posicion + 1);
        }
        return contador;
    }
}
