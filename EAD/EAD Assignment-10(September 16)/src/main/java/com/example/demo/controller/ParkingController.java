package com.example.demo.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.example.demo.model.Login;
import com.example.demo.model.Employee;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;
import com.example.demo.service.UserService;
@Controller
public class ParkingController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("/index")
	public String home(Model model,HttpSession session) {
		Employee user=new Employee();
		model.addAttribute("userform", user);
		return "index";
	}
	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute("userform") Employee user,Model model,HttpSession session) {
	
		session.setAttribute("email", user.getEmailID());
		System.out.println("HELLO user"+user.getEmailID());
		
		//model.addAttribute("userform",new Employee());
		System.out.println("HELLO "+userService.addEmployee(user));
		model.addAttribute("vehicleform", new Vehicle());
	//	System.out.println("HELLO "+userService.addEmployee(user));
		return "/vehicle";
	}
	/*@RequestMapping("/vehicle")
	public String vehicleForm(Model model,HttpSession session) {
		model.addAttribute("vehicleform", new Vehicle());
		return "vehicle";
	}
	
	*/
	
	@RequestMapping("/login")
	public String login(Model model,HttpSession session,RedirectAttributes redirectAttributes) {
			model.addAttribute("loginform", new Login());
	//session.setAttribute("email", ${"email"});
		return "login";
	}
	@RequestMapping("/addVehicle")
	public String vehicle(@ModelAttribute("vehicleform") Vehicle user,Model model) {
		System.out.println("HELLO "+userService.addVehicle(user));
		model.addAttribute("vehicleform", user);
		model.addAttribute("passform", new Pass());

		return "/passfm";
	}
	
	/*
	@PostMapping("/pass")
	public String passForm( @ModelAttribute("vehicleform")Vehicle employee, Model model) {
		model.addAttribute("vehicleform", employee);
			return "passfm";
	}
	*/
	@RequestMapping("/addPass")
	public ModelAndView vehicle(@ModelAttribute("passform") Pass user,Model model) {
		System.out.println("HELLO "+userService.addPass(user));
			return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping("/loginsuccess")
	public String loginAfter(@ModelAttribute("loginform") Login login,Model model,HttpSession session) {
		session.setAttribute("email", login.getEmail());
		
		Employee employ=userService.showEmployee1(login.getEmail());
		session.setAttribute("organ", employ.getOrganisation());
		model.addAttribute("loginfm", employ);
		return "home";
	}
	
	@RequestMapping("/loginedit")
	public String loginAfterEdit(Model model,HttpSession session) {
		
		Employee employ=userService.showEmployee1((String)session.getAttribute("email"));
		session.setAttribute("organ", employ.getOrganisation());
		model.addAttribute("loginfm", employ);
		return "home";
	}
	
	@RequestMapping("/editForm")
	public String editForm(@RequestParam("id") String emailID,Model model,HttpSession session) {
		System.out.println("ID IS AS FLL"+emailID);
		session.setAttribute("email", emailID);
		
		Employee employ=userService.showEmployee1(emailID);
		model.addAttribute("editfm", employ);
		return "editform";
	}
	
	
	@GetMapping(value = "/editing")
	public ModelAndView editFormAfter(@ModelAttribute("editfm") Employee user,Model model,HttpSession session) {
		//System.out.println("ID IN "+emailID);
		System.out.println("ID IS after"+session.getAttribute("email"));
		
		System.out.println(userService.updateEmployee(user));
		//session.setAttribute("email", emailID);
		return new ModelAndView("redirect:/loginedit");
	}
	
	@GetMapping(value = "/friendEmp")
	public String showFormAfter(Model model,HttpSession session) {
		//System.out.println("ID IN "+emailID);
		System.out.println("ID IS after"+session.getAttribute("organ"));
		List<Employee> list2=userService.getAll((String)session.getAttribute("organ"), (String)session.getAttribute("email"));
		//System.out.println("ID IN "+list2.get(1));
		//System.out.println(userService.getAll((String)session.getAttribute("organ")));
		model.addAttribute("users",list2);  
		return "friends";
	}
	
	@RequestMapping("/frienddet")
	public String friendShow(Model model,HttpSession session,@RequestParam("id") String email) {
		
		Employee employ=userService.showEmployee1(email);
		
		model.addAttribute("friendsh", employ);
		return "frienddetail";
	}
	

	
	@RequestMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";
	}
	
	
	@RequestMapping("/uploading")
	public String uploadingImage(Model model,HttpSession session) {
		
		System.out.println("The session is "+session.getAttribute("email"));
			return "uploadpic";
	}
	/*
	
	 private static String UPLOADED_FOLDER = "images/";

	 @PostMapping("/upload") // //new annotation since 4.3
	    public String singleFileUpload(@RequestParam("file") MultipartFile file,
	                                   RedirectAttributes redirectAttributes,HttpSession session) {

	        if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            
	        }

	        try {
System.out.println(session.getAttribute("email")+" KJDK ");
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = (Path) Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);

	            redirectAttributes.addFlashAttribute("message",
	                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "redirect:/login";
	        
	    }
*/
	@PostMapping("/upload") 
	public String upload(@RequestParam("file") MultipartFile file,HttpSession session,Model model) throws IOException{
	    byte[] bytes = file.getBytes();
        Path path = (Path) Paths.get("C:/Users/Shreyash/Documents/workspace-sts-3.6.0.RELEASE/com.jdbcfinalproject/src/main/resources/static/images/" + file.getOriginalFilename());
        Files.write(path, bytes);
		//System.out.println("The session is in final"+session.getAttribute("email"));
	 //   FileOutputStream fout = new FileOutputStream(upl);
	   session.setAttribute("filename", file.getOriginalFilename());
	   
	   Employee employ=userService.showEmployee1((String)session.getAttribute("email"));
	  employ.setUrl("images/"+file.getOriginalFilename());
	  System.out.println("FILE NAME "+file.getOriginalFilename());
	   System.out.println("IN CONTROL "+userService.updateImage(employ,file.getOriginalFilename()));
	   model.addAttribute("loginfm", employ);
	   return "home";
	}
	
	
}