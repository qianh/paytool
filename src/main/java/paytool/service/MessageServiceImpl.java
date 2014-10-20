package paytool.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import paytool.dao.MessageMapper;
import paytool.model.Message;
import paytool.model.Pager;
import paytool.model.SystemContext;


public class MessageServiceImpl implements MessageService {
    private MessageMapper messageMapper;
    
	public MessageMapper getMessageMapper() {
		return messageMapper;
	}
    @Autowired
	public void setMessageMapper(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}

	@Override
	public void add(Message message) {
		messageMapper.add(message);
	}
	@Override
	public List<Message> find(int id) {
		return messageMapper.find(id);
	}
	@Override
	public Pager<Message> findByPage(int id) {
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getPageOffset();
		String sort = SystemContext.getSort();
		String order = SystemContext.getOrder();
		Pager<Message> pages = new Pager<Message>();
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("pageOffset", pageOffset);
		params.put("pageSize", pageSize);
		params.put("order", order);
		params.put("sort", sort);
		params.put("id", id);
		List<Message> datas = messageMapper.findByPage(params);
	
		pages.setDatas(datas);
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		int totalRecord = messageMapper.getCount(params);
		pages.setTotalRecord(totalRecord);
		int totalPage = totalRecord/pageSize+1;
		pages.setTotalPage(totalPage);
		return pages;
	}
	
	

}
