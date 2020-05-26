package model;

public class Truck extends Vehicle {
    private int maxVolume;
    private int maxWeight;

    public Truck(String name, String plates, String driver, int age, int odometer, int maxVolume, int maxWeight) {
        super(name, plates, driver, age, odometer);
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
