import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Package> packages = new ArrayList<Package>();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("1. Enter address information piece by piece\n2. Enter address in one single line (must have the accurate format)\n3. See all current packages simulated\nEnter a number (or -1 to quit): ");
            int option = s.nextInt();
            s.nextLine(); // wow, how does this work, cannot understand
            if (option == 1) {
                System.out.print("Origin street number: ");
                String oSNum = s.nextLine();
                System.out.print("Origin street name: ");
                String oSName = s.nextLine();

                System.out.print("Origin apartment number (optional) (format: \"Apt **\"): ");
                String oANum = s.nextLine();
                System.out.print("Origin city: ");
                String oCity = s.nextLine();
                System.out.print("Origin state: ");
                String oState = s.nextLine();
                int oZipCode = 0;
                while (oZipCode == 0) {
                    System.out.print("Origin zip code (five digit number): ");
                    oZipCode = s.nextInt();
                    if ((oZipCode + "").length() != 5) {
                        oZipCode = 0;
                        System.out.println("Invalid");
                    }
                }
                Address origin = new Address(oSNum, oSName, oANum, oCity, oState, oZipCode);

                System.out.print("Destination street number: ");
                String dSNum = s.next();
                s.nextLine();
                System.out.print("Destination street name: ");
                String dSName = s.nextLine();
                System.out.print("Destination apartment number (option) (format: \"Apt **\"): ");
                String dANum = s.nextLine();
                System.out.print("Destination city: ");
                String dCity = s.nextLine();
                System.out.print("Destination state: ");
                String dState = s.nextLine();
                int dZipCode = 0;
                while (dZipCode == 0) {
                    System.out.print("Destination zip code (five digit number): ");
                    dZipCode = s.nextInt();
                    if ((dZipCode + "").length() != 5) {
                        dZipCode = 0;
                        System.out.println("Invalid");
                    }
                }
                Address destination = new Address(dSNum, dSName, dANum, dCity, dState, dZipCode);

                double weight = 0.0;
                while (weight == 0.0)
                {
                    System.out.print("Weight (in pound): ");
                    weight = s.nextDouble();
                    if (weight < 0.1)
                    {
                        weight = 0.0;
                        System.out.println("Weight must be no less than 0.1 lb");
                    }
                }

                double height = 0;
                while (height == 0)
                {
                    System.out.print("Height (in inch): ");
                    height = s.nextDouble();
                    if (height < 2)
                    {
                        height = 0;
                        System.out.println("Height/Length/Width must be no less than 2 in");
                    }
                }

                double length = 0;
                while (length == 0)
                {
                    System.out.print("Length (in inch): ");
                    length = s.nextDouble();
                    if (length < 2)
                    {
                        length = 0;
                        System.out.println("Height/Length/Width must be no less than 2 in");
                    }
                }

                double width = 0;
                while (width == 0)
                {
                    System.out.print("Width (in inch): ");
                    width = s.nextDouble();
                    if (width < 2)
                    {
                        width = 0;
                        System.out.println("Height/Length/Width must be no less than 2 in");
                    }
                }


                System.out.println("--------------------------------");
                Package p = new Package(origin, destination, weight, height, length, width);
                packages.add(p);
                double postage = PostageCalculator.calculatePostage(p);
                System.out.println("Origin: " + p.getOrigin());
                System.out.println("Destination: " + p.getDestination());
                System.out.println("Weight: " + p.getWeight() + " lb");
                System.out.println("Height: " + p.getHeight() + " in");
                System.out.println("Length: " + p.getLength() + " in");
                System.out.println("Width: " + p.getWidth() + " in");
                System.out.println("Resulting Postage: $" + postage);
                if (p.getOrigin().isSameAddress(p.getDestination()))
                {
                    System.out.println("***Don't know why you want to ship between two same addresses but okay.");
                }
                System.out.println("--------------------------------");
                System.out.println();
            } else if (option == 2) {
                System.out.println();
                System.out.println("Accurate format: \"Number Street Apt Number (optional), City, State Zip\"");
                System.out.print("Origin: ");
                String origin = s.nextLine();
                Address originAddress = new Address(origin);
                System.out.print("Destination: ");
                String destination = s.nextLine();
                Address destinationAddress = new Address(destination);
                double weight = 0.0;
                while (weight == 0.0)
                {
                    System.out.print("Weight (in pound): ");
                    weight = s.nextDouble();
                    if (weight < 0.1)
                    {
                        weight = 0.0;
                        System.out.println("Weight must be no less than 0.1 lb");
                    }
                }

                double height = 0;
                while (height == 0)
                {
                    System.out.print("Height (in inch): ");
                    height = s.nextDouble();
                    if (height < 2)
                    {
                        height = 0;
                        System.out.println("Height/Length/Width must be no less than 2 in");
                    }
                }

                double length = 0;
                while (length == 0)
                {
                    System.out.print("Length (in inch): ");
                    length = s.nextDouble();
                    if (length < 2)
                    {
                        length = 0;
                        System.out.println("Height/Length/Width must be no less than 2 in");
                    }
                }

                double width = 0;
                while (width == 0)
                {
                    System.out.print("Width (in inch): ");
                    width = s.nextDouble();
                    if (width < 2)
                    {
                        width = 0;
                        System.out.println("Height/Length/Width must be no less than 2 in");
                    }
                }
                Package p = new Package(originAddress, destinationAddress, weight, height, length, width);
                packages.add(p);
                double cost = PostageCalculator.calculatePostage(p);
                System.out.println("--------------------------------");
                System.out.println("Origin: " + p.getOrigin());
                System.out.println("Destination: " + p.getDestination());
                System.out.println("Weight: " + p.getWeight() + " lb");
                System.out.println("Height: " + p.getHeight() + " in");
                System.out.println("Length: " + p.getLength() + " in");
                System.out.println("Width: " + p.getWidth() + " in");
                System.out.println("Result Postage: $" + cost);
                if (p.getOrigin().isSameAddress(p.getDestination()))
                {
                    System.out.println("***Don't know why you want to ship between two same addresses but okay.");
                }
                System.out.println("--------------------------------");
            } else if (option == 3) {
                System.out.println("--------------------------------");
                int num = 1;
                for (Package p : packages)
                {
                    System.out.println(num + ".");
                    System.out.println(p);
                    num++;
                }
                System.out.println("--------------------------------");
            } else if (option == -1)  {
                System.out.println("Bye");
                s.close();
                break;
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
