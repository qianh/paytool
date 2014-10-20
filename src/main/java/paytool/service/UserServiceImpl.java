package paytool.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import paytool.dao.UserMapper;
import paytool.model.SystemContext;
import paytool.model.User;
import paytool.model.Pager;

public class UserServiceImpl implements UserService{
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public void add(User user) {
		userMapper.add(user);
	}
	@Override
	public void delete(int id) {
		userMapper.delete(id);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public User findById(int id) {
		return userMapper.find(id);
	}

	@Override
	public List<User> list() {
		return userMapper.list();
	}

	@Override
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}

	@Override
	public Pager<User> findByPage() {
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getPageOffset();
		String sort = SystemContext.getSort();
		String order = SystemContext.getOrder();
		Pager<User> pages = new Pager<User>();
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("pageOffset", pageOffset);
		params.put("pageSize", pageSize);
		params.put("order", order);
		params.put("sort", sort);
		List<User> datas = userMapper.findByPage(params);
		
		pages.setDatas(datas);
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		int totalRecord = userMapper.getCount(params);
		pages.setTotalRecord(totalRecord);
		int totalPage = totalRecord/pageSize+1;
		pages.setTotalPage(totalPage);
		return pages;
	}



}
