package ru.lozovoi.pdffinder.model;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany
    List<HWNumber> hwNumbers;
}
