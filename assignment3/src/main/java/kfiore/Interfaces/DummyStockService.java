package Interfaces;

import Interfaces.Enums.StockSymbolType;
import Main.StockTransaction;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * DummyStockService class implements the StockService Interface with hardcoded Data
 */

public class DummyStockService implements StockService {

    /**
     * Adds stock data to a new StockTransaction
     *
     * @param symbol the stock symbol of the company you want a quote for e.g. APPL for APPLE
     * @param timeOfTransaction
     * @return
     */


    @Override
    public StockTransaction getQuote(StockSymbolType symbol, Timestamp timeOfTransaction) {

        Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());

        return new StockTransaction(new BigDecimal (419.62), StockSymbolType.TSLA, ts);

    }

    /**
     * Adds new stock data from StockTransaction above and adds to a List
     *
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return
     */

    @Override
    public List<StockTransaction> getQuoteList(StockSymbolType symbol, Calendar from, Calendar until) {

        List <StockTransaction> stockTransactions = new ArrayList<>();
        Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());

        stockTransactions.add (new StockTransaction(new BigDecimal (419.62), StockSymbolType.TSLA, ts));
        return stockTransactions;
    }

}

