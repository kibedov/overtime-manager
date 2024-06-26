package ru.kibedov.overtime_manager.app.impl.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kibedov.overtime_manager.app.api.repository.OvertimeRepository;
import ru.kibedov.overtime_manager.app.api.service.OvertimeService;
import ru.kibedov.overtime_manager.app.api.service.ProductionCalendarService;
import ru.kibedov.overtime_manager.app.api.service.SalaryService;
import ru.kibedov.overtime_manager.domain.MonthInfo;
import ru.kibedov.overtime_manager.domain.Overtime;
import ru.kibedov.overtime_manager.domain.ProductionCalendar;
import ru.kibedov.overtime_manager.domain.Salary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OvertimeServiceImpl implements OvertimeService {
    private static final BigDecimal COEF_FOR_WORK_ON_WEEKEND = BigDecimal.valueOf(2);

    private final OvertimeRepository overtimeRepository;
    private final ProductionCalendarService productionCalendarService;
    private final SalaryService salaryService;

    @Override
    @Transactional
    public Overtime save(Overtime overtime) {
        ProductionCalendar productionCalendar = productionCalendarService.getProductionCalendar((short) overtime.getDate().getYear());
        Salary salary = salaryService.getSalaryOnDate(overtime.getDate());
        MonthInfo monthInfo = getMonthInfo(overtime.getDate().getMonth(), productionCalendar);
        BigDecimal workingHours = BigDecimal.valueOf(monthInfo.getWorkingHours());
        BigDecimal salaryNet = salary.getNet();

        BigDecimal compensation = calculateCompensation(overtime, salaryNet, workingHours);
        overtime.setCompensation(compensation);

        return overtimeRepository.save(overtime);
    }

    private BigDecimal calculateCompensation(Overtime overtime, BigDecimal salaryNet, BigDecimal workingHours) {
        return salaryNet.divide(workingHours, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(overtime.getDuration())).multiply(COEF_FOR_WORK_ON_WEEKEND);
    }

    private MonthInfo getMonthInfo(Month month, ProductionCalendar productionCalendar) {
        return productionCalendar.getMonths().stream()
                .filter(it -> it.getName().equals(month))
                .collect(toSingleton());
    }

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }
}
