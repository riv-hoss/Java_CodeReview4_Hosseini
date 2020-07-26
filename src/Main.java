import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    // add product to the shop
        String lineBr = "=".repeat(40);
        System.out.printf("%n%s creating product/shop objects, add" +
                " product to shop, and test limit 15 %s %n%n", lineBr, lineBr);


        // max limit test
        System.out.println("***** Limit is 15, so 16 T-shirts cannot be added *****");
        Product prdLimit = new Product("T-Shirt", "Linen High Quality T-Shirt",
                16, 12.5, Category.Tshirts);
        System.out.println("*".repeat(55) + "\n");


        Product prd02 = new Product("T-Shirt", "Linen High Quality T-Shirt",
                10, 12.5, Category.Tshirts);
        Product prd03 = new Product("Trouser", "Best Quality in town.",
                4, 66.99, Category.Trousers);
        Product prd04 = new Product("Jacket", "With wool inside",
                3, 89.99, Category.Jackets);
        Product prd05 = new Product("Accessories", "Nice ones",
                15, 2.99, Category.Accessories);
        Product prd06 = new Product("Gold necklace", "Fashion ace",
                0, 10.99, Category.Accessories);
        Product prd07 = new Product("Polo-shirts", "RL",
                0, 23.99, Category.Shirts);

        // products HashMap
        HashMap<Integer, Product> products = new HashMap()
        {{
            put(prd02.getProductId(), prd02);
            put(prd03.getProductId(), prd03);
            put(prd04.getProductId(), prd04);
        }};

        // creating shop object and add products
        Shop shop01 = new Shop("Java Tomato", "Java-Strasse 11, 1111, JDK");
        System.out.println("----- Shop01 BEFORE adding a product -----");
        System.out.println(shop01 + "\n");
        System.out.println("----- Shop01 AFTER adding a product / quantity is 10-----");
        try{
            shop01.addProduct(prd02);
        } catch ( Exception e) {
            e.printStackTrace();
        }

        System.out.println(shop01 + "\n");

        // new shop
        Shop shop02 = new Shop("Java/Kardon", "Java Platz 8, 9191, New Java City");
        try {
            shop02.addProduct(prd02);
            shop02.addProduct(prd03);
            shop02.addProduct(prd04);
            shop02.addProduct(prd05);
            shop02.addProduct(prd06);
            shop02.addProduct(prd07);
        } catch (Exception e) {
            e.printStackTrace();
        }




        // creating users and add them to a HashMap
        User user01 = new User("Michael", "Jack-Daughter",
                "mjack@beatit.com","Java-strasse 11", 1050,"06662223344");
        User user02 = new User("Clint", "EastBush",
                "easetbush@dollarfist.com","Class-gasse 9", 1110,"0664789834");
        User user03 = new User("Tom", "Softy",
                "tomsoft@venom.com","Abstract-strasse 23", 2222,"+19839489");

        HashMap<Integer, User> users = new HashMap()
        {{
            put(user01.getId(), user01);
            put(user02.getId(), user02);
            put(user03.getId(), user03);
        }};

        System.out.println("\n---------- user01 object ----------");
        System.out.println(user01);



        // purchase process demo
        System.out.printf("%n%s purchase process demo %s %n", lineBr, lineBr);

        System.out.println("***Check 'user01' and also inventory of 'Shop01' above!***");
        System.out.println("\n---------- shop01 history BEFORE purchase is empty ----------");
        System.out.println(shop01.getHistory());
        shop01.sellItem(user01, prd02, 2);

        System.out.println("\n---------- shop01 history AFTER purchase being populated ----------");
        System.out.println(shop01.getHistory());

        System.out.println("\n----- Shop01 AFTER purchase / quantity is now 8 -----");
        System.out.println(shop01 + "\n");




        // low stock demo
        System.out.printf("%n%s low stock demo %s %n", lineBr, lineBr);
        shop02.showLowStock();

        System.out.printf("%n%s Staff cannot add more than 13 stock %s %n", lineBr, lineBr);
        System.out.println("\n----- Shop02 inventory has 15 Accessories -----");
        System.out.println(shop02.getInventory());


        System.out.println("\n----- Shop02 stock of Accessories is full, staff cannot add more -----");
        try {
            shop02.addProduct(prd05);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // trying menu method
        System.out.printf("%n%s========== Menu Demo ==========%s %n", lineBr, lineBr);

        // user02 and user03 buy items from shop02
        shop02.sellItem(user02, prd03,1);
        shop02.sellItem(user03, prd04,1);






        try {
            shop02.menu();
        } catch (Exception e) {
            System.out.println("An error occurred in calling menu() method of Shop class!");
            e.printStackTrace();
        }




    }
}
