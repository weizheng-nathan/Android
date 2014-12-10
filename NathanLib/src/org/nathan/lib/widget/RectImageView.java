package org.nathan.lib.widget;

import org.nathan.lib.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
/**
 * 长方形图片框，可设置宽高比
 * 在布局XML文件中要添加xmlns:rectImage="http://schemas.android.com/apk/res/org.nathan.lib"
 * @author Nathan
 */
public class RectImageView extends ImageView {
	/**
	 * 宽/高比例
	 */
	public float ratio =1;
	public RectImageView(Context context) {
		super(context);		
	}
	public RectImageView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.RectImageView); 
        ratio = a.getFloat(R.styleable.RectImageView_ratio, 1f);
        a.recycle();
    }  
  
    public RectImageView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.RectImageView); 
        ratio = a.getFloat(R.styleable.RectImageView_ratio, 1f);
        a.recycle();
    }  
  
    @Override  
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
        setMeasuredDimension(getMeasuredWidth(), (int)(getMeasuredWidth()* ratio)); //Snap to width
    }  
}
