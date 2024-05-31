package ru.AndreyMerkulov.Trader.Instrument;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstrumentService {

    List<Instrument> getAll();
    Instrument get(String symbol);
    void add(Instrument instrument);
    void del(String symbol);
    void upd(Instrument instrument);
}
