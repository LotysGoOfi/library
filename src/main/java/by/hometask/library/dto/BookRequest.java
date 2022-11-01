package by.hometask.library.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class BookRequest {

    private final String name;

    private final String author;

    private final String content;

}
