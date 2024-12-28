package org.mertaltuntas.bookshelf;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updateBook) {
        return bookRepository.findById(id).map(book -> {
            book.setName(updateBook.getName());
            book.setAuthor(updateBook.getDescription());
            book.setPageAmount(updateBook.getPageAmount());
            book.setPrice(updateBook.getPrice());
            book.setAuthor(updateBook.getAuthor());
            book.setTranslators(updateBook.getTranslators());
            book.setEditors(updateBook.getEditors());
            book.setPublisher(updateBook.getPublisher());
            return bookRepository.save(book);
        }).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> getBookByName(String name) {
        return bookRepository.findByName(name);
    }

}
