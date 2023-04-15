package com.selcannarin.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.selcannarin.navigationcomponent.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonStart.setOnClickListener{
            var person = Person(1,"Selcan")
            val direct=HomePageFragmentDirections.actionHomePageFragmentToGamePageFragment(person)
            Navigation.findNavController(it).navigate(direct)
        }
        return view
    }
}