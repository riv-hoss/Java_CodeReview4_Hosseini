import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    // add product to the shop
        String lineBr = "=".repeat(40);
        System.out.printf("%n%s creating product/shop objects, add" +
                " product to shop, and test limit 15 %s %n", lineBr, lineBr);

        // max limit test
        Product prdLimit = new Product("T-Shirt", "Linen High Quality T-Shirt",
                16, 12.5, Category.Tshirts);

        Product prd02 = new Product("T-Shirt", "Linen High Quality T-Shirt",
                10, 12.5, Category.Tshirts);
        Product prd03 = new Product("Trouser", "Best Quality in town.",
                14, 66.99, Category.Trousers);
        Product prd04 = new Product("Jacket", "With wool inside",
                8, 89.99, Category.Jackets);

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
        System.out.println(shop01);
        System.out.println("----- Shop01 AFTER adding a product -----");
        shop01.addProduct(prd02);
        System.out.println(shop01);


        // creating users and add them to a HashMap
        User user1 = new User("Michael", "Jack-Daughter",
                "mjack@beatit.com","Java-strasse 11", 1050,"06662223344");
        User user2 = new User("Clint", "EastBush",
                "easetbush@dollarfist.com","Class-gasse 9", 1110,"0664789834");
        User user3 = new User("Tom", "Softy",
                "tomsoft@venom.com","Abstract-strasse 23", 2222,"+19839489");

        HashMap<Integer, User> users = new HashMap()
        {{
            put(user1.getId(), user1);
            put(user2.getId(), user2);
            put(user3.getId(), user3);
        }};







    }
}
