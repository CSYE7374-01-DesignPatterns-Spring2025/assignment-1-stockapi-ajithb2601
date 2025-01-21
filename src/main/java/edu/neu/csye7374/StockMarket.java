package edu.neu.csye7374;
import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;
    private List<StockAPI> stocks = new ArrayList<>();

    private StockMarket() {
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(StockAPI stock) {
        stocks.add(stock);
    }

    public boolean removeStock(StockAPI stock) {
        return stocks.remove(stock);
    }

    public void displayAllTheStocks() {
        stocks.forEach(stock -> System.out.println(stock.toString()));
    }

    public void tradeStock(StockAPI stock, String bid) {
        stock.setBid(bid);
        System.out.println(stock);
    }

    public void simulateBids(StockAPI stock, String[] bids) {
        for (String bid : bids) {
            tradeStock(stock, bid);
        }
    }

    public static void demo() {
        StockMarket stockMarket = StockMarket.getInstance();

        System.out.println("======= LargeCap Stock Bid Start ======= ");
        StockAPI largeCapStock = new LargeCapStock("IBM", 131.15, "IBM Common Stock");
        stockMarket.addStock(largeCapStock);
        stockMarket.simulateBids(largeCapStock, new String[] { "135", "140", "128", "125", "130", "137" });
        System.out.println("\n");

        System.out.println("======= SmallCap Stock Bid Start ======= ");
        StockAPI smallCapStock = new SmallCapStock("GOOG", 2200.0, "Google Stock");
        stockMarket.addStock(smallCapStock);
        stockMarket.simulateBids(smallCapStock, new String[] { "2220", "2235", "2190", "2150", "2300", "2350" });
        System.out.println("\n");

        System.out.println("======= All Stock Information ======= ");
        StockMarket.getInstance().displayAllTheStocks();
        System.out.println("\n");
    }
}
