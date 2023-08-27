package ru.lozovoi.pdffinder.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.lozovoi.pdffinder.model.Doc;

@Transactional
public interface DocDAO extends JpaRepository<Doc, Long> {
}
