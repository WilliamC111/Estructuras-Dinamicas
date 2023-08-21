public class Main {
    public static void main(String[] args) {
        Model cartModel = new Model();
        View cartView = new View();
        Presenter presenter = new Presenter(cartModel, cartView);

        presenter.showView();
    }
}
