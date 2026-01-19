package ru.practicum.item.note;

import ru.practicum.item.Item;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ItemNoteMapper {

    public static ItemNoteDto mapToItemNoteDto(ItemNote itemNote) {
        String dateOfNote = DateTimeFormatter
                .ofPattern("yyyy.MM.dd hh:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(itemNote.getDateOfNote());

        ItemNoteDto dto = new ItemNoteDto();
        dto.setId(itemNote.getId());
        dto.setItemId(itemNote.getItem().getId());
        dto.setText(itemNote.getText());
        dto.setDateOfNote(dateOfNote);
        dto.setItemUrl(itemNote.getItem().getUrl());
        return dto;
    }

    public static ItemNote mapToItemNote(ItemNoteDto itemNoteDto, Item item) {
        ItemNote itemNote = new ItemNote();
        itemNote.setItem(item);
        itemNote.setText(itemNoteDto.getText());
        return itemNote;
    }

    public static List<ItemNoteDto> mapToItemNoteDto (Iterable<ItemNote> itemNotes) {
        List<ItemNoteDto> dtos = new ArrayList<>();
        for (ItemNote itemNote : itemNotes) {
            dtos.add(mapToItemNoteDto(itemNote));
        }
        return dtos;
    }
}
