package ru.kibedov.overtime_manager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Salary {
    @Id
    private Long id;
    private BigDecimal net;
    private LocalDate startedFrom;
}


