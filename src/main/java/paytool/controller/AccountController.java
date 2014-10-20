package paytool.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import paytool.model.Account;
import paytool.model.Message;
import paytool.model.Pager;
import paytool.model.User;
import paytool.service.AccountService;
import paytool.service.MessageService;
import paytool.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    private UserService userService;
    private MessageService messageService;

	public MessageService getMessageService() {
		return messageService;
	}
	
	@Autowired
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public AccountService getAccountService() {
		return accountService;
	}
    @Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/{username}/list",method=RequestMethod.GET)
	public String list(@PathVariable String username,Model model){
		User u = userService.findByUsername(username);
		Account a = accountService.findByUserId(u.getId());
		model.addAttribute("account", a);
		return "account/list";
	}
	
	@RequestMapping(value="/{username}/{name}/add",method=RequestMethod.GET)
	public String add(@PathVariable String name,Model model){
		Account a = accountService.findByName(name);
		model.addAttribute("account", a);
		return "account/add";
	}
	
	@RequestMapping(value="/{username}/{name}/add",method=RequestMethod.POST)
	public String add(@PathVariable String name, Account account){
		Account a = accountService.findByName(name);
		double w = a.getWallet();
	    double wallet = account.getWallet();
	    System.out.println(w+","+wallet);
	    w = w+wallet;
	    a.setWallet(w);
	    accountService.update1(a);
	    Date date = new Date();
	    SimpleDateFormat sdf  =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    String d = sdf.format(date);
	    Message message = new Message();
	    message.setDate(d);
	    message.setMessage("您的账户在"+" "+d+" "+"有资金转入");
	    message.setMoney(wallet);
	    message.setAccount(a);
	    messageService.add(message);
		return "redirect:/account/{username}/list";
	}
	
	@RequestMapping(value="/{username}/{name}/reduce",method=RequestMethod.GET)
	public String reduce(@PathVariable String name,Model model){
		Account a = accountService.findByName(name);
		model.addAttribute("account", a);
		return "account/reduce";
	}
	
	@RequestMapping(value="/{username}/{name}/reduce",method=RequestMethod.POST)
	public String reduce(@PathVariable String name, Account account){
		Account a = accountService.findByName(name);
		double w1= a.getWallet();
		double wallet = account.getWallet();
		w1 = w1-wallet;
		a.setWallet(w1);
		accountService.update1(a);
		String n = account.getName();
		Account a2 = accountService.findByName(n);
		double w2 = a2.getWallet();
		w2 = w2+wallet;
		a2.setWallet(w2);
		accountService.update1(a2);
		Date date = new Date();
	    SimpleDateFormat sdf  =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    String d = sdf.format(date);
	    Message m1 = new Message();
	    m1.setDate(d);
	    m1.setMessage("您的账户在"+" "+d+" "+"给"+" "+a2.getName()+" "+"账户进行转账");
	    m1.setMoney(-wallet);
	    m1.setAccount(a);
	    messageService.add(m1);
	    Message m2 = new Message();
	    m2.setDate(d);
	    m2.setMessage("您的账户在"+" "+d+" "+"由"+" "+a.getName()+"账户为您转账");
	    m2.setMoney(wallet);
	    m2.setAccount(a2);
	    messageService.add(m2);
		return "redirect:/account/{username}/list";
	}
	
	@RequestMapping(value="/{username}/addaccount",method=RequestMethod.GET)
	public String addAccount(Model model){
		model.addAttribute("account", new Account());
		return "account/addA";
	}
	
	@RequestMapping(value="/{username}/addaccount",method=RequestMethod.POST)
	public String addAccount(@Valid Account account,BindingResult br,HttpServletRequest req){
		if(br.hasErrors()){
			return "account/addA";
		}
		User u = (User)req.getSession().getAttribute("loginUser");
		accountService.add(account, u.getId());
		return "redirect:/account/{username}/list";
	}
	
	@RequestMapping(value="/{username}/{name}/accountlist",method=RequestMethod.GET)
	public String accountList(@PathVariable String name,Model model){
		Account a = accountService.findByName(name);
		//List<Message> list = messageService.find(a.getId());
		Pager<Message> list = messageService.findByPage(a.getId());
		model.addAttribute("message", list);
		model.addAttribute("account", a);
		return "account/accountlist";
	}
	
}
