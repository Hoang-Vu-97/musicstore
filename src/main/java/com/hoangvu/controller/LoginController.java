package com.hoangvu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hoangvu.dao.ProductDao;

@Controller
public class LoginController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/login")
	public String login(@RequestParam (value="error", required=false) String error,
			                     @RequestParam (value="logout", required=false) String logout, 
			                     Model model) {
		
		if(error != null) {
			model.addAttribute("error", "Invalid Username or Password!");
		}
		
		if(logout != null) {
			model.addAttribute("msg", "You have been logout successfully!");
		}
		
		return "login";
	}
	
	//Logout mapping
	@RequestMapping("/logout")
	public String showLoggedout(){
	    return "redirect:/login";
	}
	
}