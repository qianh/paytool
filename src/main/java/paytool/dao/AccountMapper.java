package paytool.dao;

import java.util.List;

import paytool.model.Account;

public interface AccountMapper {
    void add(Account account);
    void delete(int id);
    void update1(Account account);
    Account find(int id);
    Account findByName(String name);
    Account findByUserId(int id);
    List<Account> list(int userId);
}
