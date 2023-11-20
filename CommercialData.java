import java.util.ArrayList;
import java.util.List;

class CompanyShares {
    private String stockSymbol;
    private int numberOfShares;
    private String dateTime;

    public CompanyShares(String stockSymbol, int numberOfShares, String dateTime) {
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.dateTime = dateTime;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public String getDateTime() {
        return dateTime;
    }
}

public class CommercialData {
    private List<CompanyShares> companySharesList;

    public void StockAccount() {
        this.companySharesList = new ArrayList<>();
    }
    public void buy(String stockSymbol, int numberOfShares, String dateTime) {
        for (CompanyShares companyShares : companySharesList) {
            if (companyShares.getStockSymbol().equals(stockSymbol)) {
                companySharesList.remove(companyShares);
                int newNumberOfShares = companyShares.getNumberOfShares() + numberOfShares;
                companySharesList.add(new CompanyShares(stockSymbol, newNumberOfShares, dateTime));
                System.out.println("Bought " + numberOfShares + " shares of " + stockSymbol);
                return;
            }
        }
        companySharesList.add(new CompanyShares(stockSymbol, numberOfShares, dateTime));
        System.out.println("Bought " + numberOfShares + " shares of " + stockSymbol);
    }
    public void sell(String stockSymbol, int numberOfShares, String dateTime) {
        for (CompanyShares companyShares : companySharesList) {
            if (companyShares.getStockSymbol().equals(stockSymbol)) {
                companySharesList.remove(companyShares);
                int newNumberOfShares = companyShares.getNumberOfShares() - numberOfShares;
                if (newNumberOfShares > 0) {
                    companySharesList.add(new CompanyShares(stockSymbol, newNumberOfShares, dateTime));
                    System.out.println("Sold " + numberOfShares + " shares of " + stockSymbol);
                } else {
                    System.out.println("Insufficient shares to sell.");
                }
                return;
            }
        }
        System.out.println("Stock symbol " + stockSymbol + " not available for selling.");
    }
    public void displayCompanyShares() {
        System.out.println("Company Shares:");
        for (CompanyShares companyShares : companySharesList) {
            System.out.println("Stock Symbol: " + companyShares.getStockSymbol() +
                    ", Number of Shares: " + companyShares.getNumberOfShares() +
                    ", DateTime: " + companyShares.getDateTime());
        }
    }

    public static void main(String[] args) {
        CommercialData stockAccount = new CommercialData();
        stockAccount.buy("AAPL", 10, "2023-01-01");
        stockAccount.buy("GOOGL", 5, "2023-01-02");
        stockAccount.displayCompanyShares();

        stockAccount.sell("AAPL", 5, "2023-01-03");
        //stockAccount.sell("MSFT", 8, "2023-01-04");
        stockAccount.displayCompanyShares();
    }
}
