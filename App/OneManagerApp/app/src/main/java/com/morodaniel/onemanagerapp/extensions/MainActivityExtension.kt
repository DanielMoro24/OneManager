package com.morodaniel.onemanagerapp.extensions

import androidx.fragment.app.Fragment
import com.morodaniel.onemanagerapp.MainActivity

fun Fragment.mainActivity(): MainActivity {
    return activity as MainActivity
}