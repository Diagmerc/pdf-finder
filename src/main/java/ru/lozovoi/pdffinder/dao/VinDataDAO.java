package ru.lozovoi.pdffinder.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.lozovoi.pdffinder.model.VinData;

@Transactional
public interface VinDataDAO extends JpaRepository<VinData, Long> {
}
