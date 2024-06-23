package ru.andreymerkulov.trader.instrument.serveice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;
import ru.andreymerkulov.trader.instrument.repository.InstrumentDAO;

import java.util.List;

@AllArgsConstructor
//@Service
//@Profile("mem")
public class InstrumentServiceMEMImpl implements InstrumentService {

    private final InstrumentDAO instrumentDAO;

    public List<InstrumentDto> getAll() {
        return instrumentDAO.getAll();
    }

    public InstrumentDto get(String symbol){
        return instrumentDAO.get(symbol);
    }
    public void add(InstrumentDto instrumentDto){
        instrumentDAO.add(instrumentDto);
    }
    public void del(String symbol){
        instrumentDAO.del(symbol);
    }
    public void upd(InstrumentDto instrumentDto){
        instrumentDAO.upd(instrumentDto);
    }
}
