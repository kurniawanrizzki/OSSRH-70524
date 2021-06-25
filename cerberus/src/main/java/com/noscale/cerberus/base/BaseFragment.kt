package com.noscale.cerberus.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.noscale.cerberus.R

/**
 * This fragment class is used as boiler plate;
 * Created by kurniawanrizzki on 11/06/21.
 */
open class BaseFragment: Fragment() {

    open var mLayoutResource: Int = R.layout.fragment_base

    var mListener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(mLayoutResource, container, false)

    override fun onAttach(context: Context) {
        if (context is OnFragmentInteractionListener) mListener = context
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        mListener?.onInteract()
    }

    interface OnFragmentInteractionListener {
        fun onInteract ()
    }
}