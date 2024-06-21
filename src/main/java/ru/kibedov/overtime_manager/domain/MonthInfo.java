package ru.kibedov.overtime_manager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Month;

@Getter
@Setter
@Entity
public class MonthInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Month name;
    private Byte workingDays;
    private Byte notWorkingDays;
    private Byte shortDays;
    private Short workingHours;
}
