package paytool.dao;

import java.util.List;
import java.util.Map;
import paytool.model.User;


public interface UserMapper {
	void add(User user);
    User find(int id);
    User findByUsername(String username);
    void delete(int id);
    void update(User user);
    List<User> list();
    List<User> findByPage(Map<String,Object> params);
    int getCount(Map<String,Object> params);
}
