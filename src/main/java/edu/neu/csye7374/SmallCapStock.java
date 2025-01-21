package edu.neu.csye7374;

public class SmallCapStock extends StockAPI{

    public SmallCapStock(String ID, double price, String description) {
        super(ID, price, description);
    }

    @Override
    public int getMetric() {
        if (getBidHistory().size() < 2) {
            return 0;
        }

        double totalDifference = 0;
        for (int i = 1; i < getBidHistory().size(); i++) {
            totalDifference += (getBidHistory().get(i) - getBidHistory().get(i - 1));
        }

        return (int) (totalDifference * 10);
    }

    @Override
    public String toString() {
        StringBuilder stock = new StringBuilder();
        stock.append("Name: ").append(getId()).append("\t|\t");
        stock.append("Description: ").append(getDescription()).append("\t|\t");
        stock.append("Price Before Bid: ").append(getPriceHistory().get(getPriceHistory().size() - 2)).append("\t|\t");
        stock.append("Current Bid: ").append(getBidHistory().get(getBidHistory().size() - 1)).append("\t|\t");
        stock.append("Price After Bid: ").append(getPrice()).append("\t");
        stock.append("\n");
        stock.append("Performance: ").append(getMetric()).append("\n");
        return stock.toString();
    }

}
