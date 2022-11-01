package by.hometask.library.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Builder
public class BookResponse {

    private final Long id;

    private final String name;

    private final String author;

    private final LocalDateTime date;

    private final String content;

}
