package com.guitars.axe.guitars.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GUITAR_VARIANT_PRICES")
public class GuitarVariantPrice {
    @EmbeddedId
    private GuitarVariantPriceKey guitarVariantPriceKey;
    @Column
    private Double basePrice;
    @Column
    private Double discountValue;
    @Column
    private Double discountPercent;
    @ManyToOne(targetEntity = GuitarVariant.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GUITAR_VARIANT_ID")
    @MapsId("guitarVariantId")
    @JsonBackReference
    private GuitarVariant guitarVariant;

    @Data
    @Builder
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    private static class GuitarVariantPriceKey implements Serializable {
        @Column
        private String guitarVariantId;
        @Column(nullable = false)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        private ZonedDateTime effectiveFrom;
        @Column(nullable = false)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        private ZonedDateTime effectiveTo;
    }
}
