package tw.com.sung.noel.demo_fragmentinviewpager.one.container;

import tw.com.sung.noel.demo_fragmentinviewpager.ContainerFragment;
import tw.com.sung.noel.demo_fragmentinviewpager.one.OneFragment;


/**
 * Created by noel on 2017/4/25.
 */

public class OneContainer extends ContainerFragment {
    // ---------------------------------------------------
    @Override
    public void init() {
        replaceFragment(new OneFragment(), false);
    }
    // ---------------------------------------------------
}
