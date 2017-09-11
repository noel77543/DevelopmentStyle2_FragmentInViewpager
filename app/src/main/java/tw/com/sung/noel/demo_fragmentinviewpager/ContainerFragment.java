package tw.com.sung.noel.demo_fragmentinviewpager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by noel on 2017/4/25.
 */

public abstract class ContainerFragment extends BaseFragment {

    // ---------------------------------------------------
    private boolean mIsViewInit;

    // ---------------------------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.module_inner_container, null);
    }

    // ---------------------------------------------------
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!mIsViewInit) {
            mIsViewInit = true;
            init();
        }
    }

// ---------------------------------------------------
public abstract void init();

}