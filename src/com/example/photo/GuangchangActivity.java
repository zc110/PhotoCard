package com.example.photo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class GuangchangActivity extends Activity {
	ImageView image;
	ListView listview;

	Adapter adapter;
	ImageView imageView1;

	/* List<Photo> list */;
	public List<String> URL;
	public List<String> URL2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sequare_two);
		listview = (ListView) findViewById(R.id.fuye_guang);
		getData();
		image = (ImageView) findViewById(R.id.sequaretwo_imageview);
		image.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

	}

	private void getData() {

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View headView = inflater.inflate(R.layout.sequare_two_head, null);
		listview.addHeaderView(headView);
		URL = new ArrayList<String>();
		URL2 = new ArrayList<String>();
		addurl();

		listview = (ListView) findViewById(R.id.fuye_guang);
		adapter = new Adapter(GuangchangActivity.this, URL, listview);

		listview.setAdapter(adapter);

	}

	public void addurl() {
		URL.add("http://img2.imgtn.bdimg.com/it/u=1628834492,3393624934&fm=206&gp=0.jpg");

		URL.add("http://img0.imgtn.bdimg.com/it/u=3662244058,51076352&fm=21&gp=0.jpg");
		URL.add("http://img0.imgtn.bdimg.com/it/u=1974388194,3782981032&fm=21&gp=0.jpg");

		URL.add("http://imgsrc.baidu.com/forum/w%3D580/sign=ae96b9ee5bafa40f3cc6ced59b65038c/87d6277f9e2f0708f55e24dce824b899a801f297.jpg");
		URL.add("http://img0.imgtn.bdimg.com/it/u=1974388194,3782981032&fm=21&gp=0.jpg");

	}

}
