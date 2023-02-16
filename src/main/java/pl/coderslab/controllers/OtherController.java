package pl.coderslab.controllers;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.dao.ClientDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.encje.Client;
import pl.coderslab.encje.User;
import pl.coderslab.repository.ClientRepository;
import pl.coderslab.repository.TransactionRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.repository.services.TransactionService;

@Controller
@RequiredArgsConstructor
public class OtherController {
	private final TransactionService transactionService;
	private final TransactionRepository transactionRepository;
	private final UserRepository userRepository;
	private final ClientRepository clientRepository;
	private final ClientDao clientDao;
	private final UserDao userDao;

 @GetMapping(path="/showimage")
 public String showHome() {
	return "showimage";
 }

 @GetMapping(path="/getDetails")
 public String showDetails(@RequestParam String username,ModelMap model) {
	 System.out.println("------ ----------------------------"+username+"-------");
	 model.put("user",clientRepository.getDetails(username));
	 System.out.println(clientRepository.getDetails(username).toString());
	return "showdetails";
 }
 
 @GetMapping(path="/transfermoney")
 public String transferMoney() {
	return "transfer";
 }

 @PostMapping(path="/"
 		+ "transfermoney")
 public String transferMoney(@RequestParam String username,@RequestParam int amount,@RequestParam String user,ModelMap model, RedirectAttributes redirAttrs) {
	 System.out.println("##########"+LoginController.uname+"######");
	 int s=transactionService.transfer(LoginController.uname,user, Long.valueOf(amount));
	 if(s==0)
	 {
		 redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
	 }else if(s==1)
	 {
		 redirAttrs.addFlashAttribute("message", "Transaction Successful");
	 }
	 return "redirect:/transfermoney";
 }
 
 @GetMapping(path="/about")
 public String showAbout() {
	return "about";
 }
 @GetMapping(path="/contact")
 public String showContact() {
	return "contact";
 }
 @GetMapping(path="/addadmin")
 public String addAdmin() {
	return "adminregister";
 }
 @GetMapping(path="/addemp")
 public String addEmp() {
	return "empregister";
 }
 @PostMapping(path="/addadmin")
 public String regAdmin(@RequestParam String name,@RequestParam String username,
		 @RequestParam String password,
		 @RequestParam String accno,@RequestParam int mobno,
		 @RequestParam String address,@RequestParam int ifsc, @RequestParam int balance) {
	 User user = new User(username,password,"admin");
	 Client client = new Client(name,username,accno,Long.valueOf(mobno),address,Long.valueOf(ifsc),Long.valueOf(balance));
	 userDao.save(user);
	 clientDao.save(client);
	return "adminregister";
 }
 @PostMapping(path="/addemp")
 public String regEmp(@RequestParam String name,@RequestParam String username,
		 @RequestParam String password,
		 @RequestParam String accno,@RequestParam int mobno,
		 @RequestParam String address,@RequestParam int ifsc, @RequestParam int balance) {

	 User user = new User(username,password,"emp");
	 Client client = new Client(name,username,accno,Long.valueOf(mobno),address,Long.valueOf(ifsc),Long.valueOf(balance));
	 userDao.save(user);
	 clientDao.save(client);
	return "empregister";
 }
  
 @GetMapping(path="/addcust")
 public String addCust() {
	return "custregister";
 }
 @PostMapping(path="/addcust")
 public String regCust(@RequestParam String name,@RequestParam String username,
		 @RequestParam String password,
		 @RequestParam String accno,@RequestParam int mobno,
		 @RequestParam String address,@RequestParam int ifsc, @RequestParam int balance) {

	 User user = new User(username,password,"cust");
	 Client client = new Client(name,username,accno,Long.valueOf(mobno),address,Long.valueOf(ifsc),Long.valueOf(balance));
	 userDao.save(user);
	 clientDao.save(client);
	return "custregister";
 }
 
 @GetMapping(path="/showtransaction")
 public String showTransaction(ModelMap model) {
	 model.put("transaction",transactionRepository.showTransaction(LoginController.uname));
	return "showtransaction";
 }
 
 @GetMapping(path="/logout")
 public String showLogout() {
	 System.out.println(LoginController.uname);
	 LoginController.uname="";
	return "logout";
 }
}