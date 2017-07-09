package domain;


public class ContactEmergency {
    private String name;
    private String number;

    public ContactEmergency(){
        this.name=null;
        this.number=null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
