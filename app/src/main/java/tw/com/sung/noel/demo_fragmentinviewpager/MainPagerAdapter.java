package tw.com.sung.noel.demo_fragmentinviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;

import tw.com.sung.noel.demo_fragmentinviewpager.one.container.OneContainer;
import tw.com.sung.noel.demo_fragmentinviewpager.three.container.ThreeContainer;
import tw.com.sung.noel.demo_fragmentinviewpager.two.container.TwoContainer;


/**
 * Created by vincent.chang on 2015/12/18.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_INDEX_TWO = 1;
    private static final int PAGE_INDEX_THREE = 2;

    private int[] pages;
    private String[] titles;
    //-------------------

    public MainPagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles = titles;
        pages = new int[3];
    }
    //-------------------

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            //Two
            case PAGE_INDEX_TWO:
                Log.e("PAGE_INDEX_FAVORITE", "PAGE_INDEX_FAVORITE");
                return new TwoContainer();

            //Three
            case PAGE_INDEX_THREE:
                Log.e("PAGE_INDEX_NEWS", "PAGE_INDEX_NEWS");
                return new ThreeContainer();

            //One
            default:
                Log.e("PAGE_INDEX_HOME", "PAGE_INDEX_HOME");
                return new OneContainer();

        }
    }
    //-------------------

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
    //-------------------

    @Override
    public int getCount() {
        return pages.length;
    }

    //-------------------
    public void setData(int[] pages) {
        this.pages = pages;
        notifyDataSetChanged();
    }
    //-------------------

    @Override
    public int getItemPosition(Object object) {
        // TODO Auto-generated method stub
        return PagerAdapter.POSITION_NONE;
    }
}
