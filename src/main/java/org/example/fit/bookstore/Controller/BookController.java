package org.example.fit.bookstore.Controller;
import org.example.fit.bookstore.Model.Book;
import org.example.fit.bookstore.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Integer id){
        return bookService.updateBook(book, id);
    }

    @PostMapping("/{id}")
    public void deleteBook(@RequestBody Book book, @PathVariable Integer id){
         bookService.deleteBook(book, id);
    }

}
