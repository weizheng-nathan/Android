package org.nathan.lib.util;

import android.content.Context;
import android.telephony.TelephonyManager;
/**
 * 手机相关工具
 * @author Nathan
 *
 */
public class PhoneUtil {
	/**
	 * 获取手机IMEI
	 * @param context
	 * @return
	 */
	public static String getIMEI(Context context){
		String imei="";
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		imei=tm.getDeviceId();
		return imei;
	}
}
