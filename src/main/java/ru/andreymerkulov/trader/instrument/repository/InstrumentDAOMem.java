package ru.andreymerkulov.trader.instrument.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;
import ru.andreymerkulov.trader.instrument.exception.InstrumentFoundException;
import ru.andreymerkulov.trader.instrument.exception.InstrumentNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class InstrumentDAOMem implements InstrumentDAO {
    private final ArrayList<InstrumentDto> list = new ArrayList<>();

    int getIndex(String symbol){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getSymbol().equals(symbol)){
                return i;
            }
        }
        return -1;
    }

    public List<InstrumentDto> getAll() {
        return list;
    }

    public InstrumentDto get(String symbol){
        int i = getIndex(symbol);
        if (i<0)
            throw new InstrumentNotFoundException("Instrument not found");
        return list.get(i);
    }

    public void add(InstrumentDto instrumentDto){
        int i = getIndex(instrumentDto.getSymbol());
        if (i>=0)
            throw new InstrumentFoundException("Instrument found " + list.get(i));
        list.add(instrumentDto);
    }

    public void del(String symbol){
        int i = getIndex(symbol);
        if (i<0)
            throw new InstrumentNotFoundException("Instrument not found");
        list.remove(i);
    }

    public void upd(InstrumentDto instrumentDto){
        int i = getIndex(instrumentDto.getSymbol());
        if (i<0)
            throw new InstrumentNotFoundException("Instrument not found");
        list.set(i, instrumentDto);
    }
}
