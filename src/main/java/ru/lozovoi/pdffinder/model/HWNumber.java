package ru.lozovoi.pdffinder.model;


import lombok.*;
import jakarta.persistence.*;


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
}
