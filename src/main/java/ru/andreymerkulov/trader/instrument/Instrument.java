package ru.andreymerkulov.trader.instrument;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Instrument")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Instrument {
    @Id
    String symbol;

    @Column(name = "pricescale")
    float priceScale;

    @Column(name = "minorderqty")
    float minOrderQty;
}
