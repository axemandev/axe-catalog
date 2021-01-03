package com.guitars.axe.guitars.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Properties;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GUITAR_VARIANTS")
public class GuitarVariant {
    @Id
    private String guitarVariantId;
    @Column
    private Color color;
    @Column
    private int strings;
    @Column
    private Properties features;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GUITAR_ID")
    @JsonBackReference
    private Guitar guitar;
    @OneToMany(targetEntity = GuitarVariantPrice.class, mappedBy = "guitarVariant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<GuitarVariantPrice> guitarVariantPrices;
}
