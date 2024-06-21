package ru.kibedov.overtime_manager.app.api.service;

import ru.kibedov.overtime_manager.domain.Salary;

import java.time.LocalDate;

public interface SalaryService {
    Salary save(Salary salary);

    Salary getSalaryOnDate(LocalDate date);
}
