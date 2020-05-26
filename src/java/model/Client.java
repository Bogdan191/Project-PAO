package model;

public class Client extends User{

    private String name;
    private String phoneNumber;
    private int bonusPoints;

    public Client(String username, String password, String name, String phoneNumber, int bonusPoints){
        super(username, password);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bonusPoints = bonusPoints;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
}
