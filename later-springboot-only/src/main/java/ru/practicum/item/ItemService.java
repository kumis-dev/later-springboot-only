package ru.practicum.item;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface ItemService {
    List<ItemDto> getAllItems(long userId);
    List<ItemDto> getAllItemsByTags(long userId, Set<String> tags);
    ItemDto saveItem(long userId, ItemDto itemDto);
    void deleteItem(long userId, long itemId);
}
