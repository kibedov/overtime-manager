package ru.kibedov.overtime_manager.app.api.repository;

import ru.kibedov.overtime_manager.domain.Salary;

import java.time.LocalDate;
import java.util.List;

public interface SalaryRepository {
    Salary save(Salary salary);

    Salary get(Long id);

    List<Salary> getStartedFromBefore(LocalDate date);
}
