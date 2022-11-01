package by.hometask.library.servises;

import by.hometask.library.dto.BookRequest;
import by.hometask.library.dto.BookResponse;
import by.hometask.library.entities.Book;
import by.hometask.library.repositories.BookRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class ImplementBookService implements BookService {

    private final BookRepositories bookRepositories;

    @Override
    public BookResponse getBook(Long id) {
        Book book = bookRepositories.findById(id).orElseThrow(
                () -> new RuntimeException("books don't exist"));
        return bookResponseOfBook(book);
    }

    @Override
    @Transactional
    public BookResponse createBook(final BookRequest bookRequest) {
        Book book = bookOfBookRequest(bookRequest);
        book.setDate(LocalDateTime.now());
        return bookResponseOfBook(bookRepositories.save(book));
    }

    @Override
    @Transactional
    public BookResponse updateBook(Long id,final BookRequest bookRequest) {
        Book book = bookRepositories.findById(id).orElseThrow(
                () -> new RuntimeException("books don't exist"));
        book.setAuthor(bookRequest.getAuthor());
        book.setContent(bookRequest.getContent());
        book.setName(book.getName());
        return bookResponseOfBook(bookRepositories.save(book));
    }

    @Override
    @Transactional
    public BookResponse deleteBook(Long id) {
        Book book = bookRepositories.findById(id).orElseThrow(
                () -> new RuntimeException("books don't exist"));
        bookRepositories.delete(book);
        return bookResponseOfBook(book);
    }

    private Book bookOfBookRequest(BookRequest bookRequest){
        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setAuthor(bookRequest.getAuthor());
        book.setContent(bookRequest.getContent());
        return book;
    }
    private BookResponse bookResponseOfBook(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .content(book.getContent())
                .date(book.getDate())
                .name(book.getName())
                .build();
    }

}
