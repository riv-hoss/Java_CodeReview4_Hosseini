import java.util.Date;
public class PurchaseHistory {
    private Date date;
    private Product product;
    private int quantity;

    public PurchaseHistory(Date date, Product product, int quantity) {
        this.date = date;
        this.product = product;
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "PurchaseHistory{" +
                "date=" + date +
                ", product=" + product.getProductName() +
                ", quantity=" + quantity +
                '}';
    }
}
