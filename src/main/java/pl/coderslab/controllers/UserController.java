package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/user")
public class UserController {


 @GetMapping("/register")
 public String showRegister() {
	return "/register";
 }
 
 @GetMapping("/index")
 public String showIndex() {
	return "/index";
 }
 
 @GetMapping("/home")
 public String showHome() {
	return "/home";
 }
 
}