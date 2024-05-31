package ru.AndreyMerkulov.Trader.Instrument;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
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
    };
    public void del(String symbol){
        instrumentDAO.del(symbol);
    };
    public void upd(Instrument instrument){
        instrumentDAO.upd(instrument);
    };
}
