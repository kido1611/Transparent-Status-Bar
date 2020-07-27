package id.kido1611.transparentonnavigation.extension

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

private fun getStatusBarHeight(context: Context): Int {
    val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        context.resources.getDimensionPixelSize(resourceId)
    } else {
        0
    }
}

private fun getAppBarHeight(activity: Activity): Int {
    val displayMetrics = DisplayMetrics()
    activity.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
    return (displayMetrics.widthPixels / 16 * 9)
}

fun AppBarLayout.setRatioHeight(activity: Activity) {
    val layoutParams = CoordinatorLayout
        .LayoutParams(
            CoordinatorLayout.LayoutParams.MATCH_PARENT,
            getAppBarHeight(activity) + getStatusBarHeight(activity)
        )
    this.layoutParams = layoutParams
}