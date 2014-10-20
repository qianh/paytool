package paytool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import paytool.dao.AccountMapper;
import paytool.dao.UserMapper;
import paytool.model.Account;
import paytool.model.User;

public class AccountServiceImpl implements AccountService {
    private AccountMapper accountMapper;
    private UserMapper userMapper;
    
	public UserMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}
    @Autowired
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	@Override
	public void add(Account account,int userId) {
		User u = userMapper.find(userId);
		account.setUser(u);
        accountMapper.add(account);
	}


	@Override
	public void delete(int id) {
        accountMapper.delete(id);
	}

	@Override
	public Account find(int id) {
		return accountMapper.find(id);
	}
	
	@Override
	public List<Account> list(int userId) {
		return accountMapper.list(userId);
	}
	@Override
	public void update1(Account account) {
		accountMapper.update1(account);
	}

	@Override
	public Account findByName(String name) {
		return accountMapper.findByName(name);
	}
	@Override
	public Account findByUserId(int id) {
		return accountMapper.findByUserId(id);
	}

}
