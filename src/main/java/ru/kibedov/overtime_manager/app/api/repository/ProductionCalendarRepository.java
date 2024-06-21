package ru.kibedov.overtime_manager.app.api.repository;

import ru.kibedov.overtime_manager.domain.ProductionCalendar;

public interface ProductionCalendarRepository {
    ProductionCalendar save(ProductionCalendar productionCalendar);

    ProductionCalendar get(short year);
}
