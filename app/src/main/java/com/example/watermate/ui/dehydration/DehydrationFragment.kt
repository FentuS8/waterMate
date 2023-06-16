package com.example.watermate.ui.dehydration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.watermate.databinding.FragmentDehydrationBinding

class DehydrationFragment : Fragment() {

    private var _binding: FragmentDehydrationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dehydratationViewModel =
            ViewModelProvider(this).get(DehydrationViewModel::class.java)

        _binding = FragmentDehydrationBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}