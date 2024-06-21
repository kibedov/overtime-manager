package ru.kibedov.overtime_manager.adpater.overtime;

import org.junit.jupiter.api.Test;
import ru.kibedov.overtime_manager.AbstractMapperTest;
import ru.kibedov.overtime_manager.adapter.controller.overtime.OvertimeMapper;
import ru.kibedov.overtime_manager.adapter.controller.overtime.dto.CreateOvertimeRequestDto;
import ru.kibedov.overtime_manager.adapter.controller.overtime.dto.OvertimeResponseDto;
import ru.kibedov.overtime_manager.domain.Overtime;

public class OvertimeMapperTest extends AbstractMapperTest {

    @Test
    void salaryMapper_mapToSalary() {
        CreateOvertimeRequestDto dto = readFromFile("/OvertimeMapperTest/MapToOvertime/CreateOvertimeRequestDto.json", CreateOvertimeRequestDto.class);

        Overtime overtime = OvertimeMapper.MAPPER.mapToOvertime(dto);

        assertEqualsToFile("/OvertimeMapperTest/MapToOvertime/Overtime.json", overtime);
    }

    @Test
    void salaryMapper_mapToSalaryResponseDto() {
        Overtime overtime = readFromFile("/OvertimeMapperTest/MapToOvertimeResponseDto/Overtime.json", Overtime.class);

        OvertimeResponseDto responseDto = OvertimeMapper.MAPPER.mapToOvertimeResponseDto(overtime);

        assertEqualsToFile("/OvertimeMapperTest/MapToOvertimeResponseDto/OvertimeResponseDto.json", responseDto);
    }
}
