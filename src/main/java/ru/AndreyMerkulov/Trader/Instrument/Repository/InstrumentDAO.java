package ru.AndreyMerkulov.Trader.Instrument.Repository;

import org.springframework.stereotype.Repository;
import ru.AndreyMerkulov.Trader.Instrument.Instrument;

import java.util.List;

@Repository
public interface InstrumentDAO {

    List<Instrument> getAll();
    Instrument get(String symbol);
    void add(Instrument instrument);
    void del(String symbol);
    void upd(Instrument instrument);
}
