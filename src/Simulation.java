import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) {
        ArrayList<Package> packages = new ArrayList<Package>();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("1. Enter address information piece by piece\n2. Enter address in one single line (must have the accurate format)\nEnter a number (or -1 to quit): ");
            int option = s.nextInt();
            if (option == 1) {
                System.out.print("Origin street number: ");
                System.out.print("Origin street name: ");
                System.out.print("Origin apartment number (optional): ");
                System.out.print("Origin city: ");
                System.out.print("Origin state: ");
                System.out.print("Origin zip code: ");
                System.out.print("Destination street number: ");
                System.out.print("Destination street name: ");
                System.out.print("");
                System.out.print("");
                System.out.print("");
                System.out.print("");
            } else if (option == 2) {

            } else if (option == -1)  {
                System.out.println("Bye");
                break;
            }
        }
    }
}
