package ru.kibedov.overtime_manager.adapter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kibedov.overtime_manager.adapter.controller.dto.CreateSalaryRequestDto;
import ru.kibedov.overtime_manager.adapter.controller.dto.SalaryResponseDto;
import ru.kibedov.overtime_manager.app.api.service.SalaryService;
import ru.kibedov.overtime_manager.domain.Salary;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class V1Controller {
    private final SalaryService salaryService;

    @PostMapping(path = "/salary")
    public SalaryResponseDto create(@RequestBody CreateSalaryRequestDto createSalaryRequestDto) {
        //TODO START вынести в маппер класс
        Salary salary = new Salary();
        salary.setNet(createSalaryRequestDto.net());
        salary.setStartedFrom(createSalaryRequestDto.startedFrom());

        salaryService.create(salary);

        return new SalaryResponseDto(salary.getId(), salary.getNet(), salary.getStartedFrom());
    }
}
