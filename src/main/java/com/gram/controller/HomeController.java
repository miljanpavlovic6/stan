package com.gram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("user")
	public String user(){
		return "user";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("control")
	public String control(){
		return "control";
	}
	@GetMapping("accessDenied")
	public String accessDenied(){
		return "accessDenied";
	}
	
	@GetMapping("pocetna")
	public String index(){
		return "pocetna";
	}
	

}
