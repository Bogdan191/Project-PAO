package model;

public class Ticket {
    private String buyer;
    private String uniqueCode;
    private String route;
    private String price;
    public Ticket(String buyer, String uniqueCode, String route, String price){
        this.buyer = buyer;
        this.uniqueCode = uniqueCode;
        this.route = route;
        this.price = price;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }



    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
