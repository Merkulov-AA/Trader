package ru.AndreyMerkulov.Trader.Instrument;
import lombok.Data;


@Data
public class Instrument {
    String symbol;
    float priceScale;
    float minOrderQty;
}
