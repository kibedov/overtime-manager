package ru.kibedov.overtime_manager.app.impl.repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.kibedov.overtime_manager.adapter.jpa.SalaryJpaRepository;
import ru.kibedov.overtime_manager.app.api.repository.SalaryRepository;
import ru.kibedov.overtime_manager.domain.Salary;

@Repository
@RequiredArgsConstructor
public class SalaryRepositoryJpaAdapterImpl implements SalaryRepository {
    private final SalaryJpaRepository adapterJpa;

    @Override
    public Salary save(Salary salary) {
        return adapterJpa.save(salary);
    }

    @Override
    public Salary get(Long id) {
        return adapterJpa.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
