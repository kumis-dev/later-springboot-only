package ru.practicum.item;

import ru.practicum.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ItemMapper {

    public static ItemDto mapToItemDto(Item item) {
        ItemDto dto = new ItemDto();
        dto.setId(item.getId());
        dto.setUserId(item.getUser().getId());
        dto.setUrl(item.getUrl());
        dto.setTags(new HashSet<>(item.getTags()));
        return dto;
    }

    public static Item mapToItem(ItemDto itemDto, long userId) {
        Item item = new Item();
        User user = new User();
        user.setId(userId);
        item.setUser(user);
        item.setUrl(itemDto.getUrl());
        item.setTags(itemDto.getTags() != null ? itemDto.getTags() : new HashSet<>());
        return item;
    }

    public static List<ItemDto> mapToItemDto(Iterable<Item> items) {
        List<ItemDto> dtos = new ArrayList<>();
        for (Item item : items) {
            dtos.add(mapToItemDto(item));
        }
        return dtos;
    }
}
