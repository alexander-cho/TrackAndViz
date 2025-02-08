package dev.vf.tickerservice.domain;

public class TickerNotFoundException extends RuntimeException {
    public TickerNotFoundException(String symbol) {
        super("Ticker " + symbol + " not found.");
    }
}
