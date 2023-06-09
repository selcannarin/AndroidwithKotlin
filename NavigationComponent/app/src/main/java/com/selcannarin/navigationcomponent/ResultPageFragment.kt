package com.selcannarin.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selcannarin.navigationcomponent.databinding.FragmentResultPageBinding

class ResultPageFragment : Fragment() {

    private var _binding: FragmentResultPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentResultPageBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
}