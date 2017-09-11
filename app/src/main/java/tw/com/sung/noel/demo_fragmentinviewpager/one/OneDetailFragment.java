package tw.com.sung.noel.demo_fragmentinviewpager.one;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.com.sung.noel.demo_fragmentinviewpager.BaseFragment;
import tw.com.sung.noel.demo_fragmentinviewpager.MainActivity;
import tw.com.sung.noel.demo_fragmentinviewpager.R;

/**
 * Created by noel on 2017/9/11.
 */

public class OneDetailFragment extends BaseFragment {

    @BindView(R.id.button)
    Button button;

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
            view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_one_detail, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        replaceFragment2(new OneMostDetailFragment(), true);

    }
}
