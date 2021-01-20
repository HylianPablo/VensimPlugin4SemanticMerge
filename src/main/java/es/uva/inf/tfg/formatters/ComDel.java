package es.uva.inf.tfg.formatters;

import java.io.IOException;

public class ComDel {
    public static void main(String args[]) {
        try {
            String[] arg1 = new String[2];
            arg1[0] = args[0];
            arg1[1] = args[0];
            Comment.main(arg1);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        String[] arg2 = new String[2];
        arg2[0] = args[0];
        arg2[1] = args[0];
        Delimiter.main(arg2);
    }
}
