import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Expressions model = new Expressions();
                View view = new View();
                Presenter presenter = new Presenter(view, model);

                view.setVisible(true);
            }
        });
    }
}
