package org.example.fit.bookstore.Service;
import org.example.fit.bookstore.Model.Book;
import org.example.fit.bookstore.Repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            books.add(book);
        }
        return books;
    }

    public Book getBook(Integer id){
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found!"));
    }

    public Book addBook(Book book){
        bookRepository.save(book);
        return book;
    }

    public Book updateBook(Book book, Integer id){
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setName(book.getName());
                    existingBook.setPrice(book.getPrice());
                    existingBook.setDescription(book.getDescription());
                    return bookRepository.save(existingBook);
                }) .orElseThrow(() ->new RuntimeException("Book not found"));
    }

    public void deleteBook(Integer id){
        bookRepository.delete(id);
    }

}
