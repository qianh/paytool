package paytool.service;

import java.util.List;

import paytool.model.User;
import paytool.model.Pager;

public interface UserService {
    void add(User user);
    void delete(int id);
    void update(User user);
    User findById(int id);
    User findByUsername(String username);
    List<User> list();
    Pager<User> findByPage();
}
