package com.example.photo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ClearActivity extends Activity {
	ListView listview;
	ImageView image_huancun;
	SimpleAdapter simpleAdapter;// 声明simpleAdapter
	List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();

	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_clear_huancun);
		image_huancun=(ImageView)findViewById(R.id.imageview_huancun);
		image_huancun.setOnClickListener(l);
		
		listview = (ListView) findViewById(R.id.listview_clear);// 找到listview
		LayoutInflater lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);// 视图转换器
		View headerView = lif.inflate(R.layout.activity_clear_head, null);// 用视图转换器把layout转换成view
		listview.addHeaderView(headerView);// 添加到listview当中去
		String[] keys = { "img", "text_qq", "text_qingli", "count", "btn" };
		int[] viewId = { R.id.head_qq, R.id.text_qq, R.id.qingli,
				R.id.count_mb, R.id.btn };

		simpleAdapter = new SimpleAdapter(ClearActivity.this, listData,
				R.layout.activity_clear_midle, keys, viewId);
		listview.setAdapter(simpleAdapter);// 调用适配器
		getData();
		CleanLaJi();// 获取数据
	}
	OnClickListener l=new OnClickListener(){
		public void onClick(View v) {
			finish();		
		}
	};
	public void getData() {
		for (int i = 0; i < 30; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", R.drawable.qqtou);
			map.put("text_qq", "QQ");
			map.put("text_qingli", "建议清理");
			map.put("count", "8MB");
			map.put("btn", "");
			listData.add(map);
		}
	}
public void CleanLaJi(){
	
TextView clean=(TextView)findViewById(R.id.qinglilaji);
clean.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		AlertDialog alert = new AlertDialog.Builder(ClearActivity.this).create();
		alert.setTitle("是否清理选中垃圾文件？");
		alert.setIcon(R.drawable.apptupian);
		alert.setButton(DialogInterface.BUTTON_NEGATIVE, "NO",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int which) {
					}
				});
		alert.setButton(DialogInterface.BUTTON_POSITIVE, "YES",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int which) {
						Intent intent=new Intent(ClearActivity.this,ClearActivity.class);
						startActivity(intent);
						finish();
					}
				});
		alert.show();
		
	}
});
}


}
