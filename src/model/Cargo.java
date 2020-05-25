package model;

public class Cargo {
    private String sender;
    private String recipient;
    private String description;
    private String pickUpLocation;
    private String destination;
    private int weight;
    private int volume;

    public Cargo(String sender, String recipient, String description, String pickUpLocation, String destination, int weight, int volume) {
        this.sender = sender;
        this.recipient = recipient;
        this.description = description;
        this.destination = destination;
        this.pickUpLocation = pickUpLocation;
        this.weight = weight;
        this.volume = volume;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getDescrition() {
        return this.description;
    }

    public void setDescrition(String descrition) {
        this.description = descrition;
    }

    public String getPickUpLocation() {
        return this.pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
