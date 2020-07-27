package id.kido1611.transparentonnavigation.ui.container

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

class MainContainerViewModel : ViewModel() {

    val fragmentCache = LinkedHashMap<Int, Fragment>()

}