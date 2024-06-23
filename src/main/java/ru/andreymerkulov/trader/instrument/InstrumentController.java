package ru.andreymerkulov.trader.instrument;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;
import ru.andreymerkulov.trader.instrument.serveice.InstrumentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instrument")
@AllArgsConstructor
public class InstrumentController {

    @Qualifier("instrumentServiceJPAImpl")
    private final InstrumentService service;

    @GetMapping
    public List<InstrumentDto> getAll() {
        return service.getAll();
    }
    @GetMapping("get/{symbol}")
    public InstrumentDto getInstrument(@PathVariable String symbol) {
        return service.get(symbol);
    }

    @PostMapping("add")
    public void addInstrument(@RequestBody InstrumentDto instrumentDto) {
        service.add(instrumentDto);
    }

    @DeleteMapping("del/{symbol}")
    public void delInstrument(@PathVariable String symbol) {
        service.del(symbol);
    }

    @PostMapping("upd")
    public void updInstrument(@RequestBody InstrumentDto instrumentDto) {
        service.upd(instrumentDto);
    }
}
