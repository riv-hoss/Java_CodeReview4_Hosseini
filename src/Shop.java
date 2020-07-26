
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Scanner;

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
    public void addProduct (Product product) throws StockLimitReachedException{
        if (inventory.contains(product)) {
            for (Product p : inventory) {
                if (p.equals(product)) {
                    int currentQuantity =  p.getProductQuantity();
                    int newlyAddedQuantity = product.getProductQuantity();
                    try {
                        p.setProductQuantity(currentQuantity + newlyAddedQuantity);
                    } catch (Exception e) {
                        System.out.println("An error occurred in addProduct method()!");
                        System.out.println(e.getMessage());

                    }
                }
            }

        } else {
            if ( product.getProductQuantity() <= 15) {
                inventory.add(product);
            } else {
                throw new StockLimitReachedException("More than 15 items cannot be added!");
            }
        }


       /* if (inventory.isEmpty()) {
            if ( product.getProductQuantity() <= 15) {
                inventory.add(product);
            }

        } else { // if inventory is not empty

                if (inventory.contains(product)) {
                    for (Product p : inventory ) {
                        if (p.equals(product)) {
                            int currentQuantity =  p.getProductQuantity();
                            int newlyAddedQuantity = product.getProductQuantity();
                            try {
                                p.setProductQuantity(currentQuantity + newlyAddedQuantity);
                            } catch (Exception e) {
                                System.out.println("An error occurred in addProduct method()!");
                                e.printStackTrace();

                            }

                        }
                    }

                } else {
                    if ( product.getProductQuantity() <= 15) {
                        inventory.add(product);
                    } else {
                    }
                }



        }
*/

    }

    // method - sell item
    public void sellItem (User user, Product item, int quantity) {
        if (inventory.contains(item)) { // check if item is available in the shop

            for (Product product : inventory) {
                if (product.equals(item)) { // override equals() method in Product class
                    int currentQuantity = product.getProductQuantity();
                    int newQuantity = currentQuantity - quantity;
                    PurchaseHistory hist = new PurchaseHistory(new Date(), product, quantity);
                    history.put(user.getId(), hist); // add new purchase history

                    try {
                        product.setProductQuantity(newQuantity);
                    } catch (Exception e) {
                        System.out.print("An error occurred in sellProduct method()!");
                        e.printStackTrace();

                    }

                    if (!registeredUsers.contains(user)) { // add new user
                        registeredUsers.add(user);
                    }
                }
            }

        } else { // if shop does not contain the item
            System.err.printf("%nNo %s with ID %d are available now! %n",
                    item.getProductCategory(), item.getProductId());
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
        if (!lowStockItems.isEmpty()) { // if there is a low stock item
            System.out.println("****** Low stock items ******");
            for (Product p : lowStockItems) {
                System.out.printf("%-20s %d items%n",
                        p.getProductName(), p.getProductQuantity());
            }
            System.out.println("*****************************");

        } else {
            System.out.println("******* We have everything is stock! ********");
        }
    }



    // menu method
    public void menu () throws Exception {
        String hLine = "\n+" + "-".repeat(31) + "+";
        String welcome = "\n|\t\t\t Welcome \t\t\t|";
        String toThe = "\n|\t\t\t to the \t\t\t|";
        String shop = "\n|\t\t\t shop \t\t\t\t|";
        System.out.println(hLine + welcome + toThe + shop + hLine);

        System.out.println("\n\nMake a selection: " +
                "\n1) Display all products. " +
                "\n2) Display all products of category T-shirts." +
                "\n3) Display all products of category Trousers." +
                "\n4) Display all products of category Shirts." +
                "\n5) Display all products of category Jackets." +
                "\n6) Display all products of category Accessories." +
                "\n7) Display all products where stock < 5. " +
                "\n8) Display all products out of stock. " +
                "\n9) Display all registered users. " +
                "\n0) Exit.");

        Scanner in = new Scanner(System.in);
        System.out.print("\n\nEnter your choice: ");
        if (!in.hasNextInt()) {
            System.err.println("Enter only a number!");
            throw new Exception();

        }
        int i = in.nextInt();

        switch (i) {
            case 1:
                System.out.println(inventory);
                break;
            case 2:
                for (Product p : inventory) {
                    if (p.getProductCategory().equals(Category.Tshirts)) {
                        System.out.println(p);
                    }
                }
                break;
            case 3:
                for (Product p : inventory) {
                    if (p.getProductCategory().equals(Category.Trousers)) {
                        System.out.println(p);
                    }
                }
                break;
            case 4:
                for (Product p : inventory) {
                    if (p.getProductCategory().equals(Category.Shirts)) {
                        System.out.println(p);
                    }
                }
                break;
            case 5:
                for (Product p : inventory) {
                    if (p.getProductCategory().equals(Category.Jackets)) {
                        System.out.println(p);
                    }
                }
                break;
            case 6:
                for (Product p : inventory) {
                    if (p.getProductCategory().equals(Category.Accessories)) {
                        System.out.println(p);
                    }
                }
                break;
            case 7:
                this.showLowStock();
                break;
            case 8:
                for (Product p : inventory) {
                    if (p.getProductQuantity() == 0) {
                        System.out.println(p);
                    }
                }
                break;
            case 9:
                System.out.println("ID\t\t Name\t\t\t\t\t E-Mail \t\t\t\t\t\t Address \t\t\t\t\tTell");
                System.out.println("-".repeat(100));
                for (User u : registeredUsers) {
                    String userDisplay = String.format("%-5d %-20s %-30s %-30s %-20s", u.getId(),
                            u.getFullName(), u.geteMail(), u.getFullAddress(), u.getPhone());
                    System.out.println(userDisplay);
                }
                System.out.println("*".repeat(100));
                break;
            case 0:
                break;
            default:
                System.err.println("Only a number between 0 - 4 should be selected!");
                throw new IllegalArgumentException();
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
