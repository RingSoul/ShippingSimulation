public class Package {
    // instance variable
    private Address origin;
    private Address destination;
    private double weight; // as lb, no less than 1/10 lb

    // constructor?
    public Package(Address origin, Address destination, double weight)
    {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    // methods
    // accessor methods
    public Address getOrigin()
    {
        return origin;
    }
    public Address getDestination()
    {
        return destination;
    }
    public double getWeight()
    {
        return weight;
    }
}
