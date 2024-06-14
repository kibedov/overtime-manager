package ru.kibedov.overtime_manager.adapter.controller.salary.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SalaryResponseDto(Long id, BigDecimal net, LocalDate startedFrom) {
}
