package com.xinfan.msgbox.core.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.xinfan.msgbox.core.messagecache.MessageContext;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.CachedUser;


public class Handler extends Thread{

	private Socket socket;

	private String welcome = "Welcome  to console. \r\n" +
			"'countUser' :count all users\r\n" +
			"'countTopic' :count all user topics\r\n"+
			"'countMsgs' :count all messages in cache\r\n"+
			"'listUser' :show all the users\r\n"+
			"'listTopic' :show all users's topic\r\n"+
			"'listMsgs' :show all messages in cache\r\n"+
			"'quit>' to quit .\r\n";
	
	public Handler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		BufferedReader breader = null;
		BufferedWriter bwriter = null;
		try {
			breader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			bwriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
			bwriter.write(welcome);
			bwriter.flush();
			for(;;)
			{
				
				String line = null;
				try {
					line = breader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if("quit".equalsIgnoreCase(line))
				{
					bwriter.write("bye.\r\n");
					bwriter.flush();
					break;
				}else {
					handleRequest(bwriter, line);
				}
				
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				if(null != breader)
					breader.close();
				if(null != socket)
					socket.close();
				if(null != bwriter)
					bwriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
	}

	private void handleRequest(BufferedWriter bwriter, String line)
			throws IOException {
		if("countUser".equalsIgnoreCase(line))
		{
			int num = MessageContext.getInstance().getUserCache().getActiveUserCount();
			bwriter.write("current user nums: "+num+"\r\n");
			bwriter.flush();
		}else if("countTopic".equalsIgnoreCase(line))
		{
			int num = MessageContext.getInstance().getInterestsCache().getMessageCount();
			bwriter.write("current topic nums: "+num+"\r\n");
			bwriter.flush();
		}
		else if("countMsgs".equalsIgnoreCase(line))
		{
			int num = MessageContext.getInstance().getMessagePool().getMessageCount();
			bwriter.write("current message nums: "+num+"\r\n");
			bwriter.flush();
		}if("listUser".equalsIgnoreCase(line))
		{
			Iterable<Entry<Long, CachedUser>> userEnties = MessageContext.getInstance().getUserCache().getUserEntrys();
			for(Iterator<Entry<Long, CachedUser>> it=userEnties.iterator();it.hasNext();)
			{
				Entry<Long, CachedUser> ue = it.next();
				CachedUser cu = ue.getValue();
				bwriter.write(ue.getValue().getUserId()+"\t"+cu.getUser().getUserName()+"\r\n");
			}
			bwriter.flush();
		}else if("listTopic".equalsIgnoreCase(line))
		{
//			int num = MessageContext.getInstance().getInterestsCache().getMessageCount();
			List<CachedMessage> msgs = MessageContext.getInstance().getInterestsCache().getAllMessages();
			for(CachedMessage cm:msgs)
			{
				bwriter.write(cm.getMessageId()+"\t"+cm.getOriginalMsg()+"\r\n");
				System.out.print(cm.getMessageId()+"\t"+cm.getOriginalMsg()+"\r\n");
			}
			bwriter.flush();
		}
		else if("listMsgs".equalsIgnoreCase(line))
		{
//			int num = MessageContext.getInstance().getMessagePool().getMessageCount();
			List<CachedMessage> msgs = MessageContext.getInstance().getMessagePool().getAllMessages();
			for(CachedMessage cm:msgs)
			{
				bwriter.write(cm.getMessageId()+"\t"+cm.getOriginalMsg()+"\r\n");
			}
			bwriter.flush();
		}else
		{
			bwriter.write(welcome+"\r\n");
			bwriter.flush();
		}
	};
}
