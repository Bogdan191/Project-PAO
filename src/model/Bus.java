package model;

public class Bus extends Vehicle {

    private int maxPeople;

    public Bus(String name, String plates, String driver, int age, int odometer, int maxPeople) {
        super(name, plates, driver, age, odometer);
        this.maxPeople = maxPeople;
    }


    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
}
