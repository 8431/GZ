package com.gz.medicine.gzyun.push.comm;

import org.apache.log4j.Logger;

import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.gzyun.push.android.AndroidCustomizedcast;
import com.gz.medicine.gzyun.push.android.AndroidUnicast;
import com.gz.medicine.gzyun.push.ios.IOSCustomizedcast;
import com.gz.medicine.gzyun.push.ios.IOSUnicast;
import com.gz.medicine.gzyun.user.request.PushRequest;

public class SendMessage {

	private static String appkey = "57d7c0b5e0f55aaa8500205c";
	private static String appMasterSecret = "b0dkltqxjpk3ml0s4kh8yd9nriv42f5o";
	private static PushClient client = new PushClient();
	//true 正式环境  false 测试环境

	public static final Logger LOGGER = Logger.getLogger(SendMessage.class);

	public SendMessage(String key, String secret) {
		try {
			appkey = key;
			appMasterSecret = secret;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * ios单通道发送
	 *
	 * @throws Exception
	 */
	public static String sendIOSUnicast(PushRequest data) throws Exception {
		IOSUnicast unicast = new IOSUnicast(data.getAppkey(), data.getAppMasterSecret());
		// TODO Set your device token
		unicast.setDeviceToken(data.getDeviceToken());
		unicast.setAlert(data.getMessage());
		unicast.setBadge(data.getBage());
		unicast.setDescription(data.getMessage());
		if (null == data.getSendType()) {
			unicast.setSound("default");
		} else if (data.getSendType().equals("1")) {
			unicast.setSound("voiceLingsheng.caf");
		}

		// TODO set 'production_mode' to 'true' if your app is under production
		// mode
		if(PropertyUtil.getPropery("productionMode").equals("false")){
			unicast.setProductionMode();
		} else {
			unicast.setTestMode();
		}
		// Set customized fields
		if (data.getKey1name() != null || data.getKey1value() != null) {
			unicast.setCustomizedField(data.getKey1name(), data.getKey1value());
		}
		if (data.getKey2name() != null || data.getKey2value() != null) {
			unicast.setCustomizedField(data.getKey2name(), data.getKey2value());
		}

		return client.send(unicast);
	}

	/**
	 * 特定用户
	 *
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String sendIOSCustomizedcast(PushRequest data) throws Exception {
		IOSCustomizedcast customizedcast = new IOSCustomizedcast(data.getAppkey(), data.getAppMasterSecret());
		// TODO Set your alias and alias_type here, and use comma to split them
		// if there are multiple alias.
		// And if you have many alias, you can also upload a file containing
		// these alias, then
		// use file_id to send customized notification.
		// customizedcast.setAlias("alias", data.getAlias());
		customizedcast.setAlias(data.getAlias(), data.getAlias_type());
		customizedcast.setAlert(data.getMessage());
		customizedcast.setBadge(data.getBage());
		if (null == data.getSendType()) {
			customizedcast.setSound("default");
		} else if (data.getSendType().equals("1")) {
			customizedcast.setSound("voiceLingsheng.caf");
		}
		// TODO set 'production_mode' to 'true' if your app is under production
		// mode
		if(PropertyUtil.getPropery("productionMode").equals("false")){
			customizedcast.setProductionMode();
		} else {
			customizedcast.setTestMode();
		}
		customizedcast.setDescription(data.getMessage());
		if (data.getKey1name() != null || data.getKey1value() != null) {
			customizedcast.setCustomizedField(data.getKey1name(), data.getKey1value());
		}
		if (data.getKey2name() != null || data.getKey2value() != null) {
			customizedcast.setCustomizedField(data.getKey2name(), data.getKey2value());
		}
		LOGGER.info("-------customizedcast-----------start-----------: " + net.sf.json.JSONObject.fromObject(customizedcast));
		return client.send(customizedcast);
	}

	/**
	 * android 单通道发送
	 *
	 * @throws Exception
	 */
	public static String sendAndroidUnicast(PushRequest data) throws Exception {
		AndroidUnicast unicast = new AndroidUnicast(data.getAppkey(), data.getAppMasterSecret());
		// TODO Set your device token
		unicast.setDeviceToken(data.getDeviceToken());
		unicast.setTicker(data.getUmengMessageSecret());
		unicast.setTitle("咨询提醒");
		unicast.setText(data.getMessage());
		unicast.goAppAfterOpen();
		unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device.
		// For how to register a test device, please see the developer doc.
		if(PropertyUtil.getPropery("productionMode").equals("false")){
			unicast.setProductionMode();
		} else {
			unicast.setTestMode();
		}
		// Set customized fields
		if (data.getKey1name() != null || data.getKey1value() != null) {
			unicast.setExtraField(data.getKey1name(), data.getKey1value());
		}
		if (data.getKey2name() != null || data.getKey2value() != null) {
			unicast.setExtraField(data.getKey2name(), data.getKey2value());
		}
		return client.send(unicast);
	}

	/**
	 * 特定用户
	 *
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String sendAndroidCustomizedcast(PushRequest data) throws Exception {
		AndroidCustomizedcast customizedcast = new AndroidCustomizedcast(data.getAppkey(), data.getAppMasterSecret());
		// TODO Set your alias here, and use comma to split them if there are
		// multiple alias.
		// And if you have many alias, you can also upload a file containing
		// these alias, then
		// use file_id to send customized notification.
		customizedcast.setAlias("alias", data.getAlias());
		customizedcast.setTicker(data.getUmengMessageSecret());
		customizedcast.setAlias(data.getAlias(), data.getAlias_type());
		customizedcast.setTitle("咨询提醒");
		customizedcast.setText(data.getMessage());
		customizedcast.goAppAfterOpen();
		customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device.
		// For how to register a test device, please see the developer doc.
		if(PropertyUtil.getPropery("productionMode").equals("false")){
			customizedcast.setProductionMode();
		} else {
			customizedcast.setTestMode();
		}
		if (data.getKey1name() != null || data.getKey1value() != null) {
			customizedcast.setExtraField(data.getKey1name(), data.getKey1value());
		}
		if (data.getKey2name() != null || data.getKey2value() != null) {
			customizedcast.setExtraField(data.getKey2name(), data.getKey2value());
		}
		return client.send(customizedcast);
	}

}
