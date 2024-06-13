package ru.andrey_merkulov.trader.instrument.Service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.andrey_merkulov.trader.instrument.Instrument;
import ru.andrey_merkulov.trader.instrument.Repository.InstrumentDAO;
import ru.andrey_merkulov.trader.instrument.Serveice.InstrumentService;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class InstrumentServiceTest {

    @Autowired
    private InstrumentService instrumentService;

    @MockBean
    private InstrumentDAO instrumentDAO;

    @Test
    void getAll() {
        // Given
        Instrument newInstrument1 = new Instrument("BTCUSDT", 3, 0.001f);
        Instrument newInstrument2 = new Instrument("ETHUSDT", 4, 0.0001f);
        List<Instrument> expectedInstruments = new ArrayList<>();
        expectedInstruments.add(newInstrument1);
        expectedInstruments.add(newInstrument2);

        // Настраиваем заглушку для возвращения ожидаемого списка при вызове метода getAll
        when(instrumentDAO.getAll()).thenReturn(expectedInstruments);

        // Then
        List<Instrument> instruments = instrumentService.getAll();
        assertThat(instruments).contains(newInstrument1, newInstrument2);
        verify(instrumentDAO, times(1)).getAll();
    }

    @Test
    void testGet(){
        // Given
        Instrument instrument = new Instrument("BTCUSDT", 3, 0.001f);
        given(instrumentDAO.get(instrument.getSymbol())).willReturn(instrument);

        // When
        Instrument foundInstrument = instrumentService.get(instrument.getSymbol());

        // Then
        assertNotNull(foundInstrument);
        assertEquals(instrument,foundInstrument);
    }
    @Test
    void testAdd(){

        // Given
        Instrument newInstrument = new Instrument("BTCUSDT", 3, 0.001f);

        // Configure mock repository to return expected result
        doNothing().when(instrumentDAO).add(newInstrument);

        // When
        instrumentService.add(newInstrument);

        // Then
        verify(instrumentDAO, times(1)).add(newInstrument);

    }
    @Test
    void testDel(){
        String symbol = "BTCUSDT";

        // Configure mock repository to return expected result
        doNothing().when(instrumentDAO).del(symbol);

        // When
        instrumentService.del(symbol);

        // Then
        verify(instrumentDAO, times(1)).del(symbol);
    }
    @Test
    void testUpd(){
        // Given
        Instrument updInstrument = new Instrument("BTCUSDT", 3, 0.001f);

        // Configure mock repository to return expected result
        doNothing().when(instrumentDAO).upd(updInstrument);

        // When
        instrumentService.upd(updInstrument);

        // Then
        verify(instrumentDAO, times(1)).upd(updInstrument);
    }
}
