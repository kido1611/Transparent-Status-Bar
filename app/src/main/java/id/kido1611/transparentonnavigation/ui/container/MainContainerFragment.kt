package id.kido1611.transparentonnavigation.ui.container

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import id.kido1611.transparentonnavigation.R
import id.kido1611.transparentonnavigation.ui.center.CenterFragment
import id.kido1611.transparentonnavigation.ui.collapsing.CollapsingFragment
import id.kido1611.transparentonnavigation.ui.home.HomeFragment
import kotlinx.android.synthetic.main.main_container_fragment.*

class MainContainerFragment : Fragment() {

    private lateinit var viewModel: MainContainerViewModel

    private lateinit var fragmentPagerAdapter: FragmentVpAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_container_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainContainerViewModel::class.java)

        if (viewModel.fragmentCache.size == 0) {
            viewModel.fragmentCache[0] = HomeFragment.newInstance()
            viewModel.fragmentCache[1] = CollapsingFragment.newInstance()
            viewModel.fragmentCache[2] = CenterFragment.newInstance()
        }

        fragmentPagerAdapter = FragmentVpAdapter(childFragmentManager, viewModel.fragmentCache)
        vp.adapter = fragmentPagerAdapter
        vp.offscreenPageLimit = 3
        vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.selectedItemId = when (position) {
                    1 -> {
                        R.id.profileMenu
                    }
                    2 -> {
                        R.id.centerMenu
                    }
                    else -> {
                        R.id.homeMenu
                    }
                }
            }
        })
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeMenu -> {
                    vp.setCurrentItem(0, false)
                }
                R.id.profileMenu -> {
                    vp.setCurrentItem(1, false)
                }
                R.id.centerMenu -> {
                    vp.setCurrentItem(2, false)
                }
            }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(vp) { v, insets ->
            var consumed = false

            (v as ViewGroup).children.forEach {
                val childResult = ViewCompat.dispatchApplyWindowInsets(it, insets)
                if (childResult.isConsumed) {
                    consumed = true
                }
            }

            if (consumed) {
                insets.consumeSystemWindowInsets()
            } else {
                insets
            }
        }
        ViewCompat.requestApplyInsets(vp)
    }

}