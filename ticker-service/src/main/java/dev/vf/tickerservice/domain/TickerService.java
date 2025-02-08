package dev.vf.tickerservice.domain;

import org.springframework.stereotype.Service;

@Service
public class TickerService {
    private final TickerRepository tickerRepository;

    public TickerService(TickerRepository tickerRepository) {
        this.tickerRepository = tickerRepository;
    }

    public Iterable<Ticker> getAllTickers() {
        return tickerRepository.findAll();
    }

    public Ticker getTicker(String symbol) {
        return tickerRepository.findBySymbol(symbol)
                .orElseThrow(() -> new TickerNotFoundException(symbol));
    }

    public Ticker addTicker(Ticker ticker) {
        if (tickerRepository.exists(ticker.symbol())) {
            throw new TickerAlreadyExistsException(ticker.symbol());
        }
        return tickerRepository.save(ticker);
    }

    public Ticker editTicker(String symbol, Ticker ticker) {
        return tickerRepository.findBySymbol(symbol)
                .map(existingTicker -> {
                    var tickerToUpdate = new Ticker(
                            existingTicker.symbol(),
                            ticker.companyName());
                    return tickerRepository.save(tickerToUpdate);
                })
                .orElseThrow(() -> new TickerNotFoundException(symbol));
    }

    public void removeTicker(String symbol) {
        tickerRepository.delete(symbol);
    }
}
