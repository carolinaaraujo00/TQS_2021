import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {

    private IStockmarketService stockmarket;
    private List<Stock> stocks;

    public StocksPortfolio(IStockmarketService stockmarket){
        this.stockmarket = stockmarket;
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock){ stocks.add(stock); }

    public double getTotalValue(){
        double value = 0;
        for( Stock stock: stocks ){
            value += stock.getQuantity() * stockmarket.getPrice( stock.getName() );
        }
        return value;
    }
}
