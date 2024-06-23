package ru.andreymerkulov.trader.instrument.serveice;

import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;

import java.util.List;

public interface InstrumentService {

    List<InstrumentDto> getAll();
    InstrumentDto get(String symbol);
    void add(InstrumentDto instrumentDto);
    void del(String symbol);
    void upd(InstrumentDto instrumentDto);
}
