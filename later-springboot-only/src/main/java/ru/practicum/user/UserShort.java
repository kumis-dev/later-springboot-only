package ru.practicum.user;

// используем интерфейс чтобы получить только нужные поля
// скрывая такие как пароль
public interface UserShort {
    String getFirstName();
    String getEmail();
}
