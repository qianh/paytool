package paytool.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;






import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import paytool.model.Account;
import paytool.model.Message;
import paytool.model.Pager;
import paytool.model.PayException;
import paytool.model.User;
import paytool.service.AccountService;
import paytool.service.MessageService;
import paytool.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private AccountService accountService;
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
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpServletRequest req){
		return "user/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest req,HttpSession session){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userService.findByUsername(username);
		if(user==null){
			throw new PayException("用户不存在！");
		}
	    if(!user.getPassword().equals(password)){
	    	throw new PayException("密码不正确！");
	    }
	    session.setAttribute("loginUser", user);
		return "redirect:/user/first";
	}
	
	@RequestMapping(value="/loginOut",method=RequestMethod.GET)
	public String loginOut(HttpSession session){
		session.invalidate();
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String list(HttpServletRequest req,Model model){
		//SystemContext.setPageOffset(0);
		//SystemContext.setPageSize(6);
		Pager<User> list=userService.findByPage();
		model.addAttribute("users",list);
		User user = (User)req.getSession().getAttribute("loginUser");
		Account a = accountService.findByUserId(user.getId());
		model.addAttribute("user", user);
		model.addAttribute("account", a);
		return "user/list"; 
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model){
		User u = new User();
		model.addAttribute(u);
		return "user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid User user,BindingResult br){
		if(br.hasErrors()){
			return "user/add";
		}
		userService.add(user);
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String show(HttpServletRequest req,Model model){
		User user = (User)req.getSession().getAttribute("loginUser");
		Account a = accountService.findByUserId(user.getId());
		model.addAttribute("user", user);
		model.addAttribute("account", a);
		return "user/show";
	}
	
	@RequestMapping(value="/{username}/update",method=RequestMethod.GET)
	public String update(@PathVariable String username,Model model){
		User u = userService.findByUsername(username);
		model.addAttribute("user", u);
		return "user/update";
	}
	
	@RequestMapping(value="/{username}/update",method=RequestMethod.POST)
	public String update(@PathVariable String username,@Valid User user,BindingResult br,HttpSession session){
		if(br.hasErrors()){
			return "user/update";
		}
	    int id = userService.findByUsername(username).getId();
	    user.setId(id);
		userService.update(user);
		session.setAttribute("loginUser", user);
		return "redirect:/user/show";
	}
	
	@RequestMapping(value="/first",method=RequestMethod.GET)
	public String fitstPage(HttpServletRequest req,Model model){
		User u = (User)req.getSession().getAttribute("loginUser");
		Account a = accountService.findByUserId(u.getId());
	   // List<Message> list = messageService.find(a.getId());
		Pager<Message> list = messageService.findByPage(a.getId());
		model.addAttribute("loginUser", u);
		model.addAttribute("account", a);
		model.addAttribute("message", list);
		return "user/firstP";
	}
    
	@RequestMapping(value="/{username}/img",method=RequestMethod.GET)
	public String addImg(@PathVariable String username,Model model){
		User u = userService.findByUsername(username);
		Account a = accountService.findByUserId(u.getId());
		model.addAttribute("user", u);
		model.addAttribute("account", a);
		return "user/img";
	}
	
	@RequestMapping(value="/{username}/img",method=RequestMethod.POST)
	public String addImg(@PathVariable String username, @RequestParam MultipartFile image
			 ,HttpSession session) throws IOException{
		User u = userService.findByUsername(username);
		String path = "D:\\john\\project\\paytool\\src\\main\\webapp\\resources\\img";
		File f = new File(path+"/"+image.getOriginalFilename());
		FileUtils.copyInputStreamToFile(image.getInputStream(), f);
		String fn = image.getOriginalFilename();
		u.setImg(fn);
		userService.update(u);
		
		session.setAttribute("loginUser", u);
		
		return "redirect:/user/first";
	}
	
	
}
