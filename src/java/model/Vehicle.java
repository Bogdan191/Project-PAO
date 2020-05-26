package model;

public class Vehicle {
    private String name;
    private String plates;
    private String driver;
    private int age;
    private int odometer;

    public Vehicle(String name, String plates, String driver, int age, int odometer) {
        this.name = name;
        this.plates = plates;
        this.driver = driver;
        this.age = age;
        this.odometer = odometer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
