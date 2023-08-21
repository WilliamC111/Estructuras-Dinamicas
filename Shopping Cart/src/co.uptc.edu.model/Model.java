
import java.util.Vector;

public class Model {
    private Vector<Article> cartArticles = new Vector<>();

    public void addArticle(Article article) {
        cartArticles.add(article);
    }

    public Vector<Article> getCartArticles() {
        return cartArticles;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Article article : cartArticles) {
            totalPrice += article.getPrice();
        }
        return totalPrice;
    }

}
