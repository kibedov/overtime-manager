package ru.kibedov.overtime_manager.app.impl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kibedov.overtime_manager.app.api.repository.SalaryRepository;
import ru.kibedov.overtime_manager.app.api.service.SalaryService;
import ru.kibedov.overtime_manager.domain.Salary;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final SalaryRepository salaryRepository;

    @Override
    public Salary create(Salary salary) {
        return salaryRepository.save(salary);
    }
}
