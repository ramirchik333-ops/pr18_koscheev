package com.example.weatherdiary

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bignerdranch.android.weatherdiary.R


fun FragmentActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, fragment)
        .addToBackStack(null)
        .commit()
}


fun Fragment.replaceFragment(fragment: Fragment) {
    parentFragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, fragment)
        .addToBackStack(null)
        .commit()
}


fun Fragment.clearBackStackAndReplace(fragment: Fragment) {
    parentFragmentManager.popBackStack(null, android.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
    parentFragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, fragment)
        .commit()
}