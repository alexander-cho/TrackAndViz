package dev.vf.tickerservice.domain;

public class TickerAlreadyExistsException extends RuntimeException {
    public TickerAlreadyExistsException(String symbol) {
        super("The ticker " + symbol + " already exists.");
    }
}
