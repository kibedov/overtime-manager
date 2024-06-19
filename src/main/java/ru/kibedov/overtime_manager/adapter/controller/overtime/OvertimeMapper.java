package ru.kibedov.overtime_manager.adapter.controller.overtime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.kibedov.overtime_manager.adapter.controller.overtime.dto.CreateOvertimeRequestDto;
import ru.kibedov.overtime_manager.adapter.controller.overtime.dto.OvertimeResponseDto;
import ru.kibedov.overtime_manager.domain.Overtime;

@Mapper(componentModel = "spring")
public interface OvertimeMapper {

    OvertimeMapper MAPPER = Mappers.getMapper(OvertimeMapper.class);

    @Mapping(source = "duration", target = "duration")
    Overtime mapToOvertime(CreateOvertimeRequestDto createOvertimeRequestDto);

    OvertimeResponseDto mapToOvertimeResponseDto(Overtime overtime);
}
