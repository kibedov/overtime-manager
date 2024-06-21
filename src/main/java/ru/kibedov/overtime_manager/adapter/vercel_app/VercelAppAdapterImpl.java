package ru.kibedov.overtime_manager.adapter.vercel_app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kibedov.overtime_manager.adapter.vercel_app.dto.GetProductionCalendarResponseDto;
import ru.kibedov.overtime_manager.app.api.adapter.ProductionCalendarAdapter;
import ru.kibedov.overtime_manager.domain.ProductionCalendar;

@Component
@RequiredArgsConstructor
public class VercelAppAdapterImpl implements ProductionCalendarAdapter {
    private final VercelAppClient client;

    @Override
    public ProductionCalendar getProductionCalendar(short year) {
        GetProductionCalendarResponseDto response = client.getProductionCalendar(year);

        return VercelAppMapper.MAPPER.mapToProductionCalendar(response);
    }
}
