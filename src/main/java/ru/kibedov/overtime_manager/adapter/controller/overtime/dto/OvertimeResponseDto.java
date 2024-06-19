package ru.kibedov.overtime_manager.adapter.controller.overtime.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OvertimeResponseDto(Long id, LocalDate date, byte duration) {
}
