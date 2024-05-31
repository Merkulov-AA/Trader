package ru.AndreyMerkulov.Trader.Instrument;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentDAO {

    List<Instrument> getAll();
    Instrument get(String symbol);
    void add(Instrument instrument);
    void del(String symbol);
    void upd(Instrument instrument);
}
