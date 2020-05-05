package model;

public class Route {
    private String uniqueCode;
    private int length;
    private int time;
    private String stopPoints[];

    public Route(String uniqueCode, int length, int time, String stopPoints[]) {
        this.uniqueCode = uniqueCode;
        this.length = length;
        this.time = time;
        this.stopPoints = stopPoints;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String[] getStopPoints() {
        return stopPoints;
    }

    public void setStopPoints(String[] stopPoints) {
        this.stopPoints = stopPoints;
    }
}
