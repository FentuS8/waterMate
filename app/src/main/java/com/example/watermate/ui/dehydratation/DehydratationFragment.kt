package com.example.watermate.ui.dehydratation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.watermate.databinding.FragmentDehydratationBinding

class DehydratationFragment : Fragment() {

    private var _binding: FragmentDehydratationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dehydratationViewModel =
            ViewModelProvider(this).get(DehydratationViewModel::class.java)

        _binding = FragmentDehydratationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDehydratation
        dehydratationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}