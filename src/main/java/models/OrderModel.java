package models;

public class OrderModel {

    private String name;
    private String country;
    private String city;
    private String creditCard;
    private String month;
    private String year;

    public String getName() {
        return name;
    }
    public String getCountry() { return country; }
    public String getCity() {
        return city;
    }
    public String getCreditCard() {
        return creditCard;
    }
    public String getMonth() {
        return month;
    }
    public String getYear() {
        return year;
    }

    public String toString() {
        return "Name: " + name + "\n" +
                "Country: " + country + "\n" +
                "City: " + city + "\n" +
                "Credit Card: " + creditCard + "\n" +
                "Date: " + month + "-" + year + "\n";
    }
}
