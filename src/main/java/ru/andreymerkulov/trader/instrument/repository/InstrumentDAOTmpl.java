package ru.andreymerkulov.trader.instrument.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.andreymerkulov.trader.instrument.exception.InstrumentNotFoundException;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository

public class InstrumentDAOTmpl implements InstrumentDAO {


    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<InstrumentDto> beanPropertyRowMapper = new BeanPropertyRowMapper<>(InstrumentDto.class);


    public List<InstrumentDto> getAll() {
        String sql = "SELECT * FROM instrument";
        return jdbcTemplate.query(sql, beanPropertyRowMapper);
    }

    public InstrumentDto get(String symbol){
        String sql = "SELECT * FROM instrument WHERE symbol=?";
        Optional<InstrumentDto> res = jdbcTemplate.query(
                sql
                , beanPropertyRowMapper
                , new Object[]{symbol}
        ).stream().findFirst();
        return res.orElseThrow(() -> new InstrumentNotFoundException("Instrument not found"));
    }

    public void add(InstrumentDto instrumentDto){
        String sql = "INSERT INTO Instrument (symbol, priceScale, minOrderQty) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql
                , instrumentDto.getSymbol()
                , instrumentDto.getPriceScale()
                , instrumentDto.getMinOrderQty()
        );
    }

    public void del(String symbol){
        String sql = "DELETE FROM Instrument WHERE symbol = ?";
        jdbcTemplate.update(sql, symbol);
    }

    public void upd(InstrumentDto instrumentDto){
        String sql = "UPDATE Instrument SET priceScale=?, minOrderQty=? WHERE symbol=?";
        jdbcTemplate.update(
                sql
                , instrumentDto.getPriceScale()
                , instrumentDto.getMinOrderQty()
                , instrumentDto.getSymbol()
                );
    }
}
