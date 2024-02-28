package stocks_portfolio;

import java.util.ArrayList;

public class StocksPortfolio {

    private IStockmarketService stockmarket;
    private ArrayList<Stock> stocks;

    public StocksPortfolio(IStockmarketService stockmarket) {
        this.stockmarket = stockmarket;
        this.stocks = new ArrayList<Stock>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double totalValue(){
        double total = 0;
        for (Stock stock : stocks) {
            total += stockmarket.lookUpPrice(stock.getLabel()) * stock.getQuantity();
        }
        return total;
    }
    

}
