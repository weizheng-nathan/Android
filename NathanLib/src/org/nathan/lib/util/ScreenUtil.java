package org.nathan.lib.util;

import java.lang.reflect.Field;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 屏幕工具
 * @author Nathan
 *
 */
public class ScreenUtil {
	/**
	 * 获取屏幕密度
	 * @param context
	 * @return
	 */
	public static float getScreenDensity(Context context){
		return context.getResources().getDisplayMetrics().density; 
	}
	
	/**
	 * dip转pixel
	 * @param context
	 * @param dipValue
	 * @return
	 */
	public static int dip2px(Context context,float dipValue) { 
		float scale = ScreenUtil.getScreenDensity(context);
		return (int)(dipValue * scale + 0.5f); 
	} 
	
	/**
	 * pixel转dip
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int px2dip(Context context,float pxValue){
		float scale = ScreenUtil.getScreenDensity(context);
		return (int)(pxValue/scale+0.5f);
	}
	
	/**
	 * 获取系统状态栏高度,以px为单位
	 * @param context
	 * @return
	 */
	public static int getSystemStatusBarHeight(Context context){
		Class<?> c = null;
        Object obj = null;
        Field field = null;
        int id= 0;
        int statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            id = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(id);
        } catch (Exception e1) {
            e1.printStackTrace();
        } 
        return statusBarHeight;
	}
	
	/**
	 * 获取屏幕宽度，跟screen orietation有关
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context){
		return context.getResources().getDisplayMetrics().heightPixels;
	}
	
	/**
	 * 获取屏幕高度，跟screen orietation有关
	 * @param context
	 * @return
	 */
	public static int getScreenWidth(Context context){
		return context.getResources().getDisplayMetrics().widthPixels;
	}
	
	/**
	 * 获取屏幕宽度，高度，跟screen orietation有关
	 * @param context
	 * @return
	 */
	public static int[] getScreenResolution(Context context){
		DisplayMetrics dm=context.getResources().getDisplayMetrics();
		return new int[]{dm.widthPixels,dm.heightPixels};
	}
}
