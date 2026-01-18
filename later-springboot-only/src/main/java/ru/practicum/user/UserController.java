package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(UserMapper::from)
                .toList();
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return UserMapper.from(userService.saveUser(UserMapper.mapToNewUser(userDto)));
    }
}
