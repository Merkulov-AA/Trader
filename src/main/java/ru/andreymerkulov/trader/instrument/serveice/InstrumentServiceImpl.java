package ru.andreymerkulov.trader.instrument.serveice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.andreymerkulov.trader.instrument.Instrument;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;
import ru.andreymerkulov.trader.instrument.exception.InstrumentNotFoundException;
import ru.andreymerkulov.trader.instrument.mapper.InstrumentMapper;
import ru.andreymerkulov.trader.instrument.repository.InstrumentRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class InstrumentServiceImpl implements InstrumentService{

    private final InstrumentRepository instrumentDAO;
    private final InstrumentMapper instrumentMapper;

    public List<InstrumentDto> getAll() {
        List<Instrument> list = instrumentDAO.findAll();
        return instrumentMapper.instrumentToInstrumentDto(list);
    }

    public InstrumentDto get(String symbol){
        Instrument instrument = instrumentDAO
                .findById(symbol)
                .orElseThrow(() -> new InstrumentNotFoundException("Instrument not found"));
        return instrumentMapper.instrumentToInstrumentDto(instrument);
    }
    public void add(InstrumentDto instrumentDto){
        instrumentDAO.save(instrumentMapper.instrumentDtoToInstrument(instrumentDto));
    }
    public void del(String symbol){
        instrumentDAO.deleteById(symbol);
    }
    public void upd(InstrumentDto instrumentDto){
        instrumentDAO.save(instrumentMapper.instrumentDtoToInstrument(instrumentDto));
    }

}
