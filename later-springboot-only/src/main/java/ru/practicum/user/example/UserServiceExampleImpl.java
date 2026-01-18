package ru.practicum.user.example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.practicum.user.User;
import ru.practicum.user.UserRepository;

@Service
public class UserServiceExampleImpl implements UserServiceExample {
    private final UserRepository userRepository;

    public UserServiceExampleImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void usingPageableExample() {
        // сначала создаем описание сортировки по полю id
        Sort sortById = Sort.by(Sort.Direction.ASC, "id");
        // затем создаём описание первой "страницы" размером 32 элемента
        Pageable page = PageRequest.of(0, 32, sortById);
        do {
            // запрашиваем у базы данных страницу с данными
            Page<User> userPage = userRepository.findAll(page);
            // результат запроса получаем с помощью метода getContent()
            userPage.getContent().forEach(user -> {
                // проверяем пользователей
            });
            // для типа Page проверяем существует ли страница
            if (userPage.hasNext())
                page = PageRequest.of(userPage.getNumber() + 1, userPage.getSize(),
                        userPage.getSort());
            else page = null;
        } while (page != null);
    }
}
