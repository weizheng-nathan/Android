package org.nathan.lib.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

/**
 * 网络相关工具
 * 
 * @author Nathan
 * 
 */
public class NetworkUtil {
	public static enum NetworkType {
		NET_UNKNOWN, 
		NET_2G, 
		NET_3G, 
		NET_4G, 
		NET_WIFI;
	}
	/** 判断是否有网络连接  */
	public static boolean isNetworkConnected(Context context) { 
		if (context != null) { 
			ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE); 
			NetworkInfo mNetworkInfo = cm.getActiveNetworkInfo(); 
			if (mNetworkInfo != null) { 
				return mNetworkInfo.isAvailable()&&mNetworkInfo.isConnected(); 
			} 
		} 
		return false; 
	} 

	/** 判断WIFI网络是否可用  */
	public static boolean isWifiConnected(Context context) { 
		if (context != null) { 
			ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE); 
			NetworkInfo mWiFiNetworkInfo = cm .getNetworkInfo(ConnectivityManager.TYPE_WIFI); 
			if (mWiFiNetworkInfo != null) { 
				return mWiFiNetworkInfo.isAvailable()&&mWiFiNetworkInfo.isConnected(); 
			} 
		} 
		return false; 
	} 

	/** 判断MOBILE网络是否可用  */
	public static boolean isMobileConnected(Context context) { 
		if (context != null) { 
			ConnectivityManager cm = (ConnectivityManager) context .getSystemService(Context.CONNECTIVITY_SERVICE); 
			NetworkInfo mMobileNetworkInfo = cm .getNetworkInfo(ConnectivityManager.TYPE_MOBILE); 
			if (mMobileNetworkInfo != null) { 
				return mMobileNetworkInfo.isAvailable()&&mMobileNetworkInfo.isConnected(); 
			} 
		} 
		return false; 
	} 

	public static NetworkType getNetworkType(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netinfo = cm.getActiveNetworkInfo();
		if (netinfo != null && netinfo.isConnectedOrConnecting()) {
			if (netinfo.getType() == ConnectivityManager.TYPE_WIFI) {
				return NetworkType.NET_WIFI;
			} else {
				switch (netinfo.getSubtype()) {
				case TelephonyManager.NETWORK_TYPE_GPRS:
				case TelephonyManager.NETWORK_TYPE_EDGE:
				case TelephonyManager.NETWORK_TYPE_CDMA:
				case TelephonyManager.NETWORK_TYPE_1xRTT:
				case TelephonyManager.NETWORK_TYPE_IDEN:
					return NetworkType.NET_2G;
				case TelephonyManager.NETWORK_TYPE_UMTS:
				case TelephonyManager.NETWORK_TYPE_EVDO_0:
				case TelephonyManager.NETWORK_TYPE_EVDO_A:
				case TelephonyManager.NETWORK_TYPE_HSDPA:
				case TelephonyManager.NETWORK_TYPE_HSUPA:
				case TelephonyManager.NETWORK_TYPE_HSPA:
				case TelephonyManager.NETWORK_TYPE_EVDO_B:
				case TelephonyManager.NETWORK_TYPE_EHRPD:
				case TelephonyManager.NETWORK_TYPE_HSPAP:
					return NetworkType.NET_3G;
				case TelephonyManager.NETWORK_TYPE_LTE:
					return NetworkType.NET_4G;
				default:
					return NetworkType.NET_UNKNOWN;
				}
			}
		} else {
			return NetworkType.NET_UNKNOWN;
		}
	}
	
	/** 获取wifi的ssid码
	 * SSID是你给自己的无线网络所取的名字
	 */
	public static String getWifiSSID(Context context) {					
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		String ssid=wifiInfo.getSSID();
		if(ssid!=null){//If the SSID can be decoded as UTF-8, it will be returned surrounded by double quotation marks. Otherwise, it is returned as a string of hex digits. 
			ssid=ssid.replace("\"", "");
		}
		return ssid;		
	}
	
	public static String getWifiMacAddr(Context context){
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		String ssid=wifiInfo.getMacAddress();		
		return ssid;
	}
}
