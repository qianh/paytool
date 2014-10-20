package paytool.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import paytool.model.Account;
import paytool.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestAccount {
    private AccountService accountService;

	public AccountService getAccountService() {
		return accountService;
	}
    @Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
    
    @Test
    public void add(){
    	Account a = new Account();
    	a.setName("acconut002");
    	a.setWallet(0);
    	accountService.add(a,1);
    }
    
    @Test
    public void delete(){
    	accountService.delete(1);
    }
    
    @Test
    public void update1(){
    	Account a = accountService.find(1);
    	double d =a.getWallet();
    	d=d+500;
    	a.setWallet(d);
    	accountService.update1(a);
    }
    
    @Test
    public void update2(){
    	Account a = accountService.find(1);
    	double d =a.getWallet();
    	d=d-200;
    	a.setWallet(d);
    	accountService.update1(a);
    }
    
    @Test
    public void find(){
    	Account a = accountService.find(1);
    	System.out.println(a);
    }
    

    @Test
    public void findByName(){
    	Account a = accountService.findByName("acconut001");
    	System.out.println(a);
    }
    
    @Test
    public void findByUserId(){
    	Account a = accountService.findByUserId(2);
    	System.out.println(a);
    }
    
    @Test
    public void list(){
		List<Account> list = accountService.list(1);
		for(Account a :list){
			System.out.println(a);
		}
    }
}
