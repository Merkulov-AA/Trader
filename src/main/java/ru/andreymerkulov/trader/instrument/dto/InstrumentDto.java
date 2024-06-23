package ru.andreymerkulov.trader.instrument.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentDto {
    String symbol;
    float priceScale;
    float minOrderQty;
}
