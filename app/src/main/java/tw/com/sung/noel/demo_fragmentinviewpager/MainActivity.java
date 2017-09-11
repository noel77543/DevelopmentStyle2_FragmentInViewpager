package tw.com.sung.noel.demo_fragmentinviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import butterknife.BindView;
import butterknife.ButterKnife;
import tw.com.sung.noel.demo_fragmentinviewpager.one.container.OneContainer;
import tw.com.sung.noel.demo_fragmentinviewpager.three.container.ThreeContainer;
import tw.com.sung.noel.demo_fragmentinviewpager.two.container.TwoContainer;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(android.R.id.tabhost)
    FragmentTabHost tabhost;


    private int[] tabImages;
    private int[] pages;

    private Class[] classes;
    private String[] tabsTitle;
    public MainPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTabs();
        setTabs();
        setTabsListener();

    }


    /**
     * 事件監聽
     */
    private void setTabsListener() {

        tabhost.setOnTabChangedListener(this);
        viewPager.addOnPageChangeListener(this);
        Log.e("setTabsListener", "setTabsListener");

    }

    /**
     * 初始化所有Tabs所需功能
     */
    private void initTabs() {
        tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabhost.getTabWidget().setDividerDrawable(null);

        pages = new int[]{0, 1, 2};
        tabImages = new int[]{R.drawable.selector_tab_btn_home, R.drawable.selector_tab_btn_favorite, R.drawable.selector_tab_btn_news};
        tabsTitle = getResources().getStringArray(R.array.main_tabs_title);
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), tabsTitle);
        classes = new Class[]{OneContainer.class, TwoContainer.class, ThreeContainer.class};
    }

    //------------------

    /**
     * 客製化TAB樣式
     */

    private View getTabView(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.module_tab, null);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageResource(tabImages[index]);
        return view;
    }


    //------------------

    /**
     * 加入TAB
     */
    private void setTabs() {

        for (int i = 0; i < pages.length; i++) {
            tabhost.addTab(tabhost.newTabSpec(tabsTitle[i]).setIndicator(getTabView(i)), classes[i], null);
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(Color.BLACK);
        }
        pagerAdapter.setData(pages);
        viewPager.setAdapter(pagerAdapter);

        Log.e("setTabs", "setTabs");

    }

    //------------------

    /**
     * listener
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        tabhost.setCurrentTab(position);
        cleanViewPagerState();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onTabChanged(String s) {
        viewPager.setCurrentItem(tabhost.getCurrentTab());
        cleanViewPagerState();

    }

    //------------------
    public void cleanViewPagerState() {
        pagerAdapter.notifyDataSetChanged();
    }

    //------------------

    private void backToBeforePage() {//退出
        boolean isPopFragment = false;
        String currentTabTag = tabhost.getCurrentTabTag();
        if (currentTabTag.equals(tabsTitle[0])) {
            isPopFragment = ((BaseFragment) getSupportFragmentManager()
                    .findFragmentByTag(tabsTitle[0])).popFragment();
        } else if (currentTabTag.equals(tabsTitle[1])) {
            isPopFragment = ((BaseFragment) getSupportFragmentManager()
                    .findFragmentByTag(tabsTitle[1])).popFragment();
        } else if (currentTabTag.equals(tabsTitle[2])) {
            isPopFragment = ((BaseFragment) getSupportFragmentManager()
                    .findFragmentByTag(tabsTitle[2])).popFragment();
        }

        if (!isPopFragment) {
            this.finish(); // 關閉
        }
    }

    //------------------


    @Override
    public void onBackPressed() {
        backToBeforePage();
    }
}
