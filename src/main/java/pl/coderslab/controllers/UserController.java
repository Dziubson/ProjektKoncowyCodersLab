package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


 @GetMapping(path="/register")
 public String showRegister() {
	return "register";
 }
 
 @GetMapping(path="/index")
 public String showIndex() {
	return "index";
 }
 
 @GetMapping(path="/home")
 public String showHome() {
	return "home";
 }
 
}