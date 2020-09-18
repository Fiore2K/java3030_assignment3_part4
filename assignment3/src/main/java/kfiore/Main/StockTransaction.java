package Main;

import Interfaces.Enums.StockSymbolType;
import Interfaces.StockService;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class StockTransaction {

        private BigDecimal price;
        private StockSymbolType stockSymbol;
        private Timestamp time;

        /**
         * Construct a new Main.StockTransaction instance.
         * @param price
         * @param stockSymbol
         * @param time
         */
        public StockTransaction(BigDecimal price, StockSymbolType stockSymbol, Timestamp time) {
            this.price = price;
            this.stockSymbol = stockSymbol;
            this.time = time;
        }

        /**
         * Get the transaction price
         * @return a BigDecimal value
         */
        public BigDecimal getPrice() {
            return price;
        }

        /**
         * Get the Stock Symbol
         * @return a Interfaces.Enums.StockSymbolType value
         */
        public StockSymbolType getStockSymbol() {
            return stockSymbol;
        }

        /**
         * Get the time of the transaction
         * @return a Timestamp value
         */
        public Timestamp getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "StockQuote{" +
                    "price=" + price +
                    ", stockSymbol='" + stockSymbol + '\'' +
                    ", time=" + time +
                    '}';
        }
    }


