package id.kido1611.transparentonnavigation.ui.container

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentVpAdapter(
    fragmentManager: FragmentManager,
    private val fragmentList: LinkedHashMap<Int, Fragment>
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position] as Fragment
    }

    override fun getCount(): Int = fragmentList.size

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
        fragmentList.remove(position)
    }
}