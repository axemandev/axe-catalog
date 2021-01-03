package com.guitars.axe.guitars.entity;

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
@Table(name = "GUITARS")
public class Guitar {
    @Id
    private String guitarId;
    @Column
    private String manufacturer;
    @Column
    private String model;
    @Column
    private GuitarType guitarType;
    @Column
    private Properties features;
    @OneToMany(targetEntity = GuitarVariant.class, mappedBy = "guitar", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<GuitarVariant> guitarVariants;
}
