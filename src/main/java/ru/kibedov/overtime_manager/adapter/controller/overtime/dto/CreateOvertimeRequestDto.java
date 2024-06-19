package ru.kibedov.overtime_manager.adapter.controller.overtime.dto;

import java.time.LocalDate;

public record CreateOvertimeRequestDto(LocalDate date, byte duration) {
}
