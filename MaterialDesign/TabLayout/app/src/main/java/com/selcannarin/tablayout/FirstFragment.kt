package com.selcannarin.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.selcannarin.tablayout.databinding.FirstFragmentLayoutBinding

class FirstFragment : Fragment() {
    private var _binding: FirstFragmentLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FirstFragmentLayoutBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}