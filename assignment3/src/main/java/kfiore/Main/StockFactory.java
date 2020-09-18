package Main;

import Interfaces.DummyStockService;
import Interfaces.Enums.StockSymbolType;
import Interfaces.StockService;

/**
 * Factory class with getInstance method
 */

public class StockFactory {

    /**
     * getInstance method returns a new DummyStockService if StockSymbolType is matched
     * @param symbol
     * @return
     */

    public static StockService getInstance(StockSymbolType symbol) {

        if (symbol.equals(StockSymbolType.TSLA))
            return new DummyStockService();

        return null;
    }
}
