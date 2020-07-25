
import java.util.ArrayList;

public class Shop {
    private String name;
    private String address;
    private ArrayList<Product> inventory = new ArrayList<>();

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Product> getInventory() {
        return inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInventory(ArrayList<Product> inventory) {
        this.inventory = inventory;
    }


    // method add product to shop
    public void addProduct (Product p) {
        this.inventory.add(p);
    }

    // method - sell item
    public void sellItem (User user, Category item, int quantity) {
        for (Product product : inventory) {
            if (product.getProductCategory().equals(item)) {
                int currentQuantity = product.getProductQuantity();
                int newQuantity = currentQuantity - quantity;
                product.setProductQuantity(newQuantity);
            } else {
                System.err.printf("%nNo %s are available now! %n", item);

            }
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
