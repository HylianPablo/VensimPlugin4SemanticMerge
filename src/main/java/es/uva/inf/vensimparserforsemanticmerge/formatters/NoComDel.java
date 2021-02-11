package es.uva.inf.vensimparserforsemanticmerge.formatters;

public class NoComDel {
    public static void main(String args[]) {
        try {
            String[] arg1 = new String[2];
            arg1[0] = args[0];
            arg1[1] = args[0];
            NoComments.main(arg1);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        String[] arg2 = new String[2];
        arg2[0] = args[0];
        arg2[1] = args[0];
        NoDelimiters.main(arg2);
    }
}
