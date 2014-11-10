//package com.xinfan.msgbox.service.messagecache;
//
//import java.util.List;
//
//import org.springframework.util.CollectionUtils;
//
//import com.xinfan.msgbox.service.listener.MessageChangeListener;
//import com.xinfan.msgbox.vo.CachedMessage;
//import com.xinfan.msgbox.vo.MessageQueryInfo;
//
//public abstract class AbstractMessageFilter implements MessageCache,MessageQuery{
//
//	protected MessageCache successor;
//	
//	public AbstractMessageFilter(MessageCache m) {
//		this.successor = m;
//	}
//	
//	@Override
//	public int getMessageCount() {
//		return successor.getMessageCount();
//	}
//
//	@Override
//	public List<Long> getAllMessageIds() {
//		return successor.getAllMessageIds();
//	}
//
//	@Override
//	public List<CachedMessage> getMessageByIds(List<Long> ids) {
//		return successor.getMessageByIds(ids);
//	}
//
//	@Override
//	public List<CachedMessage> getAllMessages() {
//		return successor.getAllMessages();
//	}
//
//	@Override
//	public CachedMessage getMessageById(Long msgId) {
//		return successor.getMessageById(msgId);
//	}
//
//	@Override
//	public boolean addMessage(CachedMessage msg) {
//		return successor.addMessage(msg);
//	}
//
//	@Override
//	public boolean updateMessage(CachedMessage old,CachedMessage msg) {
//		return successor.updateMessage(old,msg);
//	}
////
////	@Override
////	public boolean updateMessagePosition(CachedMessage msg) {
////		return successor.updateMessagePosition(msg);
////	}
////
////	@Override
////	public boolean updateMessageValideTime(CachedMessage msg) {
////		return successor.updateMessageValideTime(msg);
////	}
//
//	@Override
//	public boolean deleteMessage(CachedMessage msg) {
//		// TODO Auto-generated method stub
//		return successor.deleteMessage(msg);
//	}
//
//	@Override
//	public void addMessageChangeListener(MessageChangeListener listener) {
//		successor.addMessageChangeListener(listener);
//	}
//	
//	@Override
//	public List<CachedMessage> queryMessage(MessageQueryInfo queryInfo) {
//		
//		if(successor instanceof MessageQuery)
//		{
//			return ((MessageQuery) successor).queryMessage(queryInfo);
//		}else
//		{
//			List<Long> ids = queryInfo.getCandidates();
//			if(!CollectionUtils.isEmpty(ids) && !CollectionUtils.isEmpty(queryInfo.getExcludes()))
//			ids.removeAll(queryInfo.getExcludes());
//			return successor.getMessageByIds(ids);
//		}
//	}
//
//}
