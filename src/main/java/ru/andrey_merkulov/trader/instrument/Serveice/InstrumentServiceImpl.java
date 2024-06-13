package ru.andrey_merkulov.trader.instrument.Serveice;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.andrey_merkulov.trader.instrument.Instrument;
import ru.andrey_merkulov.trader.instrument.Repository.InstrumentDAO;

import java.util.List;

@AllArgsConstructor
@Service
@Primary
public class InstrumentServiceImpl implements InstrumentService {

    private final InstrumentDAO instrumentDAO;

    public List<Instrument> getAll() {
        return instrumentDAO.getAll();
    }

    public Instrument get(String symbol){
        return instrumentDAO.get(symbol);
    }
    public void add(Instrument instrument){
        instrumentDAO.add(instrument);
    }
    public void del(String symbol){
        instrumentDAO.del(symbol);
    }
    public void upd(Instrument instrument){
        instrumentDAO.upd(instrument);
    }
}
