package ru.kibedov.overtime_manager.app.api.adapter;

import ru.kibedov.overtime_manager.domain.ProductionCalendar;

public interface ProductionCalendarAdapter {
    ProductionCalendar getProductionCalendar(short year);
}
