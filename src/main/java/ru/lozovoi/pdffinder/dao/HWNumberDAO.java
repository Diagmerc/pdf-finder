package ru.lozovoi.pdffinder.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.lozovoi.pdffinder.model.HWNumber;

@Transactional
public interface HWNumberDAO extends JpaRepository<HWNumber, Long>{
}
