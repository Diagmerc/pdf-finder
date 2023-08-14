package ru.lozovoi.pdffinder.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.lozovoi.pdffinder.model.CUnit;

@Transactional
public interface CUnitDAO extends JpaRepository<CUnit, Long> {
}
