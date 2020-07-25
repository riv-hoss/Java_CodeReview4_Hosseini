
import javax.lang.model.type.ArrayType;
import java.util.Scanner;

public class UserInterface {

    public void menu () throws Exception {
        String hLine = "\n+" + "-".repeat(31) + "+";
        String welcome = "\n|\t\t\t Welcome \t\t\t|";
        String toThe = "\n|\t\t\t to the \t\t\t|";
        String shop = "\n|\t\t\t shop \t\t\t\t|";
        System.out.println(hLine + welcome + toThe + shop + hLine);

        System.out.println("\n\nMake a selection: \n1) Perform action 1. " +
                "\n2) Perform action 2. \n3) Perform action 3. " +
                "\n4) Perform action 4. \n0) Exit.");

        Scanner in = new Scanner(System.in);
        System.out.print("\n\nEnter your choice: ");
        if (!in.hasNextInt()) {
            System.err.println("Enter only a number!");
            throw new Exception();

        }
        int i = in.nextInt();

        switch (i) {
            case 1:
                System.out.println("Display all products.");
                break;
            case 2:
                System.out.println("Action 2 selected!");
                break;
            case 3:
                System.out.println("Action 3 selected!");
                break;
            case 4:
                System.out.println("Action 4 selected!");
                break;
            default:
                System.err.println("Only a number between 0 - 4 should be selected!");
                throw new IllegalArgumentException();
        }
    }
}
