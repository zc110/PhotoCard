package com.example.photo;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class ZiliaoActivity extends Activity {
<<<<<<< HEAD
	protected static final int REQUEST_CODE = 1002;

	protected static final int RESULT_LOAD_IMAGE = 0;
=======
	private static final int RESULT_LOAD_IMAGE = 0;
	protected static final int REQUEST_CODE = 1002;
	protected static final String intent = null;
>>>>>>> origin/develop
	ImageView view_fanhui, view_touxiang;
	RelativeLayout tiaozhuan;
	TextView text_gexing;
	Spinner spinner;
	ArrayAdapter<String> adapter;
	List<String> list = new ArrayList<String>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gerenzhiliao);
		view_fanhui = (ImageView) findViewById(R.id.fanhui_geren);
		view_fanhui.setOnClickListener(l);
<<<<<<< HEAD
	
		view_touxiang = (ImageView) findViewById(R.id.touxiang_imageview);
		view_touxiang.setOnClickListener(l);
		text_gexing=(TextView)findViewById(R.id.text_gexing);
=======

		view_touxiang = (ImageView) findViewById(R.id.touxiang_imageview);
		view_touxiang.setOnClickListener(l);

>>>>>>> origin/develop
		tiaozhuan = (RelativeLayout) findViewById(R.id.tiaozhuan);
		tiaozhuan.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ZiliaoActivity.this,
						QianmingActivity.class);
<<<<<<< HEAD
				intent.putExtra("qianming",text_gexing.getText().toString());
				startActivityForResult(intent, REQUEST_CODE);	
			}
		});
			
=======
				startActivityForResult(intent, REQUEST_CODE);

			}
		});
		text_gexing = (TextView) findViewById(R.id.text_gexing);
		String str = getIntent().getStringExtra("qianming");
		text_gexing.setText(str);

>>>>>>> origin/develop
		spinner = (Spinner) findViewById(R.id.spinner_ziliao);
		adapter = new ArrayAdapter<String>(ZiliaoActivity.this,
				android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		list.add("男");
		list.add("女");
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
<<<<<<< HEAD
					int position, long id) {		
			}
			public void onNothingSelected(AdapterView<?> parent) {			
			}
		});
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==1002&&data!=null&&data.getExtras()!=null){
			
			String str=data.getExtras().getString("qianming");
			text_gexing.setText(str);
			super.onActivityResult(requestCode, resultCode, data);
		}
	};
=======
					int position, long id) {
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	protected void OnActivityResult(int i, int j, Intent intent2) {
		// TODO Auto-generated method stub

	}

>>>>>>> origin/develop
	OnClickListener l = new OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.fanhui_geren:
				finish();
				break;
			case R.id.touxiang_imageview:
<<<<<<< HEAD
				Intent intent = new Intent(Intent.ACTION_PICK,
=======
				Intent intent = new Intent(
						Intent.ACTION_PICK,
>>>>>>> origin/develop
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, RESULT_LOAD_IMAGE);
				break;
			default:
				break;
			}
		}
	};
}
