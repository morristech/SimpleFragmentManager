package com.bajicdusko.kotlinfragmentmanager

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by Dusko Bajic on 14.06.17.
 * GitHub @bajicdusko
 */
abstract class SFMFragment<F : FragmentChannel> : Fragment(), IFragment {

    protected var fragmentChannel: F? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context != null && context is FragmentChannel){
            fragmentChannel = context as F?
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(parentFragment != null && parentFragment is FragmentChannel){
            fragmentChannel = parentFragment as F?
        }
    }
}