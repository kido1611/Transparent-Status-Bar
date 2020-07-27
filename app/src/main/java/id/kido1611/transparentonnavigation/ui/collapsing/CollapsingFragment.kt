package id.kido1611.transparentonnavigation.ui.collapsing

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.kido1611.transparentonnavigation.R
import id.kido1611.transparentonnavigation.extension.setRatioHeight
import kotlinx.android.synthetic.main.collapsing_fragment.*

class CollapsingFragment : Fragment() {

    companion object {
        fun newInstance() =
            CollapsingFragment()
    }

    private lateinit var viewModel: CollapsingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.collapsing_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollapsingViewModel::class.java)

        if (viewModel.time == null) {
            viewModel.time = System.currentTimeMillis()
        }
        Log.e(CollapsingFragment::class.simpleName, "Time: ${viewModel.time}")

        appbar.setRatioHeight(requireActivity())
    }
}