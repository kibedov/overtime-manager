package ru.kibedov.overtime_manager.app.impl.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kibedov.overtime_manager.app.api.adapter.ProductionCalendarAdapter;
import ru.kibedov.overtime_manager.app.api.repository.ProductionCalendarRepository;
import ru.kibedov.overtime_manager.app.api.service.ProductionCalendarService;
import ru.kibedov.overtime_manager.domain.ProductionCalendar;

@Service
@RequiredArgsConstructor
public class ProductionCalendarServiceImpl implements ProductionCalendarService {
    private final ProductionCalendarRepository productionCalendarRepository;
    private final ProductionCalendarAdapter productionCalendarAdapter;

    @Override
    @Transactional
    public ProductionCalendar getProductionCalendar(short year) {
        ProductionCalendar productionCalendar = productionCalendarRepository.get(year);

        if (productionCalendar == null) {
            productionCalendar = productionCalendarAdapter.getProductionCalendar(year);
            productionCalendarRepository.save(productionCalendar);
        }

        return productionCalendar;
    }
}
