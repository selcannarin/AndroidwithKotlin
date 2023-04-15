package com.selcannarin.navigationcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.selcannarin.navigationcomponent.databinding.FragmentGamePageBinding
import com.selcannarin.navigationcomponent.databinding.FragmentHomePageBinding

class GamePageFragment : Fragment() {

    private var _binding: FragmentGamePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGamePageBinding.inflate(inflater, container, false)
        val view = binding.root

        val bundle:GamePageFragmentArgs by navArgs()
        val input_person = bundle.person

        Log.e("Person no: ",input_person.person_no.toString())
        Log.e("Person name: ",input_person.person_name)

        binding.buttonFinish.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_gamePageFragment_to_resultPageFragment)
        }
        return view
    }
}