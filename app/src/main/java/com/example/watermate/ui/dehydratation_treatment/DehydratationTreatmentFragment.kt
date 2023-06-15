package com.example.watermate.ui.dehydratation_treatment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.watermate.R
import com.example.watermate.databinding.FragmentDehydratationTreatmentBinding
import com.example.watermate.ui.dehydratation_treatment.DehydratationTreatmentViewModel

class DehydratationTreatmentFragment : Fragment() {

    private var _binding: FragmentDehydratationTreatmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dehydratationTreatmentViewModel =
            ViewModelProvider(this).get(DehydratationTreatmentViewModel::class.java)

        _binding = FragmentDehydratationTreatmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDehydratationTreatment
        dehydratationTreatmentViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}