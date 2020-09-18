package Main;

import Interfaces.Enums.StockSymbolType;
import Interfaces.StockService;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Begin Main method
 */

public class StockTraderApp
{

    public static void main(String[] args) {

        /**
         * StockFactory creates the implementation of StockService and is returned and printed here
         */

        Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());

        StockService stockService = StockFactory.getInstance(StockSymbolType.TSLA);
        System.out.println(stockService.getQuote(StockSymbolType.TSLA, ts));

    }
}
