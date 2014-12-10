package org.nathan.lib.util;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * 应用相关工具
 * @author Nathan
 *
 */
public class AppUtil {
	/**
	 * 获取应用版本名称
	 * @param context
	 * @return
	 */
	public static String getAppVersionName(Context context){
		String versionName="";
		try {
			versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS).versionName;			
		} catch (Exception e) {
			
		}
		return versionName;
	}
	
	public static int getAppVersionCode(Context context){
		int versionCode=-1;
		try {
			versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS).versionCode;			
		} catch (Exception e) {
			
		}
		return versionCode;
	}
		
}
