package ru.practicum.item.note;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemNoteRepository extends JpaRepository<ItemNote, Long> {
    @Query("select itNote " +
            "from ItemNote as itNote "+
            "join itNote.item as i " +
            "where i.user.id = :userId and i.url like concat('%', :url, '%')")
    List<ItemNote> findItemNoteByUserIdAndUrl(@Param("userId") Long userId, @Param("url") String url);

    List<ItemNote> findAllByItemUrlContainingAndItemUserId(String itemUrl, Long userId);

    @Query("select itNote " +
            "from ItemNote as itNote "+
            "join itNote.item as i " +
            "where i.user.id = :userId and :tag member of i.tags")
    List<ItemNote> findItemNoteByUserIdAndTag(@Param("userId") Long userId, @Param("tag") String tag);

    Page<ItemNote> findAllByItemUserId(long userId, Pageable page);
}
