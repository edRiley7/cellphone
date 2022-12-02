package Eddie.Riley;

public class Contacts {
    private String name;
    private String phoneNumber;

    public Contacts (String name, String phoneNumber){
        name = this.name;
        phoneNumber = this.phoneNumber;
    }
    public Contacts(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString(){
        return this.name + " " + this.phoneNumber;
    }
}
