package ru.kibedov.overtime_manager.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kibedov.overtime_manager.domain.Salary;

public interface SalaryAdapterJpa extends JpaRepository<Salary, Long> {
}
