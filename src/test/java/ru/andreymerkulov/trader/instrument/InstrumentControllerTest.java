package ru.andreymerkulov.trader.instrument;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;
import ru.andreymerkulov.trader.instrument.serveice.InstrumentService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;


@WebMvcTest(InstrumentController.class)
class InstrumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstrumentService instrumentService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @WithMockUser
    void getAll() throws Exception {

        List<InstrumentDto> instruments = Arrays.asList(
                new InstrumentDto("AAA", 3.0F, 0.001f),
                new InstrumentDto("BBB", 111.0f, 222.0f)
        );
        when(instrumentService.getAll()).thenReturn(instruments);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/instrument"))
                        .andExpect(status().isOk())
                        .andExpect(content().json(objectMapper.writeValueAsString(instruments)));

        verify(instrumentService, times(1)).getAll();
    }

    @Test
    @WithMockUser
    void getInstrument() throws Exception {

        InstrumentDto instrumentDto = new InstrumentDto("AAA", 3.0F, 0.001f);

        when(instrumentService.get(instrumentDto.getSymbol())).thenReturn(instrumentDto);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/instrument/get/{symbol}", instrumentDto.getSymbol()))
                        .andExpect(status().isOk())
                        .andExpect(content().json(objectMapper.writeValueAsString(instrumentDto)));

        verify(instrumentService, times(1)).get(instrumentDto.getSymbol());
    }

    @Test
    @WithMockUser
    void addInstrument() throws Exception {
        InstrumentDto instrumentDto = new InstrumentDto("AAA", 3.0F, 0.001f);

        doNothing().when(instrumentService).add(instrumentDto);

        mockMvc.perform(post("/api/v1/instrument/add")
                        .with(csrf())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(instrumentDto)))
                        .andExpect(status().isOk());

        verify(instrumentService, times(1)).add(instrumentDto);
    }

    @Test
    @WithMockUser
    void delInstrument() throws Exception {

        InstrumentDto instrumentDto = new InstrumentDto("AAA", 3.0F, 0.001f);

        doNothing().when(instrumentService).del(instrumentDto.getSymbol());

        mockMvc.perform(delete("/api/v1/instrument/del/{symbol}", instrumentDto.getSymbol())
                        .with(csrf()))
                        .andExpect(status().isOk());

        verify(instrumentService, times(1)).del(instrumentDto.getSymbol());
    }

    @Test
    @WithMockUser
    void updInstrument() throws Exception {
        InstrumentDto instrumentDto = new InstrumentDto("AAA", 3.0F, 0.001f);

        doNothing().when(instrumentService).upd(instrumentDto);

        mockMvc.perform(post("/api/v1/instrument/upd")
                        .with(csrf())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(instrumentDto)))
                        .andExpect(status().isOk());

        verify(instrumentService, times(1)).upd(instrumentDto);
    }
}