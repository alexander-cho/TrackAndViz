package dev.vf.tickerservice.domain;

import java.util.Optional;

public interface TickerRepository {
    Iterable<Ticker> findAll();

    Optional<Ticker> findBySymbol(String symbol);

    boolean exists(String symbol);

    Ticker save(Ticker ticker);

    void delete(String symbol);
}
