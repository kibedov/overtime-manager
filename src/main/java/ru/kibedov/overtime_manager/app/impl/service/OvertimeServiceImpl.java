package ru.kibedov.overtime_manager.app.impl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kibedov.overtime_manager.app.api.repository.OvertimeRepository;
import ru.kibedov.overtime_manager.app.api.service.OvertimeService;
import ru.kibedov.overtime_manager.domain.Overtime;

@Service
@RequiredArgsConstructor
public class OvertimeServiceImpl implements OvertimeService {
    private final OvertimeRepository overtimeRepository;

    @Override
    public Overtime save(Overtime overtime) {
        return overtimeRepository.save(overtime);
    }
}
