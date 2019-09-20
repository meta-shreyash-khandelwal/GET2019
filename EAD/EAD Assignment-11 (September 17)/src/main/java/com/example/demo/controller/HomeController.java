package com.example.demo.controller;
import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.Student;
import com.example.demo.service.UserService;

@Controller
public class HomeController {
	@Autowired
    UserService userService;

    @Value("${msg}")
    private String message;

	
	@RequestMapping("/index")
	public String home(Model model) {
		model.addAttribute("msg", message);
		//System.out.println("I am here "+message);
		return "index";
	}
	
	  @RequestMapping(value= "/login", method= RequestMethod.GET)
	    public String doLogin(@Valid @ModelAttribute("userform") Student student, BindingResult result) {
	        if (result.hasErrors()) {
	         System.out.println("EROOR  KJSDKLFJKLSDF");
	        }
	        return "index";
	  }
	        
	        
	        
	@RequestMapping("/addStudent")
	public String addStudent(Model model) {
		System.out.println("I am here in 1");
	
		Student user=new Student();
		model.addAttribute("userform", user);
		return "addStudent";
	}
//	@RequestMapping("/create")
//	public String addStudentAfter(@ModelAttribute("userform")Student user1, Model model) {
//		System.out.println("I am here in 2");
//	userService.createUser(user1);
//		return "detail";
//	}

	
	@RequestMapping("/showStudent")
	public String showStudent(Model model) {
		
		List<Student> studentList=userService.getUser();
		//System.out.println("THE LIST IS"+studentList.get(1).getFirstName());
		model.addAttribute("users",studentList );
		return "showStudent";
	}
	
	 @RequestMapping(value= "/show", method= RequestMethod.GET)
	    public String doLogin( @ModelAttribute("userform")  @Validated Student user, BindingResult result,Model model) {
		System.out.println("I am here in do login");
		 if (result.hasErrors()) {
	        	System.out.println("Error present");
	            return "addStudent";
	        }
		 
	model.addAttribute("student", user);
	try { 
		userService.createUser(user);
		} 
		catch (Exception e) { 
		   model.addAttribute("error", "Please Choose  different Email and try again"); 
		   return "index";
		}
	

	        return "detail";
	    }	
	

	

//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
//    public ResponseEntity<Student> getUserById(@PathVariable("id") int id) {
//        System.out.println("Fetching User with id " + id);
//        Student user = userService.findById(id);
//        if (user == null) {
//            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Student>(user, HttpStatus.OK);
//    }
//
//    @PostMapping(value="/create",headers="Accept=application/json")
//    public ResponseEntity<Void> createUser(@RequestBody Student user, UriComponentsBuilder ucBuilder){
//        System.out.println("Creating User "+user.getFirstName());
//        userService.createUser(user);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//    @GetMapping(value="/get", headers="Accept=application/json")
//    public List<Student> getAllUser() {
//        List<Student> tasks=userService.getUser();
//        return tasks;
//
//    }

   

	
}