package ru.kibedov.overtime_manager.adapter.controller.salary;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kibedov.overtime_manager.adapter.controller.salary.dto.CreateSalaryRequestDto;
import ru.kibedov.overtime_manager.adapter.controller.salary.dto.SalaryResponseDto;
import ru.kibedov.overtime_manager.app.api.service.SalaryService;
import ru.kibedov.overtime_manager.domain.Salary;

@RestController
@RequestMapping("/api/v1/salary")
@RequiredArgsConstructor
public class V1SalaryController {
    private final SalaryService salaryService;
    private final SalaryMapper salaryMapper;

    @PostMapping
    public SalaryResponseDto create(@RequestBody CreateSalaryRequestDto createSalaryRequestDto) {
        Salary salary = salaryMapper.MAPPER.mapToSalary(createSalaryRequestDto);

        salaryService.create(salary);

        return salaryMapper.MAPPER.mapToSalaryResponseDto(salary);
    }
}
