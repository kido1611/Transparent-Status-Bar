package id.kido1611.transparentonnavigation.ui.center

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.kido1611.transparentonnavigation.R
import kotlinx.android.synthetic.main.collapsing_fragment.*

class CenterFragment : Fragment() {

    companion object {
        fun newInstance() = CenterFragment()
    }

    private lateinit var viewModel: CenterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.center_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CenterViewModel::class.java)

        toolbar.requestApplyInsets()
    }

}