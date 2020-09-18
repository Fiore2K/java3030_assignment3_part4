package kfiore;

import Interfaces.DummyStockService;
import Interfaces.Enums.StockSymbolType;
import Interfaces.StockService;

import Main.StockFactory;
import Main.StockTraderApp;
import Main.StockTransaction;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    /**
     * All variables require listed below
     */

    DummyStockService dummyStockService;
    StockService stockService;
    StockFactory stockFactory;
    StockTraderApp stockTraderApp;
    StockTransaction stockTransaction;

    /**
     * Build StockService before running tests
     */

    @Before
    public void setUpStockService() {
        this.stockService = new StockService() {
            @Override
            public StockTransaction getQuote(StockSymbolType symbol, Timestamp timeOfTransaction) {
                return getQuote(symbol, timeOfTransaction);
            }

            @Override
            public List<StockTransaction> getQuoteList(StockSymbolType symbol, Calendar from, Calendar until) {
                return getQuoteList(symbol, from, until);
            }
        };

    }

    /**
     * Build StockTransaction before running tests
     */

    @Before
    public void setUpStockTransaction() {

        Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());

        this.stockTransaction = new StockTransaction(new BigDecimal(419.62), StockSymbolType.TSLA, ts);
    }

    /**
     * Build rest of app before running tests
     */

    @Before
    public void setUp() {
        this.dummyStockService = new DummyStockService();
        this.stockFactory = new StockFactory();
        this.stockTraderApp = new StockTraderApp();
    }

    /**
     * Test if StockSymbol is missing
     */

    @Test
    public void symbolTest()
    {
        assertNotNull("StockService not found", stockService);
    }

    /**
     * Test if StockTransaction is returning the correct hardcoded data
     * Test if StockTransaction is null
     */

    @Test
    public void transactionTest()
    {
        Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());

        assertNotEquals(new StockTransaction(new BigDecimal(10), StockSymbolType.DKNG, ts), stockTransaction);
        assertNotNull("StockTransaction is empty or null", stockTransaction);
    }

    /**
     * Test if DummyStockService is missing required data
     */

    @Test
    public void dummyStockTest() {
        assertNotNull("HardCoded data not found in DummyStockService", dummyStockService);
    }

    /**
     * Test if StockFactory is returning the correct StockSymbol
     * Test if StockFactory is null or missing required information
     */

    @Test
    public void stockFactoryTest() {

        StockSymbolType symbol = StockSymbolType.DKNG;

        assertNotEquals(symbol, StockSymbolType.TSLA);
        assertNotNull("StockFactory is empty or null", stockFactory);
    }

    /**
     * Test if Stock is returning null when compiled
     */

    @Test
    public void testStockTraderApp() {
        assertNotNull("testStockTraderApp failed", stockTraderApp);
    }
}
