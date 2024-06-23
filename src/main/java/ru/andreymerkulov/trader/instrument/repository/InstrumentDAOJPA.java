package ru.andreymerkulov.trader.instrument.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreymerkulov.trader.instrument.Instrument;

public interface InstrumentDAOJPA extends JpaRepository<Instrument, String> {
}