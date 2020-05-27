package model;

public class Cargo {
    private String username;
    private String sender;
    private String recipient;
    private String description;
    private String pickUpLocation;
    private String destination;
    private String weight;
    private String volume;

    public Cargo(String username, String sender, String recipient, String description, String pickUpLocation, String destination, String weight, String volume) {
        this.username = username;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
