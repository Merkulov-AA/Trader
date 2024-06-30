package ru.andreymerkulov.trader.instrument.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.andreymerkulov.trader.instrument.Instrument;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;
import ru.andreymerkulov.trader.instrument.mapper.InstrumentMapper;
import ru.andreymerkulov.trader.instrument.repository.InstrumentRepository;
import ru.andreymerkulov.trader.instrument.serveice.InstrumentService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
//@DataJpaTest
class InstrumentServiceTest {

    @Autowired
    private InstrumentService instrumentService;

    @MockBean
    private InstrumentRepository instrumentRepository;

    @Autowired
    private InstrumentMapper instrumentMapper;

    @Test
    void getAll() {
        // Given
        Instrument newInstrument1 = new Instrument("BTCUSDT", 3, 0.001f);
        Instrument newInstrument2 = new Instrument("ETHUSDT", 4, 0.0001f);
        InstrumentDto newInstrumentDto1 = instrumentMapper.instrumentToInstrumentDto(newInstrument1);
        InstrumentDto newInstrumentDto2 = instrumentMapper.instrumentToInstrumentDto(newInstrument2);

        List<Instrument> expectedInstruments = new ArrayList<>();
        expectedInstruments.add(newInstrument1);
        expectedInstruments.add(newInstrument2);

        // Настраиваем заглушку для возвращения ожидаемого списка при вызове метода getAll
        when(instrumentRepository.findAll()).thenReturn(expectedInstruments);

        // Then
        List<InstrumentDto> instrumentDtos = instrumentService.getAll();
        assertThat(instrumentDtos).contains(newInstrumentDto1, newInstrumentDto2);
        verify(instrumentRepository, times(1)).findAll();
    }

    @Test
    void testGet(){
        // Given
        Instrument newInstrument = new Instrument("BTCUSDT", 3, 0.001f);
        InstrumentDto newInstrumentDto = instrumentMapper.instrumentToInstrumentDto(newInstrument);
        given(instrumentRepository.findById(newInstrument.getSymbol())).willReturn(Optional.of(newInstrument));

        // When
        InstrumentDto foundInstrumentDto = instrumentService.get(newInstrument.getSymbol());

        // Then
        assertNotNull(foundInstrumentDto);
        assertEquals(newInstrumentDto, foundInstrumentDto);
    }
    @Test
    void testAdd(){

        // Given
        Instrument newInstrument = new Instrument("BTCUSDT", 3, 0.001f);
        InstrumentDto newInstrumentDto = instrumentMapper.instrumentToInstrumentDto(newInstrument);

        // Configure mock repository to return expected result
        when(instrumentRepository.save(newInstrument)).thenReturn(any());

        // When
        instrumentService.add(newInstrumentDto);

        // Then
        verify(instrumentRepository, times(1)).save(newInstrument);

    }
    @Test
    void testDel(){
        Instrument instrument = new Instrument("BTCUSDT", 3, 0.001f);

        // Configure mock repository to return expected result
        doNothing().when(instrumentRepository).deleteById(instrument.getSymbol());

        // When
        instrumentService.del(instrument.getSymbol());

        // Then
        verify(instrumentRepository, times(1)).deleteById(instrument.getSymbol());
    }
    @Test
    void testUpd(){
        // Given
        Instrument instrument = new Instrument("BTCUSDT", 3, 0.001f);
        InstrumentDto instrumentDto = new InstrumentDto("BTCUSDT", 3, 0.001f);

        // Configure mock repository to return expected result
        when(instrumentRepository.save(instrument)).thenReturn(any());


        // When
        instrumentService.upd(instrumentDto);

        // Then
        verify(instrumentRepository, times(1)).save(instrument);
    }
}
