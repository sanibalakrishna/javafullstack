package com.example.magicofbooks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.magicofbooks.model.Book;

import com.example.magicofbooks.repository.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRespository;
	
	@RequestMapping(value="newbook",method=RequestMethod.GET)
	public String addbookpage() {
	
		return "newbook";
	}
	
	@RequestMapping(value="newbook",method=RequestMethod.POST)
	public RedirectView createbook(ModelMap model,@RequestParam String title,@RequestParam String author,@RequestParam Double price) {
      
      Book tempbook = new Book();
      tempbook.setAuthor(author);
      tempbook.setTitle(title);
      tempbook.setPrice(price);
      bookRespository.save(tempbook);
      return new RedirectView("/list-books");
	}
	
	
	@RequestMapping(value="list-books",method=RequestMethod.GET)
	public ModelAndView bookspage() {
		List<Book> books = bookRespository.findAll();
		ModelAndView mav = new ModelAndView("list-books");
		if(books.size()>0)
		{
			
			 mav.addObject("books", books);
		}
		
       
        return mav;
		
	}
	@RequestMapping(value="updatebook",method=RequestMethod.GET)
	public ModelAndView updatebookpage(ModelMap model,@RequestParam("id") String id,@RequestParam("title") String title,@RequestParam("author") String author,@RequestParam("price") String price) {
		ModelAndView mav = new ModelAndView("updatebook");
		mav.addObject("id",id);
		mav.addObject("title",title);
		mav.addObject("author",author);
		mav.addObject("price",price);
		 return mav;
	}
	@RequestMapping(value="updatebook",method=RequestMethod.POST)
	public RedirectView updatebookdetails(RedirectAttributes redirectAttributes,@RequestParam("id") String id,@RequestParam("title") String title,@RequestParam("author") String author,@RequestParam("price") Double price) {
		Long tempid = Long.parseLong(id);
		
		
		Optional<Book> bookOptional = bookRespository.findById(tempid);

	    if (bookOptional.isPresent()) {
	        Book book = bookOptional.get();
	        book.setAuthor(author);
	        book.setTitle(title);
	        book.setPrice(price);
	        bookRespository.save(book);
	        redirectAttributes.addFlashAttribute("message", "Book " +id+" updated successfully.");
	    } else {
	        redirectAttributes.addFlashAttribute("message", "No such book found.");
	    }

	    return new RedirectView("/list-books");
	}
	
	@RequestMapping(value="deletebook",method=RequestMethod.GET)
	public RedirectView deleteabook(RedirectAttributes redirectAttributes,@RequestParam("id") String id) {
		Long tempid = Long.parseLong(id);
		
		Optional<Book> existingbook = bookRespository.findById(tempid);
		 if(existingbook.isPresent())
		 {
			 bookRespository.deleteById(tempid);
			 redirectAttributes.addFlashAttribute("message", "Book "+id+" deleted successfully.");

		
			 
		 }
		 else
		 {
			 redirectAttributes.addFlashAttribute("message","no such book found");
		 }
		
		 return new RedirectView("/list-books");
	}
	

}
