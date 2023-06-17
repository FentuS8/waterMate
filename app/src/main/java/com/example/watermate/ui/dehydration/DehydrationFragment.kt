package com.example.watermate.ui.dehydration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ViewFlipper
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.watermate.R
import com.example.watermate.databinding.FragmentDehydrationInputBinding
import com.example.watermate.databinding.FragmentDehydrationMainBinding

class DehydrationFragment : Fragment() {

    private var _bindingInput: FragmentDehydrationInputBinding? = null
    private val bindingInput get() = _bindingInput!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dehydratationViewModel =
            ViewModelProvider(this).get(DehydrationViewModel::class.java)

        _bindingInput = FragmentDehydrationInputBinding.inflate(inflater, container, false)
        val root: View = bindingInput.root

        val seekbarAppearance = bindingInput.seekbarAppearance
        seekbarAppearance.labels = resources.getStringArray(R.array.labels_appearance)
        seekbarAppearance.max = 2

        val seekbarEyes = bindingInput.seekbarEyes
        seekbarEyes.labels = resources.getStringArray(R.array.labels_eyes)
        seekbarEyes.max = 2

        val seekbarMucous = bindingInput.seekbarMucous
        seekbarMucous.labels = resources.getStringArray(R.array.labels_mucous)
        seekbarMucous.max = 2

        val seekbarTears = bindingInput.seekbarTears
        seekbarTears.labels = resources.getStringArray(R.array.labels_tears)
        seekbarTears.max = 2

        val viewFlipper = root.findViewById<ViewFlipper>(R.id.dehydrationFlipper)

        val calc = root.findViewById<AppCompatButton>(R.id.calculate_dehydration)
        val back = root.findViewById<AppCompatButton>(R.id.back_to_main_dehydration)

        calc.setOnClickListener {
            viewFlipper.showNext()
        }

        back.setOnClickListener {
            viewFlipper.showPrevious()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingInput = null
    }
}