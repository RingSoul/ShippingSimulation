public class Package {
    // instance variable
    private Address origin;
    private Address destination;
    private double weight; // as lb, no less than 1/10 lb
    private double height; // as in, cannot be less than 2 in
    private double width; // as in, cannot be less than 2 in
    private double length; // as in, cannot be less than 2 in

    // constructor?
    public Package(Address origin, Address destination, double weight, double h, double l, double w)
    {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        height = h;
        length = l;
        width = w;
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
    public double getHeight() { return height; }
    public double getLength() { return length; }
    public double getWidth() {
        return width;
    }

    public boolean isOversized()
    {
        double girth = 2 * (height + width); // according to research, size depends on girth (perimeter in terms of height and width)
        return (length + girth) > 36; // true if oversized, false otherwise
    }

    public boolean isOverweighted()
    {
        return weight > 40; // true if overweighted, false otherwise
    }

    public String toString()
    {
        String infos = "Origin: " + origin;
        infos += "\nDestination: " + destination;
        infos += "\nWeight: " + weight + " lb";
        infos += "\nHeight: " + height + " in";
        infos += "\nLength: " + length + " in";
        infos += "\nWidth: " + width + " in";
        infos += "\nOversized?: " + isOversized();
        infos += "\nOverweighted?: " + isOverweighted();
        return infos;
    }
}
