package by.hometask.library.repositories;

import by.hometask.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepositories extends JpaRepository<Book, Long> {
}
