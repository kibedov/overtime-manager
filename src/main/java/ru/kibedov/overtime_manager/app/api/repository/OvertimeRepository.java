package ru.kibedov.overtime_manager.app.api.repository;

import ru.kibedov.overtime_manager.domain.Overtime;

public interface OvertimeRepository {
    Overtime save(Overtime overtime);

    Overtime get(Long id);
}
