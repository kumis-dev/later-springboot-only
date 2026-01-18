package ru.practicum.user;

import lombok.Data;

@Data
public class UserDto {
    private String fullName;
    private String email;
    private String registrationDate;
}
