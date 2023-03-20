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


import com.example.magicofbooks.model.User;

import com.example.magicofbooks.repository.UserRepository;


@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRespository;
	
	@RequestMapping(value="newuser",method=RequestMethod.GET)
	public String addbookpage() {
	
		return "newuser";
	}
	
	@RequestMapping(value="newuser",method=RequestMethod.POST)
	public RedirectView createbook(RedirectAttributes redirectAttributes,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("address") String address) {
      
      User tempuser = new User();
      tempuser.setName(name);
      tempuser.setEmail(email);
      tempuser.setAddress(address);
      userRespository.save(tempuser);
      redirectAttributes.addFlashAttribute("message", "User  created successfully.");
      return new RedirectView("/list-users");
	}
	
	
	@RequestMapping(value="list-users",method=RequestMethod.GET)
	public ModelAndView bookspage() {
		List<User> users = userRespository.findAll();
		ModelAndView mav = new ModelAndView("list-users");
		if(users.size()>0)
		{
			
			 mav.addObject("users", users);
		}
		
       
        return mav;
		
	}
	@RequestMapping(value="updateuser",method=RequestMethod.GET)
	public ModelAndView updatebookpage(ModelMap model,@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("address") String address) {
		ModelAndView mav = new ModelAndView("updateuser");
		mav.addObject("id",id);
		mav.addObject("name",name);
		mav.addObject("email",email);
		mav.addObject("address",address);
		 return mav;
	}
	@RequestMapping(value="updateuser",method=RequestMethod.POST)
	public RedirectView updatebookdetails(RedirectAttributes redirectAttributes,@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("address") String address) {
		Long tempid = Long.parseLong(id);
		
		
		Optional<User> UserOptional = userRespository.findById(tempid);

	    if (UserOptional.isPresent()) {
	        User user = UserOptional.get();
	        user.setName(name);
	        user.setEmail(email);
	        user.setAddress(address);
	        userRespository.save(user);
	        redirectAttributes.addFlashAttribute("message", "User " +id+" updated successfully.");
	    } else {
	        redirectAttributes.addFlashAttribute("message", "No such book found.");
	    }

	    return new RedirectView("/list-users");
	}
	
	@RequestMapping(value="deleteuser",method=RequestMethod.GET)
	public RedirectView deleteabook(RedirectAttributes redirectAttributes,@RequestParam("id") String id) {
		Long tempid = Long.parseLong(id);
		
		Optional<User> existingbook = userRespository.findById(tempid);
		 if(existingbook.isPresent())
		 {
			 userRespository.deleteById(tempid);
			 redirectAttributes.addFlashAttribute("message", "User"+id+" deleted successfully.");

		
			 
		 }
		 else
		 {
			 redirectAttributes.addFlashAttribute("message","no such user found");
		 }
		
		 return new RedirectView("/list-users");
	}
	

}
