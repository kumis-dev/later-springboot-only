package ru.practicum.user;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")
            .withZone(ZoneId.systemDefault());

    public static UserDto from(User user) {
        UserDto dto = new UserDto();
        dto.setFullName(user.getFirstName() + " " + user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setRegistrationDate(FORMATTER.format(user.getRegistrationDate()));
        return dto;
    }

    public static List<UserDto> from(Iterable<User> users) {
        List<UserDto> result = new ArrayList<>();

        for (User user : users) {
            result.add(from(user));
        }

        return result;
    }

    public static User mapToNewUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        String[] partsName = userDto.getFullName().split(" ");
        user.setFirstName(partsName[0]);
        user.setLastName(partsName.length > 1 ? partsName[1] : "");
        return user;
    }
}
