package paytool.service;

import java.util.List;

import paytool.model.Message;
import paytool.model.Pager;

public interface MessageService {
    void add(Message message);
    List<Message> find(int id);
    Pager<Message> findByPage(int id);
}
