package ru.lozovoi.pdffinder.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vin")
@Data
@NoArgsConstructor
public class VinData {

    @Id
    String id;

    @OneToMany
    List<Doc> doc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VinData vinData = (VinData) o;
        return Objects.equals(id, vinData.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
