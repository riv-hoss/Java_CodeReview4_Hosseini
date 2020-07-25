
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class Shop {
    private String name;
    private String address;
    private ArrayList<Product> inventory = new ArrayList<>();
    private HashMap<Integer, PurchaseHistory> history = new HashMap<>();
    private ArrayList<User> registeredUsers = new ArrayList<>();

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

    public HashMap<Integer, PurchaseHistory> getHistory() {
        return history;
    }

    public ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }

    // method add product to shop
    public void addProduct (Product p) {
        this.inventory.add(p);
    }

    // method - sell item
    public void sellItem (User user, Product item, int quantity) {
        for (Product product : inventory) {
            if (product.equals(item)) { // override equals() method in Product class
                int currentQuantity = product.getProductQuantity();
                int newQuantity = currentQuantity - quantity;
                PurchaseHistory hist = new PurchaseHistory(new Date(), product, quantity);
                history.put(user.getId(), hist); // add new purchase history
                product.setProductQuantity(newQuantity);
                if (!registeredUsers.contains(user)) { // add new user
                    registeredUsers.add(user);
                }
            } else {
                System.err.printf("%nNo %s with ID %d are available now! %n",
                        item.getProductCategory(), item.getProductId());
            }
        }
    }


    // method for showing low stock items
    public void showLowStock () {
        ArrayList<Product> lowStockItems = new ArrayList<>();
        for (Product p : inventory) {
            if (p.getProductQuantity() < 5) {
                lowStockItems.add(p);
            }
        }
        for (Product p : lowStockItems) {
            System.out.printf("%n***** Low stock items ***** %n%20s %d items",
                    p.getProductName(), p.getProductQuantity());
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
