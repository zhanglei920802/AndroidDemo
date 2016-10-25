package com.example.android.apis.view;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.apis.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 循环ViewPager
 */
public class ViewPagerActivity extends Activity {
    private List<View> mViews = new ArrayList<>();
    private ViewPager mPager = null;

    private ViewPagerAdapter mViewPagerAdapter = null;
    private List<String> titleList;  //标题列表数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mPager = (ViewPager) findViewById(R.id.pager);
        mViewPagerAdapter = new ViewPagerAdapter();

        int[] img = {R.drawable.test1, R.drawable.test2, R.drawable.test3, R.drawable.test1, R.drawable.test2,
                R.drawable.test3};
        titleList = new ArrayList<String>();// 每个页面的Title数据
        titleList.add("王鹏1");
        titleList.add("姜语2");
        titleList.add("结婚3");
        titleList.add("姜语2");
        titleList.add("结婚3");
        titleList.add("结婚3");
        int length = img.length;
        for (int i = 0; i < length; i++) {
            ImageView view = (ImageView) LayoutInflater.from(this).inflate(R.layout.view_pager_item, null);
            view.setImageResource(img[i]);
            mViews.add(view);
        }
        mPager.setAdapter(mViewPagerAdapter);
        mPager.setPageMargin(200);
        mPager.setPageMarginDrawable(R.drawable.icon_share_copy);
        mPager.setCurrentItem(666);
    }

    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mViews.get(position % mViews.size());
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            int width = (int) (getResources().getDisplayMetrics().density * 120);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            container.addView(view, params);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position % mViews.size()));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // TODO Auto-generated method stub
            return titleList.get(position % mViews.size());
        }
    }
}
