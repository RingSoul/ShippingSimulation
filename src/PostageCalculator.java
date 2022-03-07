public class PostageCalculator {

    // utility class? -- static library

    public static double calculatePostage(Package p) // updated with enhancement
    {
        double cost = 3.75; // initialized with base price
        if (!p.isOversized()) { // if not oversized, no change besides possible overweighted is needed
            if (!p.isOverweighted()) { // not overweighted = no change
                cost += (int) (p.getWeight() / 0.1) * 0.05; // 10th of a pound changed to int for rounding down

            } else { // overweighted
                cost += (40 / 0.1) * 0.05; // overweighted guaranteed
                cost += (int) ((p.getWeight() - 40) / 0.1) * 0.1; // 10th of a pound changed to int for rounding down
            }
            int originCountyCode = p.getOrigin().getZipCode() / 100; // eliminates last two digits
            int destinationCountyCode = p.getDestination().getZipCode() / 100; // eliminates last two digits
            cost += Math.abs(originCountyCode - destinationCountyCode) / 100.0; // (+) difference divided by 100.0
            return cost;
        } else { // oversized
            int extra = (int) (((2 * (p.getHeight() + p.getWidth())) + p.getLength()) - 36); // size = girth + length, extra = size - 36, cast to int for round down
            cost += extra * 0.1;
            if (!p.isOverweighted()) { // not overweighted = no change
                cost += (int) (p.getWeight() / 0.1) * 0.05; // 10th of a pound changed to int for rounding down

            } else { // overweighted
                cost += (40 / 0.1) * 0.05; // overweighted guaranteed
                cost += (int) ((p.getWeight() - 40) / 0.1) * 0.1; // 10th of a pound changed to int for rounding down
            }
            int originCountyCode = p.getOrigin().getZipCode() / 100; // eliminates last two digits
            int destinationCountyCode = p.getDestination().getZipCode() / 100; // eliminates last two digits
            cost += Math.abs(originCountyCode - destinationCountyCode) / 100.0; // (+) difference divided by 100.0
            return cost;
        }
    }







    public static double calculatePostage(int zipCode1, int zipCode2, double weight) // not updated with enhancement
    {
        double cost = 3.75;
        cost += (int) (weight / 0.1) * 0.05; // 10th of a pound changed to int for rounding down
        int originCountyCode = zipCode1 / 100; // eliminates last two digits
        int destinationCountyCode = zipCode2 / 100; // eliminates last two digits
        cost += Math.abs(originCountyCode - destinationCountyCode) / 100.0; // (+) difference divided by 100
        return cost;
    }

    public static double calculatePostage(Address a1, Address a2, double weight) // not updated with enhancement
    {
        double cost = 3.75;
        cost += (int) (weight / 0.1) * 0.05; // 10th of a pound changed to int for rounding down
        int originCountyCode = a1.getZipCode() / 100; // eliminates last two digits
        int destinationCountyCode = a2.getZipCode() / 100; // eliminates last two digits
        cost += Math.abs(originCountyCode - destinationCountyCode) / 100.0; // (+) difference divided by 100
        return cost;
    }
}
