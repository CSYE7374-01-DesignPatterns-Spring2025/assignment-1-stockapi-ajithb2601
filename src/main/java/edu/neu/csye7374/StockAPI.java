package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockAPI implements Tradable {
    private String ID;
    private double price;
    private String description;
    private List<Double> priceHistory = new ArrayList<>();
    private List<Double> bidHistory = new ArrayList<>();

    public StockAPI(String ID, double price, String description) {
        this.ID = ID;
        this.price = price;
        this.description = description;
        this.priceHistory.add(price);
    }

    public String getId() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Double> getBidHistory() {
        return bidHistory;
    }

    public List<Double> getPriceHistory() {
        return priceHistory;
    }

    @Override
    public void setBid(String bid) {
        this.bidHistory.add(Double.valueOf(bid));
        double newPrice = updatePrice(Double.valueOf(bid));
        priceHistory.add(newPrice);
    }

    protected double updatePrice(double bidValue) {
        double updatedPrice = (this.price + bidValue) / 2;
        this.price = updatedPrice;
        return updatedPrice;
    }

    @Override
    public int getMetric() {
        int performance = 0;
        double previousPrice = 0;
        for (double price : getBidHistory().subList(getBidHistory().size() - 6, getBidHistory().size())) {
            if (price > previousPrice) {
                performance++;
            } else {
                performance--;
            }
            previousPrice = price;
        }
        return performance;
    }

    @Override
    public String toString() {
        StringBuilder stock = new StringBuilder();
        stock.append("Name: ").append(getId()).append("\t");
        stock.append("Description: ").append(getDescription()).append("\t");
        stock.append("Current Price: ").append(getPrice()).append("\t");
        stock.append("Current Bid: ").append(getBidHistory().get(getBidHistory().size() - 1));
        stock.append("\n");
        return stock.toString();
    }

}
