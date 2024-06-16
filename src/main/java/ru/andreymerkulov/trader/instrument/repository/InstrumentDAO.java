package ru.andreymerkulov.trader.instrument.repository;

import org.springframework.stereotype.Repository;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;

import java.util.List;

@Repository
public interface InstrumentDAO {

    List<InstrumentDto> getAll();
    InstrumentDto get(String symbol);
    void add(InstrumentDto instrumentDto);
    void del(String symbol);
    void upd(InstrumentDto instrumentDto);
}
