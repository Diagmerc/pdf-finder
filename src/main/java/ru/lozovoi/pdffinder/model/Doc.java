package ru.lozovoi.pdffinder.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String mileage;
    @OneToMany//todo Hibernate: alter table if exists doc_c_units add constraint FKajq6anotlea5fwcxnqwpf7vu3 foreign key (c_units_id) references cunit
    List<CUnit> cUnits;
}
