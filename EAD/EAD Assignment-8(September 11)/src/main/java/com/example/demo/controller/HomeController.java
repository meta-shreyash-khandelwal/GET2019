package com.example.demo.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;

@Controller
public class HomeController {
	

    @Value("${msg}")
    private String message;

	
	@RequestMapping("/index")
	public String home(Model model) {
		model.addAttribute("msg", message);
		//System.out.println("I am here "+message);
		return "index";
	}
	
	/*  @RequestMapping(value= "/login", method= RequestMethod.GET)
	    public String doLogin(@Valid @ModelAttribute("userform") Student student, BindingResult result) {
	        if (result.hasErrors()) {
	         System.out.println("EROOR  KJSDKLFJKLSDF");
	        }
	        return "index";
	  }
	  */      
	        
	        
	@RequestMapping("/addStudent")
	public String addStudent(Model model) {
		System.out.println("I am here in 1");
		model.addAttribute("userform", new Student());
		return "addStudent";
	}
	@RequestMapping("/showStudent")
	public String showStudent() {
		return "showStudent";
	}
	
	 @RequestMapping(value= "/show", method= RequestMethod.POST)
	    public String doLogin( @ModelAttribute("userform")  @Validated Student user, BindingResult result,Model model) {
		System.out.println("I am here in do login");
		 if (result.hasErrors()) {
	        	System.out.println("Error present");
	            return "addStudent";
	        }
		 
	model.addAttribute("student", user);
	        return "detail";
	    }	
	
	
	
	@PostMapping("/details")
	    public String formPost(Student student) {
	   //model.addAttribute("student", student);
	        return "detail";
	    }
	
}