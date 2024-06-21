package ru.kibedov.overtime_manager.adpater.vercel_app;

import org.junit.jupiter.api.Test;
import ru.kibedov.overtime_manager.AbstractMapperTest;
import ru.kibedov.overtime_manager.adapter.vercel_app.VercelAppMapper;
import ru.kibedov.overtime_manager.adapter.vercel_app.dto.GetProductionCalendarResponseDto;
import ru.kibedov.overtime_manager.domain.ProductionCalendar;

public class VercelAppMapperTest extends AbstractMapperTest {

    @Test
    void vercelAppMapper_mapToProductionCalendar() {
        GetProductionCalendarResponseDto getProductionCalendarResponseDto
                = readFromFile("/VercelAppMapperTest/MapToProductionCalendar/GetProductionCalendarResponseDto.json", GetProductionCalendarResponseDto.class);

        ProductionCalendar productionCalendar = VercelAppMapper.MAPPER.mapToProductionCalendar(getProductionCalendarResponseDto);

        assertEqualsToFile("/VercelAppMapperTest/MapToProductionCalendar/ProductionCalendar.json", productionCalendar);
    }
}
