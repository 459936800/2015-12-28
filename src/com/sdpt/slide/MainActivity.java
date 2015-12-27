package com.sdpt.slide;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;

/**
 * Tabҳ�����ƻ����л��Լ�����Ч��
 * 
 * @author xdf
 * 
 */
public class MainActivity extends Activity {

	private ViewPager mPager;// ҳ������
	private ArrayList<View> listViews; // Tabҳ���б�
	private ImageView win;// ����ͼƬ
	private ImageView[] imageviews;// ҳ��ͷ��
	private ViewGroup main;
	private ViewGroup drop;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		LayoutInflater inflater = getLayoutInflater();
		listViews = new ArrayList<View>();
		listViews.add(inflater.inflate(R.layout.item1, null));
//		listViews.add(inflater.inflate(R.layout.activity_main, null));//��δ��������⣬����������Ӱ�

		imageviews = new ImageView[listViews.size()];
		main = (ViewGroup) inflater.inflate(R.layout.mian, null);

//		drop = (ViewGroup) drop.findViewById(R.id.viewGroup);
		mPager = (ViewPager) main.findViewById(R.id.guidePages);

		for (int i = 0; i < listViews.size(); i++) {
			win = new ImageView(MainActivity.this);
			win.setLayoutParams(new LayoutParams(20, 20));
			win.setPadding(20, 0, 20, 0);
			imageviews[i] = win;

			if (i == 0) {
				// Ĭ��ѡ�е�һ��ͼƬ
				imageviews[i]
						.setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				imageviews[i].setBackgroundResource(R.drawable.page_indicator);
			}

			drop.addView(imageviews[i]);
		}

		

		mPager.setAdapter(new GuidePageAdapter());
		mPager.setOnPageChangeListener(new GuidePageChangeListener());

	}

	// ָ��ҳ������������
	class GuidePageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return listViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return super.getItemPosition(object);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).removeView(listViews.get(arg1));
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).addView(listViews.get(arg1));
			return listViews.get(arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub

		}
	}

	// ָ��ҳ������¼�������
	class GuidePageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			for (int i = 0; i < imageviews.length; i++) {
				imageviews[arg0].setBackgroundResource(R.drawable.page_indicator_focused);
				
				if (arg0 != i) {
					imageviews[i].setBackgroundResource(R.drawable.page_indicator);
				}
			}
		}
	}
}