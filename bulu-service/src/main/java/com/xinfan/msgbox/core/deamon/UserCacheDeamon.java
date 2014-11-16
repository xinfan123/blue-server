package com.xinfan.msgbox.core.deamon;

import java.util.Calendar;
import java.util.Map.Entry;

import com.xinfan.msgbox.core.user.UserCache;
import com.xinfan.msgbox.core.vo.CachedUser;

public class UserCacheDeamon extends Thread{
	
	UserCache userCache;
	
	public UserCacheDeamon(UserCache target) {
		userCache = target;
	}

	@Override
	public void run() {
		for(;;)
		{
			try{
				for(Entry<Long, CachedUser> entry:userCache.getUserEntrys())
				{
					CachedUser cuser = entry.getValue();

					//7天以上没登录用户直接干掉
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.DAY_OF_MONTH, -7);
					if(cuser.getLastActiveTime().before(calendar.getTime()))
					{
						userCache.deleteUser(cuser.getUserId());
//						List<Long> ids = cuser.getInterestsMsgIds();
//						if(!CollectionUtils.isEmpty(ids))
//						{
//							for(Long id:ids)
//							{
//								CachedMessage msg = MessageContext.getInstance().getInterestsCache().getMessageById(id);
//								if(null != msg)
//									MessageContext.getInstance().getInterestsCache().deleteMessage(msg);
//							}
//						}
//						userCache.remove(entry.getValue());
					}
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			try{
				Thread.sleep(15*60*1000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	

}
