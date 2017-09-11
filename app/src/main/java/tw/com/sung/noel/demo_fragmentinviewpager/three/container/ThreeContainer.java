package tw.com.sung.noel.demo_fragmentinviewpager.three.container;


import tw.com.sung.noel.demo_fragmentinviewpager.ContainerFragment;
import tw.com.sung.noel.demo_fragmentinviewpager.three.ThreeFragment;

/**
 * Created by noel on 2017/4/25.
 */

public class ThreeContainer extends ContainerFragment {
    // ---------------------------------------------------
    @Override
    public void init() {
        replaceFragment(new ThreeFragment(), false);
    }
    // ---------------------------------------------------
}
