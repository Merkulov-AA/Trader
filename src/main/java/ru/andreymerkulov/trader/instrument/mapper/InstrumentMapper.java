package ru.andreymerkulov.trader.instrument.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.andreymerkulov.trader.instrument.Instrument;
import ru.andreymerkulov.trader.instrument.dto.InstrumentDto;

import java.util.List;

@Mapper(  componentModel = "spring"
        , unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface InstrumentMapper {

    InstrumentDto instrumentToInstrumentDto(Instrument instrument);
    List<InstrumentDto> instrumentToInstrumentDto(List<Instrument> instruments);
    Instrument instrumentDtoToInstrument(InstrumentDto instrumentDto);
}
