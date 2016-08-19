package com.example.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class SlidingMenu extends HorizontalScrollView{
	private LinearLayout mWapper;
	private ViewGroup mMenu;
	private ViewGroup mContent;
	private int mScreenWidth;
	private int mMenuWidth;
	private int mMenuRightPadding=50;//dp
	private boolean once;
	private boolean isOpen;
	
	//为使用自定义属性时，调用
	public SlidingMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
		WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics=new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		mScreenWidth=outMetrics.widthPixels;
		//把dp转化为px
		mMenuRightPadding=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				50,context.getResources().getDisplayMetrics());
	}
	
	//计算子view的宽高
		//设置自己的宽高
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if(!once){
			mWapper=(LinearLayout) getChildAt(0);
			mMenu=(ViewGroup)mWapper.getChildAt(0);
			mContent=(ViewGroup)mWapper.getChildAt(1);
			mMenu.getLayoutParams().width=mScreenWidth-mMenuRightPadding;
			mMenuWidth=mScreenWidth-mMenuRightPadding;
			mContent.getLayoutParams().width=mScreenWidth;
			once=true;
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	//设置偏位移；将menu隐藏
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		if(changed){
			this.scrollTo(mMenuWidth, 0);
			isOpen=true;
		}	
	}

	public boolean onTouchEvent(MotionEvent ev) {
		int action=ev.getAction();
		switch(action){
		case MotionEvent.ACTION_UP:
			//隐藏在左边的宽度
			int scrollX=getScrollX();
			if(scrollX>=mMenuWidth/2){
				this.smoothScrollTo(mMenuWidth, 0);
				isOpen=true;
			}else{
				this.smoothScrollTo(0, 0);
				isOpen=false;
			}
			return true;
		}
		return super.onTouchEvent(ev);
	}
	//打开菜单
	public void openMenu(){
		if(isOpen)return;
		this.smoothScrollTo(mMenuWidth, 0);
		isOpen=true;
	}
	public void closeMenu(){
		if(!isOpen)return;
		this.smoothScrollTo(0, 0);
		isOpen=false;
	}
	//切换菜单
	public void toggle(){
		if(isOpen){
			closeMenu();
		}else{
			openMenu();
		}
	}
}
