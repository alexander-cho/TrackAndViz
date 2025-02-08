package dev.vf.tickerservice.persistence;

import dev.vf.tickerservice.domain.Ticker;
import dev.vf.tickerservice.domain.TickerRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryTickerRepository implements TickerRepository {

    private static final Map<String, Ticker> tickers = new ConcurrentHashMap<>();

    @Override
    public Iterable<Ticker> findAll() {
        return tickers.values();
    }

    @Override
    public Optional<Ticker> findBySymbol(String symbol) {
        return exists(symbol) ? Optional.of(tickers.get(symbol)) : Optional.empty();
    }

    @Override
    public boolean exists(String symbol) {
        return tickers.get(symbol) != null;
    }

    @Override
    public Ticker save(Ticker ticker) {
        tickers.put(ticker.symbol(), ticker);
        return ticker;
    }

    @Override
    public void delete(String symbol) {
        tickers.remove(symbol);
    }
}
