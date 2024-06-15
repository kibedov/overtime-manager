package ru.kibedov.overtime_manager;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.testcontainers.shaded.org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractMapperTest {
    private final ObjectMapper objectMapper;

    protected AbstractMapperTest() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setDateFormat(new SimpleDateFormat("MM-dd-yyyy"));
        objectMapper.findAndRegisterModules();
        objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setDefaultPrettyPrinter(new MyDefaultPrettyPrinter());
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

    private static class MyDefaultPrettyPrinter extends DefaultPrettyPrinter {
        public MyDefaultPrettyPrinter() {
            this._objectIndenter = new DefaultIndenter("  ", "\n");
            this._arrayIndenter = _objectIndenter;
        }

        @Override
        public DefaultPrettyPrinter createInstance() {
            return new MyDefaultPrettyPrinter();
        }

        @Override
        public void writeObjectFieldValueSeparator(JsonGenerator g) throws IOException {
            g.writeRaw(": ");
        }
    }
}
