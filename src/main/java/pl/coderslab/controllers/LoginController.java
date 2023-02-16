package pl.coderslab.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.repository.UserRepository;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class LoginController {
	@Autowired
	private final UserRepository userRepository;
	public static String uname;

	@RequestMapping("/login")
	public String loginMessage(){
		return "login";
	}
	
	@RequestMapping("/validatelogin")
	public String dashboard(@RequestParam String username,@RequestParam String password,
			ModelMap model)throws IOException{
		model.put("username",username);
		uname=username;
		if (userRepository.search(username,password)) {
			return "home";
		}
		return "login";
	}
}
