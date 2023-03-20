package com.example.magicofbooks.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.magicofbooks.model.AdminUser;
import com.example.magicofbooks.repository.AdminRepository;


import jakarta.servlet.http.HttpSession;




@Controller
public class AdminController {
	


	 @Autowired
	    private AdminRepository adminuserRepository;
	   @GetMapping("/")
	    public String showhomeForm() {
	        return "redirect:/login";
	    }
	 
	   @RequestMapping(value="login",method=RequestMethod.GET)
	    public ModelAndView showLoginForm() {
		   ModelAndView mav = new ModelAndView("admin-login");
	        return mav;
	    }
	 
	    @RequestMapping(value="login",method=RequestMethod.POST)
	    public RedirectView authenticateUser(RedirectAttributes redirectAttributes,@RequestParam String email, @RequestParam String password, HttpSession session) {
	        AdminUser user = adminuserRepository.findByEmail(email);
	        if (user != null && user.getPassword().equals(password)) {
	            session.setAttribute("adminUser", user);
	            redirectAttributes.addFlashAttribute("message", "User Logged In Succefully");
	            return new RedirectView("/dashboard");
	        } else {
	        	redirectAttributes.addFlashAttribute("message", "Please Enter Correct Email and Password");
	        	return new RedirectView("/login");
	        }
	    }
	    @GetMapping("/logout")
	    public RedirectView logout(RedirectAttributes redirectAttributes,HttpSession session) {
	        session.invalidate();
	        redirectAttributes.addFlashAttribute("message", "User Logged Out successfully.");
	        return new RedirectView("/login");
	    }
	    
	    @GetMapping("/register")
	    public String showRegistrationForm() {
	    	
	        return "admin-register";
	    }
	 
	    @PostMapping("/register")
	    public RedirectView registerUser(RedirectAttributes redirectAttributes,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("password") String password) {
	    	AdminUser existinguser = adminuserRepository.findByEmail(email);
	    	
	    	if(existinguser != null)
	    	{
	    		redirectAttributes.addFlashAttribute("message", "User Already Exists with the Email");
		        return new RedirectView("/register");
	    	}
	    	else{AdminUser user = new AdminUser();
	        user.setName(name);
	        user.setEmail(email);
	        user.setPassword(password);
	        adminuserRepository.save(user);
	        redirectAttributes.addFlashAttribute("message", "User Created and Logged In successfully.");}
	        return new RedirectView("/dashboard");
	    }
	    
	    @GetMapping("/dashboard")
	    public String dashboardpage() {
	        return "welcome";
	    }
	 

}
