package paytool.service;

import java.util.List;

import paytool.model.Account;

public interface AccountService {
    void add(Account account,int userId);
    void update1(Account account);
    void delete(int id);
    Account find(int id);
    Account findByName(String name);
    Account findByUserId(int id);
    List<Account> list(int userId);
}
