package paytool.dao;

import java.util.List;
import java.util.Map;

import paytool.model.Message;

public interface MessageMapper {
     void add(Message message);
     List<Message> find(int id);
     List<Message> findByPage(Map<String,Object> params);
     int getCount(Map<String,Object> params);
}
