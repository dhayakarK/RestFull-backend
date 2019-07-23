package com.restapi.bookrentalsystemrestapi.controller;

import com.restapi.bookrentalsystemrestapi.Service.BookService;
import com.restapi.bookrentalsystemrestapi.entities.Book;
import com.restapi.bookrentalsystemrestapi.entities.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "bookrentalsystemAPI")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/Addbook")
    public Book addBook(@Valid @RequestBody Book book)
    {
        return bookService.addBook(book);
    }
    @GetMapping("/GetAll")
    public List<Book> getAllbookDetails()
    {
       return bookService.getAllBooks();
    }
    @GetMapping("/searchBybookName/{bookname}")
    public Optional<List<Book>> getBookbytitle(@PathVariable("bookname") String bookName)
    {
       return bookService.getBookbytitle(bookName);
    }

    @GetMapping("/searchByauthorName/{authorname}")
    public Optional<List<Book>> getBookByAuthorName(@PathVariable("authorname") String authorname)
    {
        return bookService.getBookbyAuthorname(authorname);
    }

   @DeleteMapping("/delete/{bookname}")
    public int deleteBook(@PathVariable("bookname") String bookname)
   {
      return bookService.deleteByAuthorName(bookname);
       //return new ResponseEntity<String>(HttpStatus.OK);
   }
   @PostMapping("/RentBook")
   public Borrower rentBook(@RequestBody Borrower borrower)
   {
     return bookService.rentBook(borrower);
   }
   @PostMapping("/Returnbook")
    public Borrower returnBook(@RequestBody Borrower borrower)
   {
       return bookService.returnBook(borrower);

   }
   @GetMapping("/GetAllBorrowers")
    public Optional<List<Borrower>> getAllBorrowers()
   {
       return bookService.getAllBorrowerDeatils();
   }
 /* @Autowired
  RestTemplate restTemplate;

    @RequestMapping(value="/template/products",method = RequestMethod.GET)
    public String getProductList() {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity=new HttpEntity<String>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.GET, httpEntity, String.class).getBody();
    }
    @RequestMapping(value = "/template/products",method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product)
    {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity=new HttpEntity<Product>(product,headers);
        return restTemplate.exchange("http://localhost:8080/products",HttpMethod.POST,httpEntity,String.class).getBody();
    }
    @RequestMapping(value = "/template/products/{id}",method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") int id,@RequestBody Product product)
    {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity=new HttpEntity<Product>(product,headers);
        return restTemplate.exchange("http://localhost:8080/products",HttpMethod.PUT,httpEntity,String.class).getBody();
    }
    @RequestMapping(value = "/template/products/{id}",method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") int id)
    {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity=new HttpEntity<Product>(headers);
        return restTemplate.exchange("http://localhost:8080/products/"+id,HttpMethod.DELETE,httpEntity,String.class).getBody();
    }*/
}
