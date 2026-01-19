package ru.practicum.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.user.User;

@Getter
@Setter
@AllArgsConstructor
public class ItemCountByUser {

    private User user;

    private Long count;

}
