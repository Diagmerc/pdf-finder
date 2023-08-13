package ru.lozovoi.pdffinder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "vin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VinData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String vin;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vin_id")
    List<HWNumber> hwNumbers;
}
