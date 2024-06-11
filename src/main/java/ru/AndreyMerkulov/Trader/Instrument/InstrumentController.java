package ru.AndreyMerkulov.Trader.Instrument;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.AndreyMerkulov.Trader.Instrument.Serveice.InstrumentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instrument")
@AllArgsConstructor
public class InstrumentController {

    private final InstrumentService service;

    @GetMapping
    public List<Instrument> getAll() {
        return service.getAll();
    }
    @GetMapping("get/{symbol}")
    public Instrument getInstrument(@PathVariable String symbol) {
        return service.get(symbol);
    }

    @PostMapping("add")
    public void addInstrument(@RequestBody Instrument instrument) {
        service.add(instrument);
    }

    @DeleteMapping("del/{symbol}")
    public void delInstrument(@PathVariable String symbol) {
        service.del(symbol);
    }

    @PostMapping("upd")
    public void updInstrument(@RequestBody Instrument instrument) {
        service.upd(instrument);
    }
}
