package ru.kibedov.overtime_manager.app.api.service;

import ru.kibedov.overtime_manager.domain.Overtime;

public interface OvertimeService {
    Overtime save(Overtime overtime);
}
