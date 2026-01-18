package ru.practicum.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("customBeanName")
public class MyService {
    private final ObjectMapper mapper;

    @Autowired
    public MyService(@Qualifier("myCustomObjectMapper") ObjectMapper mapper) {
        this.mapper = mapper;
    }
}
