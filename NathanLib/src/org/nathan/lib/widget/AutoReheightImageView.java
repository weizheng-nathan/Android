package org.nathan.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 用于宽度为match_parent,或者固定时，高度等比例自适应，使用时scale_type要设置为center_crop
 * @author Nathan
 *
 */
public class AutoReheightImageView extends ImageView{

	public AutoReheightImageView(Context context) {
		super(context);
	}
	
	public AutoReheightImageView(Context context, AttributeSet attrs) {  
        super(context, attrs);        
    }  
  
    public AutoReheightImageView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);        
    }  
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);        
        int imgWidth = getDrawable().getIntrinsicWidth();
        int imgHeight = getDrawable().getIntrinsicHeight();
        int viewWidth = getMeasuredWidth();
        int viewHeight = getMeasuredHeight();
        float scale = (float)viewWidth / (float)imgWidth;
        viewHeight = (int)(scale * imgHeight);
        setMeasuredDimension(viewWidth, viewHeight);       
    }
    
 }
