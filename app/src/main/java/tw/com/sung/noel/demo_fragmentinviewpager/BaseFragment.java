package tw.com.sung.noel.demo_fragmentinviewpager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;



/**
 * The Base for all Fragments.
 */
public class BaseFragment extends Fragment {

    public MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            activity = (MainActivity) context;
        }
    }

    /**
     * 第一層 箱子 container用
     */
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(android.R.id.tabcontent, fragment);
        transaction.commit();
        getChildFragmentManager().executePendingTransactions();
    }

    //-------------

    /**
     * 第二層以後用
     * 無bundle
     */
    public void replaceFragment2(Fragment fragment, boolean addToBackStack) {

        FragmentTransaction transaction = getParentFragment().getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(android.R.id.tabcontent, fragment);
        transaction.commit();
        getParentFragment().getChildFragmentManager().executePendingTransactions();
    }

    //-------------

    /**
     * 第二層以後用
     * 有bundle
     */
    public void replaceFragment3(Fragment fragment, boolean addToBackStack, Bundle bundle) {
        fragment.setArguments(bundle);

        FragmentTransaction transaction = getParentFragment().getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(android.R.id.tabcontent, fragment);
        transaction.commit();
        getParentFragment().getChildFragmentManager().executePendingTransactions();
    }
    //-------------

    public boolean popFragment() {
        boolean isPop = false;
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            isPop = true;
            getChildFragmentManager().popBackStack();
        }
        return isPop;
    }

    public void onBack() {
        activity.onBackPressed();
    }


}
