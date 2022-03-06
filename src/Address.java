import java.util.ArrayList;

public class Address {
    // instance variables
    private String streetNum; // can contain letters
    private String streetName;
    private String apartmentNum; // option, can be empty String literal
    private String city;
    private String state;
    private int zipCode; // 5 digits



    // constructors
    public Address(String streetNum, String streetName, String apartmentNum, String city, String state, int zipCode)
    {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.apartmentNum = apartmentNum;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    public Address(Address a)
    {
        streetNum = a.getStreetNum();
        streetName = a.getStreetName();
        apartmentNum = a.getApartmentNum();
        city = a.getCity();
        state = a.getState();
        zipCode = a.getZipCode();
    }
    public Address(String address)
    {
        ArrayList<String> infos = new ArrayList<String>();
        for (int i = address.indexOf(" "); i != -1; i = address.indexOf(" "))
        {
            String info = address.substring(0, i);
            infos.add(info);
            address = address.substring(i+1);
        }
        infos.add(address); // zipCode info is always missed since no more space is detected

        streetNum = infos.get(0); // streetNum always the first one
        // streetName & possible apartmentNum
        streetName = "";
        apartmentNum = "";
        boolean hasAptNum = false;
        int aptIndex = -1;
        int firstCommaIndex = -1;
        for (int i = 0; i < infos.size(); i++)
        {
            if (infos.get(i).indexOf("Apt") != -1) // assuming apartmentNum always contains "Apt"
            {
                hasAptNum = true;
                aptIndex = i;
            }
            if (firstCommaIndex == -1 && infos.get(i).indexOf(",") != -1)
            {
                firstCommaIndex = i;
            }
        }
        if (hasAptNum)
        {
            for (int i = 1; i < aptIndex; i++) // after 0 (streetNum); before apartmentNum
            {
                streetName += infos.get(i) + " ";
            }
            streetName = streetName.substring(0, streetName.length() - 1); // last space = extra
            for (int i = aptIndex; i <= firstCommaIndex; i++) // between aptIndex and firstCommaIndex inclusive, is the apartmentNum
            {
                apartmentNum += infos.get(i) + " ";
            }
            apartmentNum = apartmentNum.substring(0, apartmentNum.length() - 2); // eliminate extra comma and space
        }
        else // if no apartmentNum
        {
            for (int i = 1; i <= firstCommaIndex; i++) // after 0 (streetNum), towards firstCommaIndex and inclusive of it, is the streetName
            {
                streetName += infos.get(i) + " ";
            }
            streetName = streetName.substring(0, streetName.length() - 2);
        }
        // city
        city = "";
        int secondCommaIndex = -1; // from first comma to second comma is the city
        for (int i = firstCommaIndex + 1; i < infos.size(); i++)
        {
            if (secondCommaIndex == -1 && infos.get(i).indexOf(",") != -1)
            {
                secondCommaIndex = i;
            }
        }
        for (int i = firstCommaIndex + 1; i <= secondCommaIndex; i++)
        {
            city += infos.get(i) + " ";
        }
        city = city.substring(0, city.length() - 2); // extra comma and space
        // state and zipCode
        state = infos.get(secondCommaIndex + 1); // always the two letters after second comma
        zipCode = Integer.parseInt(infos.get(infos.size() - 1)); // last item, parse int = zipCode
    }



    // methods
    // accessor methods
    public String getStreetNum()
    {
        return streetNum;
    }
    public String getStreetName()
    {
        return streetName;
    }
    public String getApartmentNum()
    {
        return apartmentNum;
    }
    public String getCity()
    {
        return city;
    }
    public String getState()
    {
        return state;
    }
    public int getZipCode()
    {
        return zipCode;
    }

    public String toString()
    {
        String address = streetNum;
        if (apartmentNum.equals("")) { // if no apartmentNum
            address += " " + streetName + ", ";
        } else { // if yes apartmentNum
            address += " " + streetName + " " + apartmentNum + ", ";
        }
        address += city + ", ";
        address += state + " " + zipCode;
        return address;
    }

    public boolean isSameAddress(Address other)
    {
        boolean isSame = this.equals(other); // implicit call of toString, identical String literal means same address
        return isSame;
    }
}
