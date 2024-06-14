package ru.kibedov.overtime_manager.adapter.controller.salary;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.kibedov.overtime_manager.adapter.controller.salary.dto.CreateSalaryRequestDto;
import ru.kibedov.overtime_manager.adapter.controller.salary.dto.SalaryResponseDto;
import ru.kibedov.overtime_manager.domain.Salary;

@Mapper(componentModel = "spring")
public interface SalaryMapper {

    SalaryMapper MAPPER = Mappers.getMapper(SalaryMapper.class);

    //TODO разобраться почему не мапит без анотации
    @Mapping(target = "net", source = "createSalaryRequestDto.net")
    Salary mapToSalary(CreateSalaryRequestDto createSalaryRequestDto);

    SalaryResponseDto mapToSalaryResponseDto(Salary salary);
}
