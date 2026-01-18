package ru.practicum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfig.class, WebConfig.class, SomeOtherConfig.class})
public class AppConfig {
}
