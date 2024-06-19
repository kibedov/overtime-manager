package ru.kibedov.overtime_manager.adapter.vercel_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;
import ru.kibedov.overtime_manager.adapter.vercel_app.dto.GetProductionCalendarResponseDto;

@Component
public class VercelAppClient {
    private final RestClient restClient;

    public VercelAppClient(@Value("${settings.vercel-app.api.url}") String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }

    public GetProductionCalendarResponseDto getProductionCalendar(@PathVariable short year) {
        return restClient.get()
                .uri("/calendar/" + year)
                .retrieve()
                .body(GetProductionCalendarResponseDto.class);
    }
}
