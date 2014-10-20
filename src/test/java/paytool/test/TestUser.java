package paytool.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import paytool.model.Pager;
import paytool.model.SystemContext;
import paytool.model.User;
import paytool.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestUser {
    private UserService userService;
    
    public UserService getUserService() {
		return userService;
	}
    
    @Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Test
    public void testAdd(){
    	User u = new User();
    	u.setUsername("john");
    	u.setNickname("约翰");
    	u.setPassword("123456");
    	u.setEmail("john@163.com");
    	userService.add(u);
    }
    
    @Test
    public void testDelete(){
    	userService.delete(1);
    }
    
    @Test
    public void testUpdate(){
    	User u = new User();
    	u.setId(1);
    	u.setUsername("qianhong");
        u.setNickname("lalala");
        u.setPassword("111111");
        u.setEmail("123@123.com");
        userService.update(u);
    }
    
    @Test
    public void testFind(){
    	User u=userService.findById(2);
    	System.out.println(u);
    }
    
    @Test
    public void testFindByUsername(){
    	User u = userService.findByUsername("john");
    	System.out.println(u);
    }
    
    @Test
    public void testList(){
    	List<User> list = userService.list();
    	for(User u:list){
    	System.out.println(u);
    	}
    }
    
    @Test
    public void testpage(){
    	SystemContext.setPageOffset(6);
    	SystemContext.setPageSize(5);
    	Pager<User> ps = userService.findByPage();
    	System.out.println(ps.getTotalRecord());
    	System.out.println(ps.getTotalPage());
    	for(User u:ps.getDatas()){
    		System.out.println(u);
    	}
    }
}
