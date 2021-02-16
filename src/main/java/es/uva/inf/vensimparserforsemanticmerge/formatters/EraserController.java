package es.uva.inf.vensimparserforsemanticmerge.formatters;

public class EraserController {

    private DelimiterEraserGUI view;

    public EraserController(DelimiterEraserGUI v) {
        view = v;
    }

    public void checkAction(String com) {
        if (com.equals("Process")) {
            view.processAction();
        } else if (com.equals("Open file")) {
            view.openAction();
        } else if (com.equals("Cancel")) {
            view.cancelAction();
        } else if (com.equals("Show absolute path") || com.equals("Show name without name")) {
            view.pathAction();
        }
    }

    public void processFile(String args[]) {
        try {
            String[] arg1 = new String[2];
            arg1[0] = args[0];
            arg1[1] = args[0];
            NoComments.eraseComments(arg1);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        String[] arg2 = new String[2];
        arg2[0] = args[0];
        arg2[1] = args[0];
        NoDelimiters.eraseDelimiters(arg2);
    }
}
