package model;

public class Bagage {
    private String sender;
    private String recipient;
    private String description;
    private String pickUpLocation;
    private String destination;
    private int weight;
    private int volume;

    public Bagage(String sender, String recipient, String description,
                  String pickUpLocation, String destination, int weight, int volume){

        this.sender = sender;
        this.recipient = recipient;
        this.description = description;
        this.pickUpLocation = pickUpLocation;
        this.destination = destination;
        this.weight = weight;
        this.volume = volume;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
