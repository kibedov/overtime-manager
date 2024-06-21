package ru.kibedov.overtime_manager.app.impl.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.kibedov.overtime_manager.adapter.jpa.ProductionCalendarJpaRepository;
import ru.kibedov.overtime_manager.app.api.repository.ProductionCalendarRepository;
import ru.kibedov.overtime_manager.domain.ProductionCalendar;

@Repository
@RequiredArgsConstructor
public class ProductionCalendarRepositoryImpl implements ProductionCalendarRepository {
    private final ProductionCalendarJpaRepository jpaRepository;

    @Override
    public ProductionCalendar save(ProductionCalendar productionCalendar) {
        return jpaRepository.save(productionCalendar);
    }

    @Override
    public ProductionCalendar get(short year) {
        return jpaRepository.findByYear(year);
    }
}
