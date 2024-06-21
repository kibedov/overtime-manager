package ru.kibedov.overtime_manager.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kibedov.overtime_manager.domain.ProductionCalendar;

public interface ProductionCalendarJpaRepository extends JpaRepository<ProductionCalendar, Long> {
    ProductionCalendar findByYear(short year);
}
