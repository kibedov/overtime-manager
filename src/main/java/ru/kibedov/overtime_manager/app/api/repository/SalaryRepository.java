package ru.kibedov.overtime_manager.app.api.repository;

import ru.kibedov.overtime_manager.domain.Salary;

public interface SalaryRepository {
    Salary save(Salary salary);
    Salary get(Long id);
}
