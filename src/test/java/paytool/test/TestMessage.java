package paytool.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;






import paytool.model.Message;
import paytool.model.Pager;
import paytool.model.SystemContext;
import paytool.service.AccountService;
import paytool.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestMessage {
	private MessageService messageService;
	private AccountService accountService;

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
    
	@Test
	public void testAdd(){
		Date date = new Date();
		SimpleDateFormat sdf  =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = sdf.format(date);
		System.out.println(s);
	}
	
	@Test
	public void testFind(){
		List<Message> find = messageService.find(1);
		for(Message m:find){
		System.out.println(m);
	}
	}
	
	@Test
	public void testPage(){
		SystemContext.setPageSize(8);
		SystemContext.setPageOffset(0);
		Pager<Message> ps = messageService.findByPage(1);
		System.out.println(ps.getTotalRecord());
		for(Message m : ps.getDatas()){
			System.out.println(m);
		}
	}
}
