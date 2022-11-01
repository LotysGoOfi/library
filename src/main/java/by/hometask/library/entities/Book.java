package by.hometask.library.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Book {

    @Id
    private Long id;

    private String name;

    private String author;

    private LocalDateTime date;

    private String content;

}
