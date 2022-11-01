package by.hometask.library.servises;

import by.hometask.library.dto.BookRequest;
import by.hometask.library.dto.BookResponse;

public interface BookService {
    BookResponse getBook(Long id);
    BookResponse createBook(final BookRequest bookRequest);
    BookResponse updateBook(Long id,final BookRequest bookRequest);
    BookResponse deleteBook(Long id);
}
