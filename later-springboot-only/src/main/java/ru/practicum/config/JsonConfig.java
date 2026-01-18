package ru.practicum.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfig {

    // определяем бин с типом ObjectMapper
    // и именем objectMapper
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    // определяем бин с типом ObjectMapper
    // и именем myCustomObjectMapper
    @Bean(name = "myCustomObjectMapper")
    public ObjectMapper objectMapperCustom() {
        ObjectMapper mapper = new ObjectMapper();

        // указываем настройки для этого экземпляра
        // (в нашем примере конкретные настройки не важны)
        mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, true);
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        mapper.configure(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS, false);

        return mapper;
    }
}
