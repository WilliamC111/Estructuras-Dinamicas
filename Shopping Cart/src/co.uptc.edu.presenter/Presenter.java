import javax.swing.*;
import java.util.Vector;

public class Presenter {
    private Model cartModel;
    private View cartView;

    public Presenter(Model cartModel, View cartView) {
        this.cartModel = cartModel;
        this.cartView = cartView;
        this.cartView.setPresenter(this);
    }

    public void addArticleButtonClicked() {
        try {
            String articleName = JOptionPane.showInputDialog(cartView, "Nombre del artículo:");
            String priceStr = JOptionPane.showInputDialog(cartView, "Precio del artículo:");
            double price = Double.parseDouble(priceStr);

            Article newArticle = new Article(articleName, price);
            cartModel.addArticle(newArticle);

            updateView();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(cartView, "Precio inválido. Ingrese un número válido.");
        }
    }

    private void updateView() {
        Vector<Article> articles = cartModel.getCartArticles();
        Vector<String> articleStrings = new Vector<>();
        for (Article item : articles) {
            articleStrings.add(item.getName() + " - $" + item.getPrice());
        }

        cartView.updateArticleList(articleStrings);
        cartView.updateTotalPrice(cartModel.getTotalPrice());
    }

    public void showView() {
        cartView.setVisible(true);
    }
}

