package ru.AndreyMerkulov.Trader.Instrument;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstrumentDAOMem implements InstrumentDAO {
    private final ArrayList<Instrument> list = new ArrayList<>();

    int getIndex(String symbol){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getSymbol().equals(symbol)){
                return i;
            }
        }
        return -1;
    }

    public List<Instrument> getAll() {
        return list;
    }

    public Instrument get(String symbol){
        int i = getIndex(symbol);
        if (i<0)
            throw new InstrumentNotFoundException("Instrument not found");
        return list.get(i);
    }

    public void add(Instrument instrument){
        int i = getIndex(instrument.getSymbol());
        if (i>=0)
            throw new InstrumentFoundException("Instrument found " + list.get(i));
        list.add(instrument);
    }

    public void del(String symbol){
        int i = getIndex(symbol);
        if (i<0)
            throw new InstrumentNotFoundException("Instrument not found");
        list.remove(i);
    }

    public void upd(Instrument instrument){
        int i = getIndex(instrument.getSymbol());
        list.set(i,instrument);
    }
}
