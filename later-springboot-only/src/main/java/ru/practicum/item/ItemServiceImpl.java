package ru.practicum.item;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> getAllItems(long userId) {
        List<Item> userItems = repository.findByUserId(userId);
        return ItemMapper.mapToItemDto(userItems);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> getAllItemsByTags(long userId, Set<String> tags) {
        BooleanExpression byUserId = QItem.item.user.id.eq(userId);
        BooleanExpression byAnyTag = QItem.item.tags.any().in(tags);
        Iterable<Item> foundItems = repository.findAll(byUserId.and(byAnyTag));
        QItem.item.user.id.isNotNull();
        return ItemMapper.mapToItemDto(foundItems);
    }

    @Override
    @Transactional
    public ItemDto saveItem(long userId, ItemDto itemDto) {
        Item item = repository.save(ItemMapper.mapToItem(itemDto, userId));
        return ItemMapper.mapToItemDto(item);
    }

    @Override
    public void deleteItem(long userId, long itemId) {
        repository.deleteByUserIdAndId(userId, itemId);
    }
}
