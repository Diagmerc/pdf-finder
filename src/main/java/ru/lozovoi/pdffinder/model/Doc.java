package ru.lozovoi.pdffinder.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @OneToMany//todo Hibernate: alter table if exists doc_c_units add constraint FKajq6anotlea5fwcxnqwpf7vu3 foreign key (c_units_id) references cunit
    List<CUnit> cUnits;
}
