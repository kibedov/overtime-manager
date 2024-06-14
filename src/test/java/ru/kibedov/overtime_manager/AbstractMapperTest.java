package ru.kibedov.overtime_manager;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.testcontainers.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import org.testcontainers.shaded.org.apache.commons.io.IOUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractMapperTest {
    private final ObjectMapper objectMapper;

    protected AbstractMapperTest() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @SneakyThrows
    protected <T> T readFromFile(String resourcePath, Class<T> clazz) {
        String resourceContent = IOUtils.toString(this.getClass().getResourceAsStream(resourcePath), "UTF-8");

        return objectMapper.readValue(resourceContent, clazz);
    }

    @SneakyThrows
    protected void assertEqualsToFile(String expectPath, Object actual) {
        String expectContent = IOUtils.toString(this.getClass().getResourceAsStream(expectPath), "UTF-8");

        assertEquals(expectContent, objectMapper.writeValueAsString(actual));
    }
}
