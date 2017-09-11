package tw.com.sung.noel.demo_fragmentinviewpager.two.container;


import tw.com.sung.noel.demo_fragmentinviewpager.ContainerFragment;
import tw.com.sung.noel.demo_fragmentinviewpager.two.TwoFragment;

/**
 * Created by noel on 2017/4/25.
 */

public class TwoContainer extends ContainerFragment {
    // ---------------------------------------------------
    @Override
    public void init() {
        replaceFragment(new TwoFragment(), false);
    }
    // ---------------------------------------------------
}
