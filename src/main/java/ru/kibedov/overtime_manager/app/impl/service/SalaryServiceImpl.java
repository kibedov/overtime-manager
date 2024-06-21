package ru.kibedov.overtime_manager.app.impl.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kibedov.overtime_manager.app.api.repository.SalaryRepository;
import ru.kibedov.overtime_manager.app.api.service.SalaryService;
import ru.kibedov.overtime_manager.domain.Salary;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final SalaryRepository salaryRepository;

    @Override
    @Transactional
    public Salary save(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public Salary getSalaryOnDate(LocalDate date) {
        List<Salary> salaries = salaryRepository.getStartedFromBefore(date);
        return salaries.stream()
                .max(Comparator.comparing(Salary::getStartedFrom))
                .orElseThrow(IllegalStateException::new);
    }
}
