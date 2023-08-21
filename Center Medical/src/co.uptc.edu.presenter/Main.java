 public class Main {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        View view = new View(presenter);
        presenter.setView(view);  
        view.start();
    }
}