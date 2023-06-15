package com.example.watermate.ui.electrolites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.watermate.databinding.FragmentElectrolitesBinding

class ElectrolitesFragment : Fragment() {

    private var _binding: FragmentElectrolitesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val electrolitesViewModel =
            ViewModelProvider(this).get(ElectrolitesViewModel::class.java)

        _binding = FragmentElectrolitesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textElectrolites
        electrolitesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}