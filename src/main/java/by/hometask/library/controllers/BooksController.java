package by.hometask.library.controllers;

import by.hometask.library.dto.BookRequest;
import by.hometask.library.dto.BookResponse;
import by.hometask.library.servises.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @PostMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    private BookResponse getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private BookResponse createBook(@RequestBody final BookRequest bookRequest) {
        return bookService.createBook(bookRequest);
    }

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    private BookResponse updateBook(@RequestBody final BookRequest bookRequest, @PathVariable Long id) {
        return bookService.updateBook(id,bookRequest);
    }

    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private BookResponse deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

}
