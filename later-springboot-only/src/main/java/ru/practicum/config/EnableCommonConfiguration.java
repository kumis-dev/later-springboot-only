package ru.practicum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// пример собственного конфига с аннотацией импорта других конфигов
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@Import({PersistenceConfig.class, WebConfig.class, SomeOtherConfig.class})
public @interface EnableCommonConfiguration {
}
