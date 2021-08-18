package com.example.swupreme.util

import android.app.Activity
import android.app.Application
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.swupreme.R
import com.example.swupreme.application.BaseApplication
import com.example.swupreme.DiagnosisModel
import com.bumptech.glide.Glide


object Util {

    fun progressOnInFragment(fragment: Fragment){
        BaseApplication.instance?.progressOnInFragment(fragment)
    }
    fun progressOffInFragment(){
        BaseApplication.instance?.progressOffInFragment()
    }

    fun progressOn(activity: FragmentActivity){
        BaseApplication.instance?.progressOn(activity)
    }
    fun progressOff(){
        BaseApplication.instance?.progressOff()
    }
}