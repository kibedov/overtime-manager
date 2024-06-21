package ru.kibedov.overtime_manager.adapter.vercel_app;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.kibedov.overtime_manager.adapter.vercel_app.dto.GetProductionCalendarResponseDto;
import ru.kibedov.overtime_manager.domain.ProductionCalendar;

import java.time.Month;

@Mapper(componentModel = "spring")
public interface VercelAppMapper {

    VercelAppMapper MAPPER = Mappers.getMapper(VercelAppMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "year", target = "year")
    @Mapping(target = "months.name", qualifiedByName = "nameConverter")
    ProductionCalendar mapToProductionCalendar(GetProductionCalendarResponseDto getProductionCalendarResponseDto);

    static Month monthNameConverter(String name) {
        return Month.valueOf(name.toUpperCase());
    }
}
