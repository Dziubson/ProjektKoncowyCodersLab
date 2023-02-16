package pl.coderslab.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.repository.UserRepository;

@Controller
@RequiredArgsConstructor
public class ShowController {

    private final UserRepository userRepository;

 @GetMapping(path="/showadmin")
 public String showAdmin(ModelMap model) {
	 model.put("alladmin",userRepository.getAll("admin"));
		return "showadmin";
 }
 
 @GetMapping(path="/showemp")
 public String showEmp(ModelMap model) {
	 model.put("allemp",userRepository.getAll("emp"));
	return "showemp";
 }
 
 @GetMapping(path="/showcust")
 public String showCust(ModelMap model) {
	 model.put("allcust",userRepository.getAll("cust"));
	return "showcust";
 }
}