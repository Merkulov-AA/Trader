package ru.andreymerkulov.trader.instrument.serveice;

import org.springframework.stereotype.Service;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;

import java.util.List;

@Service
public interface InstrumentService {

    List<InstrumentDto> getAll();
    InstrumentDto get(String symbol);
    void add(InstrumentDto instrumentDto);
    void del(String symbol);
    void upd(InstrumentDto instrumentDto);
}
