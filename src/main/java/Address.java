public class Address{
    private String street,town;
    private String phone;

    public Address(String street,String town,String phone){
        setStreet(street);
        setTown(town);
        setPhone(phone);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}