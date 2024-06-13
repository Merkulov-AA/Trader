package ru.andrey_merkulov.trader.instrument.Serveice;

import org.springframework.stereotype.Service;
import ru.andrey_merkulov.trader.instrument.Instrument;

import java.util.List;

@Service
public interface InstrumentService {

    List<Instrument> getAll();
    Instrument get(String symbol);
    void add(Instrument instrument);
    void del(String symbol);
    void upd(Instrument instrument);
}
