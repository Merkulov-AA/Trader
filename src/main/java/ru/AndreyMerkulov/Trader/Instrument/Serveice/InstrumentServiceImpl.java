package ru.AndreyMerkulov.Trader.Instrument.Serveice;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.AndreyMerkulov.Trader.Instrument.Instrument;
import ru.AndreyMerkulov.Trader.Instrument.Repository.InstrumentDAO;

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
