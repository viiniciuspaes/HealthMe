package dominio;



public class Person {
    private int id;
    private User user;
    private String name;
    private  String homeAdress;
    private  String workAdress;
    private  String healthcareProgram;
    private  String age = "age";
    private  ContactEmergency[] emergencyContacts;

    public Person(){
        this.name = null;
        this.user = null;
        this.homeAdress = null;
        this.workAdress = null;
        this.healthcareProgram = null;
        this.age = null;
        this.emergencyContacts = null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }

    public String getWorkAdress() {
        return workAdress;
    }

    public void setWorkAdress(String workAdress) {
        this.workAdress = workAdress;
    }

    public String getHealthcareProgram() {
        return healthcareProgram;
    }

    public void setHealthcareProgram(String healthcareProgram) {
        this.healthcareProgram = healthcareProgram;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ContactEmergency[] getEmergencyContacts() {
        return emergencyContacts;
    }

    public void setEmergencyContacts(ContactEmergency[] emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }



}
