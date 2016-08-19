package com.example.photo;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.photo.R;
import com.example.photo.AsyncImageLoader.ImageCallback;

public class Adapter extends BaseAdapter {
	private AsyncImageLoader asyncImageLoader;
	List<String> list;

	Context context;
	ImageView iv;
	ImageView iv2;
	private ListView listView;

	public Adapter(Context context, List<String> list, ListView listView) {
		this.context = context;
		this.list = list;

		asyncImageLoader = new AsyncImageLoader();
		this.listView = listView;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.guangchang_fuye_2, null);
		}
		iv = (ImageView) convertView.findViewById(R.id.fuyetu1);
		String url = list.get(position).toString();
		iv.setTag(url);

		Drawable cachedImage = asyncImageLoader.loadDrawable(url,
				new ImageCallback() {
					public void imageLoaded(Drawable imageDrawable,
							String imageUrl) {
						ImageView imageViewByTag = (ImageView) listView
								.findViewWithTag(imageUrl);
						if (imageViewByTag != null) {
							imageViewByTag.setImageDrawable(imageDrawable);
						}
					}
				});
		if (cachedImage == null) {
			iv.setImageResource(R.drawable.jiazaishibai);
		} else {
			iv.setImageDrawable(cachedImage);
		}

		iv2 = (ImageView) convertView.findViewById(R.id.fuyetu2);
		String url2 = list.get(position).toString();
		iv2.setTag(url2);

		Drawable cachedImage2 = asyncImageLoader.loadDrawable(url2,
				new ImageCallback() {
					public void imageLoaded(Drawable imageDrawable2,
							String imageUrl) {
						ImageView imageViewByTag2 = (ImageView) listView
								.findViewWithTag(imageUrl);
						if (imageViewByTag2 != null) {
							imageViewByTag2.setImageDrawable(imageDrawable2);
						}
					}
				});
		if (cachedImage2 == null) {
			iv2.setImageResource(R.drawable.jiazaishibai);
		} else {
			iv2.setImageDrawable(cachedImage2);
		}
		return convertView;
	}

}