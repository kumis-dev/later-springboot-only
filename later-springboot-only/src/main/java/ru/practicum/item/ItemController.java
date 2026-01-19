package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> get(@RequestHeader("X-Later-User-Id") long userId) {
        return itemService.getAllItems(userId);
    }

    @PostMapping
    public ItemDto save(@RequestHeader("X-Later-User-Id") Long userId,
                       @RequestBody ItemDto item) {
        return itemService.saveItem(userId, item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@RequestHeader("X-Later-User-Id") long userId,
                           @PathVariable(name = "itemId") long itemId) {
        itemService.deleteItem(userId, itemId);
    }
}
