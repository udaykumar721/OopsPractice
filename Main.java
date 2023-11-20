import java.util.ArrayList;
class Stock {
    private String stockName;
    int numberOfShares;
    double sharePrice;

    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }

    public String getStockName() {
        return stockName;
    }
}

class StockPortfolio {
    private ArrayList<Stock> stocks;

    public StockPortfolio() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double calculateTotalPortfolioValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }

    public void printStockReport() {
        System.out.println("Stock Report:");
        System.out.printf("%-15s%-20s%-15s%-15s\n", "Stock Name", "Number of Shares", "Share Price", "Stock Value");
        System.out.println("----------------------------------------------------------");

        for (Stock stock : stocks) {
            System.out.printf("%-15s%-20d%-15.2f%-15.2f\n",
                    stock.getStockName(),
                    stock.numberOfShares,
                    stock.sharePrice,
                    stock.calculateStockValue());
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("%-50s%-15.2f\n", "Total Portfolio Value:", calculateTotalPortfolioValue());
    }
}