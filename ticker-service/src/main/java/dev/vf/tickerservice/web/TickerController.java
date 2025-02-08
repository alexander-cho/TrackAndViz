package dev.vf.tickerservice.web;

import dev.vf.tickerservice.domain.Ticker;
import dev.vf.tickerservice.domain.TickerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tickers")
public class TickerController {
    private final TickerService tickerService;

    public TickerController(TickerService tickerService) {
        this.tickerService = tickerService;
    }

    @GetMapping
    public Iterable<Ticker> getAll() {
        return tickerService.getAllTickers();
    }

    @GetMapping("{symbol}")
    public Ticker getBySymbol(@PathVariable String symbol) {
        return tickerService.getTicker(symbol.toUpperCase());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticker add(@Valid @RequestBody Ticker ticker) {
        return tickerService.addTicker(ticker);
    }

    @PutMapping("{symbol}")
    public Ticker edit(@Valid @PathVariable String symbol, @RequestBody Ticker ticker) {
        return tickerService.editTicker(symbol.toUpperCase(), ticker);
    }

    @DeleteMapping("{symbol}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String symbol) {
        tickerService.removeTicker(symbol.toUpperCase());
    }
}
