package ru.kibedov.overtime_manager.app.api.service;

import ru.kibedov.overtime_manager.domain.ProductionCalendar;

public interface ProductionCalendarService {
    ProductionCalendar getProductionCalendar(short year);
}
