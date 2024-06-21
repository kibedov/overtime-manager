package ru.kibedov.overtime_manager.app.impl.repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.kibedov.overtime_manager.adapter.jpa.OvertimeJpaRepository;
import ru.kibedov.overtime_manager.app.api.repository.OvertimeRepository;
import ru.kibedov.overtime_manager.domain.Overtime;

@Repository
@RequiredArgsConstructor
public class OvertimeRepositoryAdapterImpl implements OvertimeRepository {
    private final OvertimeJpaRepository adapterJpa;

    @Override
    public Overtime save(Overtime overtime) {
        return adapterJpa.save(overtime);
    }

    @Override
    public Overtime get(Long id) {
        return adapterJpa.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
