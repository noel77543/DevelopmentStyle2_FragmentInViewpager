package tw.com.sung.noel.demo_fragmentinviewpager.three;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import tw.com.sung.noel.demo_fragmentinviewpager.BaseFragment;
import tw.com.sung.noel.demo_fragmentinviewpager.MainActivity;
import tw.com.sung.noel.demo_fragmentinviewpager.R;

/**
 * Created by noel on 2017/9/11.
 */

public class ThreeFragment extends BaseFragment {
    private View view;
    private MainActivity mainActivity;

    //-------------------------
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
        }
    }
    //-------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_three, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }

        ButterKnife.bind(this, view);
        return view;
    }
}
