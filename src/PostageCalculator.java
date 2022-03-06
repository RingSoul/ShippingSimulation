public class PostageCalculator {
    // utility class? -- static library
    public static double calculatePostage(Package p)
    {
        double cost = 3.75; // initialized with base price
        cost += (int) (p.getWeight() / 0.1) * 0.05; // 10th of a pound changed to int for rounding down
        int originCountyCode = p.getOrigin().getZipCode() / 100; // eliminates last two digits
        int destinationCountyCode = p.getDestination().getZipCode() / 100; // eliminates last two digits
        cost += Math.abs(originCountyCode - destinationCountyCode) / 100.0; // (+) difference divided by 100
        return cost;
    }

    public static double calculatePostage(int zipCode1, int zipCode2, double weight)
    {
        double cost = 3.75;
        cost += (int) (weight / 0.1) * 0.05; // 10th of a pound changed to int for rounding down
        int originCountyCode = zipCode1 / 100; // eliminates last two digits
        int destinationCountyCode = zipCode2 / 100; // eliminates last two digits
        cost += Math.abs(originCountyCode - destinationCountyCode) / 100.0; // (+) difference divided by 100
        return cost;
    }

    public static double calculatePostage(Address a1, Address a2, double weight)
    {
        double cost = 3.75;
        cost += (int) (weight / 0.1) * 0.05; // 10th of a pound changed to int for rounding down
        int originCountyCode = a1.getZipCode() / 100; // eliminates last two digits
        int destinationCountyCode = a2.getZipCode() / 100; // eliminates last two digits
        cost += Math.abs(originCountyCode - destinationCountyCode) / 100.0; // (+) difference divided by 100
        return cost;
    }
}
