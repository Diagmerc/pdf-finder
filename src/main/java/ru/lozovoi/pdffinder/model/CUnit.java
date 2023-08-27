package ru.lozovoi.pdffinder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;

    String variantCU;

    String hardware;

    String software;

    String bootloader;

    String scn;

    String VIN;

    String mileage;
}
