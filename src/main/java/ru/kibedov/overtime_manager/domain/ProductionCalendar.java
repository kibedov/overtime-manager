package ru.kibedov.overtime_manager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Month;

@Getter
@Setter
@Entity
public class ProductionCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Short year;
    @Enumerated(value = EnumType.STRING)
    private Month month;
    private Byte workingDays;
    private Byte notWorkingDays;
    private Byte shortDays;
    private Short workingHours;
}
