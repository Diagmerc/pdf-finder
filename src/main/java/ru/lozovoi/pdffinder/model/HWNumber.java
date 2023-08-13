package ru.lozovoi.pdffinder.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "hw_number")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HWNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String number;

    @ManyToOne
    @JoinColumn(name = "hw_id")
    VinData vinData;
}
