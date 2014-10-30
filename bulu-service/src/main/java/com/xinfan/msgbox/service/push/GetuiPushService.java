package com.xinfan.msgbox.service.push;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.xinfan.msgbox.http.excute.mapper.WsFileConfig;

public class GetuiPushService implements PushService {

	private static final Logger logger = LoggerFactory.getLogger(PushService.class);

	@Override
	public void pushMessageTip(final String cid, long userid, final String msgstr) {

		if (cid == null || cid.isEmpty() || msgstr == null || msgstr.isEmpty()) {
			return;
		}

		final StringBuilder formatMsg = new StringBuilder("您有新消息");

		if (msgstr != null && msgstr.length() > 20) {
			formatMsg.append(msgstr.substring(0, 30)).append("...");
		}

		new Thread() {

			@Override
			public void run() {

				try {
					String host = WsFileConfig.getInstance().getString("push.host");
					String appId = WsFileConfig.getInstance().getString("push.appid");
					String appkey = WsFileConfig.getInstance().getString("push.appkey");
					String master = WsFileConfig.getInstance().getString("push.master");

					IGtPush push = new IGtPush(host, appkey, master);

					push.connect();

					TransmissionTemplate template = new TransmissionTemplate();
					template.setAppId(appId);
					template.setAppkey(appkey);
					template.setTransmissionType(1);
					template.setTransmissionContent(formatMsg.toString());

					SingleMessage message = new SingleMessage();
					message.setData(template);

					// 离线有效时间，单位为毫秒，可选
					message.setOfflineExpireTime(12 * 60 * 60 * 1000);
					message.setData(template);

					Target target1 = new Target();
					target1.setAppId(appId);
					target1.setClientId(cid);

					IPushResult ret = push.pushMessageToSingle(message, target1);
					System.out.println(ret.getResponse().toString());

				} catch (IOException e) {
					e.printStackTrace();
					logger.error(e.getMessage(), e);
				}

			}
		}.start();

	}

}
