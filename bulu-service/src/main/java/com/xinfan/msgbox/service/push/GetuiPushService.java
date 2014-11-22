package com.xinfan.msgbox.service.push;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.AbstractTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.xinfan.msgbox.http.excute.mapper.WsFileConfig;

public class GetuiPushService implements PushService {

	private static final Logger logger = LoggerFactory.getLogger(PushService.class);

	String host = WsFileConfig.getInstance().getString("push.host");
	String appId = WsFileConfig.getInstance().getString("push.appid");
	String appkey = WsFileConfig.getInstance().getString("push.appkey");
	String master = WsFileConfig.getInstance().getString("push.master");

	@Override
	public void pushMessageTip(final String cid, long userid, final String msgstr) {

		if (cid == null || cid.isEmpty() || msgstr == null || msgstr.isEmpty()) {
			return;
		}

		final StringBuilder formatMsg = new StringBuilder("");

		if (msgstr != null && msgstr.length() > 20) {
			formatMsg.append(msgstr.substring(0, 20)).append("...");
		} else {
			formatMsg.append(msgstr);
		}

		new Thread() {

			@Override
			public void run() {

				try {

					IGtPush push = new IGtPush(host, appkey, master);

					push.connect();

					AbstractTemplate template = getNotificationTemplate("您有新消息", formatMsg.toString());

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

	private NotificationTemplate getNotificationTemplate(String title, String text) {
		NotificationTemplate template = new NotificationTemplate();
		// 设置APPID与APPKEY
		template.setAppId(appId);
		template.setAppkey(appkey);
		// 设置通知栏标题与内容
		template.setTitle(title);
		template.setText(text);
		// 配置通知栏图标
		template.setLogo("icon.png");
		// 配置通知栏网络图标
		template.setLogoUrl("");
		// 设置通知是否响铃，震动，或者可清除
		template.setIsRing(true);
		template.setIsVibrate(true);
		template.setIsClearable(true);
		// 透传消息设置
		//template.setTransmissionType(1);
		//template.setTransmissionContent("请输入您要透传的内容");
		return template;
	}

	private TransmissionTemplate getTransmissionTemplate(String title, String text) {

		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setTransmissionType(1);
		template.setTransmissionContent(text);
		return template;

	}

}
