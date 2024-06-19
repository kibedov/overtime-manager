package ru.kibedov.overtime_manager.adapter.controller.overtime;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kibedov.overtime_manager.adapter.controller.overtime.dto.CreateOvertimeRequestDto;
import ru.kibedov.overtime_manager.adapter.controller.overtime.dto.OvertimeResponseDto;
import ru.kibedov.overtime_manager.app.api.service.OvertimeService;
import ru.kibedov.overtime_manager.domain.Overtime;

@RestController
@RequestMapping("/api/v1/overtime")
@RequiredArgsConstructor
public class V1OvertimeController {
    private final OvertimeService overtimeService;
    private final OvertimeMapper overtimeMapper;

    @PostMapping
    public OvertimeResponseDto create(@RequestBody CreateOvertimeRequestDto createOvertimeRequestDto) {
        Overtime overtime = overtimeMapper.MAPPER.mapToOvertime(createOvertimeRequestDto);

        overtime = overtimeService.save(overtime);

        return overtimeMapper.MAPPER.mapToOvertimeResponseDto(overtime);
    }
}
