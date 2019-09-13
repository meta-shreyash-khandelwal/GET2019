package com.example.demo.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.example.demo.model.Login;
import com.example.demo.model.RegisterClass;
import com.example.demo.model.Vehicle;
@Controller
public class ParkingController {
	

	@RequestMapping("/index")
	public String home(Model model) {
		model.addAttribute("userform", new RegisterClass());
		return "index";
	}
	@RequestMapping("/login")
	public String login(Model model,HttpSession session) {
		//model.addAttribute("loginform", new Login());
		//session.setAttribute("email", ${"email"});
		return "login";
	}
	@RequestMapping("/vehicle")
	public String vehicle(Model model) {
		model.addAttribute("vehicleform", new Vehicle());
		return "vehicle";
	}
	@PostMapping("/pass")
	public String passForm( @ModelAttribute("vehicleform")Vehicle employee, Model model) {
		model.addAttribute("vehicleform", employee);
		
		return "pass";
	}
	
	@RequestMapping("/loginsuccess")
	public String loginAfter(@ModelAttribute("loginform") Login login,Model model,HttpSession session) {
		//if(session.getAttribute("email"))
			
		model.addAttribute("loginp", login);
		return "home";
	}
	
	@RequestMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	
}