package com.example.watermate.ui.dehydration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.watermate.R
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

        val seekbarAppearance = binding.seekbarAppearance
        seekbarAppearance.labels = resources.getStringArray(R.array.labels_appearance)
        seekbarAppearance.values = arrayOf(0, 50, 100)

        val seekbarEyes = binding.seekbarEyes
        seekbarEyes.labels = resources.getStringArray(R.array.labels_eyes)
        seekbarEyes.values = arrayOf(0, 50, 100)

        val seekbarMucous = binding.seekbarMucous
        seekbarMucous.labels = resources.getStringArray(R.array.labels_mucous)
        seekbarMucous.values = arrayOf(0, 50, 100)

        val seekbarTears = binding.seekbarTears
        seekbarTears.labels = resources.getStringArray(R.array.labels_tears)
        seekbarTears.values = arrayOf(0, 50, 100)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}