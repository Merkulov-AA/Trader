package ru.andrey_merkulov.trader.instrument.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.andrey_merkulov.trader.instrument.Exception.InstrumentNotFoundException;
import ru.andrey_merkulov.trader.instrument.Instrument;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Primary
public class InstrumentDAOTmpl implements InstrumentDAO {


    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<Instrument> beanPropertyRowMapper = new BeanPropertyRowMapper<>(Instrument.class);


    public List<Instrument> getAll() {
        String sql = "SELECT * FROM instrument";
        return jdbcTemplate.query(sql, beanPropertyRowMapper);
    }

    public Instrument get(String symbol){
        String sql = "SELECT * FROM instrument WHERE symbol=?";
        Optional<Instrument> res = jdbcTemplate.query(
                sql
                , beanPropertyRowMapper
                , new Object[]{symbol}
        ).stream().findFirst();
        return res.orElseThrow(() -> new InstrumentNotFoundException("Instrument not found"));
    }

    public void add(Instrument instrument){
        String sql = "INSERT INTO Instrument (symbol, priceScale, minOrderQty) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql
                , instrument.getSymbol()
                , instrument.getPriceScale()
                , instrument.getMinOrderQty()
        );
    }

    public void del(String symbol){
        String sql = "DELETE FROM Instrument WHERE symbol = ?";
        jdbcTemplate.update(sql, symbol);
    }

    public void upd(Instrument instrument){
        String sql = "UPDATE Instrument SET priceScale=?, minOrderQty=? WHERE symbol=?";
        jdbcTemplate.update(
                sql
                , instrument.getPriceScale()
                , instrument.getMinOrderQty()
                , instrument.getSymbol()
                );
    }
}
