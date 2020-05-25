package model;

public class Route {
    private String uniqueCode;
    private String startPoint;
    private String destination;
    private int length;
    private int time;
    private String stopPoints[];

    public Route(String uniqueCode, String startPoint, String destination, int length, int time, String stopPoints[]) {
        this.uniqueCode = uniqueCode;
        this.startPoint = startPoint;
        this.destination = destination;
        this.length = length;
        this.time = time;
        this.stopPoints = stopPoints;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
