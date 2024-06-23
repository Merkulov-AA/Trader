//package ru.andreymerkulov.trader.instrument.service;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;
//import ru.andreymerkulov.trader.instrument.repository.InstrumentDAO;
//import ru.andreymerkulov.trader.instrument.serveice.InstrumentService;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//class InstrumentServiceTest {
//
//    @Autowired
//    private InstrumentService instrumentService;
//
//    @MockBean
//    private InstrumentDAO instrumentDAO;
//
//    @Test
//    void getAll() {
//        // Given
//        InstrumentDto newInstrumentDto1 = new InstrumentDto("BTCUSDT", 3, 0.001f);
//        InstrumentDto newInstrumentDto2 = new InstrumentDto("ETHUSDT", 4, 0.0001f);
//        List<InstrumentDto> expectedInstrumentDtos = new ArrayList<>();
//        expectedInstrumentDtos.add(newInstrumentDto1);
//        expectedInstrumentDtos.add(newInstrumentDto2);
//
//        // Настраиваем заглушку для возвращения ожидаемого списка при вызове метода getAll
//        when(instrumentDAO.getAll()).thenReturn(expectedInstrumentDtos);
//
//        // Then
//        List<InstrumentDto> instrumentDtos = instrumentService.getAll();
//        assertThat(instrumentDtos).contains(newInstrumentDto1, newInstrumentDto2);
//        verify(instrumentDAO, times(1)).getAll();
//    }
//
//    @Test
//    void testGet(){
//        // Given
//        InstrumentDto instrumentDto = new InstrumentDto("BTCUSDT", 3, 0.001f);
//        given(instrumentDAO.get(instrumentDto.getSymbol())).willReturn(instrumentDto);
//
//        // When
//        InstrumentDto foundInstrumentDto = instrumentService.get(instrumentDto.getSymbol());
//
//        // Then
//        assertNotNull(foundInstrumentDto);
//        assertEquals(instrumentDto, foundInstrumentDto);
//    }
//    @Test
//    void testAdd(){
//
//        // Given
//        InstrumentDto newInstrumentDto = new InstrumentDto("BTCUSDT", 3, 0.001f);
//
//        // Configure mock repository to return expected result
//        doNothing().when(instrumentDAO).add(newInstrumentDto);
//
//        // When
//        instrumentService.add(newInstrumentDto);
//
//        // Then
//        verify(instrumentDAO, times(1)).add(newInstrumentDto);
//
//    }
//    @Test
//    void testDel(){
//        String symbol = "BTCUSDT";
//
//        // Configure mock repository to return expected result
//        doNothing().when(instrumentDAO).del(symbol);
//
//        // When
//        instrumentService.del(symbol);
//
//        // Then
//        verify(instrumentDAO, times(1)).del(symbol);
//    }
//    @Test
//    void testUpd(){
//        // Given
//        InstrumentDto updInstrumentDto = new InstrumentDto("BTCUSDT", 3, 0.001f);
//
//        // Configure mock repository to return expected result
//        doNothing().when(instrumentDAO).upd(updInstrumentDto);
//
//        // When
//        instrumentService.upd(updInstrumentDto);
//
//        // Then
//        verify(instrumentDAO, times(1)).upd(updInstrumentDto);
//    }
//}
