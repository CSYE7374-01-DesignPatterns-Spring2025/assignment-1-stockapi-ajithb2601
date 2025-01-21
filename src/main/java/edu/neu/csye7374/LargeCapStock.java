package edu.neu.csye7374;

public class LargeCapStock extends StockAPI{

    public LargeCapStock(String ID, double price, String description) {
        super(ID, price, description);
    }

    @Override
    public int getMetric() {
        if (getBidHistory().isEmpty()) return 0;
        double fluctuation = getBidHistory().stream().mapToDouble(val -> Math.abs(this.getPrice() - val)).sum();
        return (int) (100 / (fluctuation + 1));
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
