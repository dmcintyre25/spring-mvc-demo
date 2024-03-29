package com.devworld.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	// need a controller method to show form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process form
	@RequestMapping("/processForm")
	public String ProcessForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read request parameter from html form
		String theName = request.getParameter("studentName");
		// convert data to upper case
		theName = theName.toUpperCase();
		
		// create message
		String result = "Yo " + theName;
		
		// add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {
		
		// convert data to upper case
		theName = theName.toUpperCase();
		
		// create message
		String result = "Hey My Friend from v3! " + theName;
		
		// add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}


}
