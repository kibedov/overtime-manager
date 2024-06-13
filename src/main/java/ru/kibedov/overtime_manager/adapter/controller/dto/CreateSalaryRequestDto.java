package ru.kibedov.overtime_manager.adapter.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateSalaryRequestDto(BigDecimal net, LocalDate startedFrom) {
}
