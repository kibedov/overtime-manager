package ru.kibedov.overtime_manager.adpater.salary;

import org.junit.jupiter.api.Test;
import ru.kibedov.overtime_manager.AbstractMapperTest;
import ru.kibedov.overtime_manager.adapter.controller.salary.SalaryMapper;
import ru.kibedov.overtime_manager.adapter.controller.salary.dto.CreateSalaryRequestDto;
import ru.kibedov.overtime_manager.adapter.controller.salary.dto.SalaryResponseDto;
import ru.kibedov.overtime_manager.domain.Salary;

public class SalaryMapperTest extends AbstractMapperTest {

    @Test
    void salaryMapper_mapToSalary() {
        CreateSalaryRequestDto dto = readFromFile("/SalaryMapperTest/mapToSalary/createSalaryRequestDto.json", CreateSalaryRequestDto.class);

        Salary salary = SalaryMapper.MAPPER.mapToSalary(dto);

        assertEqualsToFile("/SalaryMapperTest/mapToSalary/salary.json", salary);
    }

    @Test
    void salaryMapper_mapToSalaryResponseDto() {
        Salary salary = readFromFile("/SalaryMapperTest/mapToSalaryResponseDto/salary.json", Salary.class);

        SalaryResponseDto responseDto = SalaryMapper.MAPPER.mapToSalaryResponseDto(salary);

        assertEqualsToFile("/SalaryMapperTest/mapToSalaryResponseDto/salaryResponseDto.json", responseDto);
    }
}
