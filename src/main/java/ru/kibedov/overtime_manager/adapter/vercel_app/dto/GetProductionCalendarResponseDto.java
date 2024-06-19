package ru.kibedov.overtime_manager.adapter.vercel_app.dto;

import java.util.List;

public record GetProductionCalendarResponseDto(Short year, List<month> months) {
    private record month(String name, Byte workingDays, Byte notWorkingDays, Byte shortDays, Short workingHours) {
    }
}
