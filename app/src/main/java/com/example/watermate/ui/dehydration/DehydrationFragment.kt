package com.example.watermate.ui.dehydration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.watermate.R
import com.example.watermate.databinding.FragmentDehydrationBinding

class DehydrationFragment : Fragment() {

    private var _binding: FragmentDehydrationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDehydrationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val seekbarAppearance = binding.seekbarAppearance
        seekbarAppearance.labels = resources.getStringArray(R.array.labels_appearance)
        seekbarAppearance.max = 2

        val seekbarEyes = binding.seekbarEyes
        seekbarEyes.labels = resources.getStringArray(R.array.labels_eyes)
        seekbarEyes.max = 2

        val seekbarMucous = binding.seekbarMucous
        seekbarMucous.labels = resources.getStringArray(R.array.labels_mucous)
        seekbarMucous.max = 2

        val seekbarTears = binding.seekbarTears
        seekbarTears.labels = resources.getStringArray(R.array.labels_tears)
        seekbarTears.max = 2

        val dehydrationMain = binding.fragmentDehydrationMain
        val dehydrationResult = binding.fragmentDehydrationResult
        val calculateDehydration = binding.dehydrationCalculate
        val backDehydration = binding.dehydrationBack

        calculateDehydration.setOnClickListener {
            dehydrationMain.visibility = View.GONE
            dehydrationResult.visibility = View.VISIBLE
        }

        backDehydration.setOnClickListener {
            dehydrationMain.visibility = View.VISIBLE
            dehydrationResult.visibility = View.GONE
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}