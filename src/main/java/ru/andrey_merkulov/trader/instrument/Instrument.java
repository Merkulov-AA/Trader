package ru.andrey_merkulov.trader.instrument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrument {
    String symbol;
    float priceScale;
    float minOrderQty;
}
