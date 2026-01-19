package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return repository.findAll().stream()
                .map(UserMapper::from)
                .toList();
    }

    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.mapToNewUser(userDto);
        user.setState(UserState.ACTIVE);
        return UserMapper.from(repository.save(user));
    }
}
