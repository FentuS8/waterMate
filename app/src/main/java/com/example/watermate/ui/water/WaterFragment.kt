package com.example.watermate.ui.water

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.watermate.databinding.FragmentWaterBinding
import com.example.watermate.ui.electrolites.ElectrolitesViewModel

class WaterFragment : Fragment() {

    private var _binding: FragmentWaterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWaterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val ageEditText = binding.ageEditText
        val minusAgeButton = binding.minusAgeButton
        val plusAgeButton = binding.plusAgeButton

        val weightEditText = binding.weightEditText
        val minusWeightButton = binding.minusWeightButton
        val plusWeightButton = binding.plusWeightButton

        val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val ageKey = "age"
        val weightKey = "weight"

        var age = sharedPreferences.getInt(ageKey, 18)
        var weight = sharedPreferences.getInt(weightKey, 60)

        ageEditText.setText(age.toString())
        weightEditText.setText(weight.toString())

        minusAgeButton.setOnClickListener {
            if (age > 0) {
                age--
                ageEditText.setText(age.toString())
                saveAge(age)
            }
        }

        minusWeightButton.setOnClickListener {
            if (weight > 0) {
                weight--
                weightEditText.setText(weight.toString())
                saveWeight(weight)
            }
        }

        plusAgeButton.setOnClickListener {
            age++
            ageEditText.setText(age.toString())
            saveAge(age)
        }

        plusWeightButton.setOnClickListener {
            weight++
            weightEditText.setText(weight.toString())
            saveWeight(weight)
        }

        ageEditText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }

            override fun afterTextChanged(s: Editable?) {
                val inputAge = s.toString().toIntOrNull()
                if (inputAge != null) {
                    age = inputAge
                    saveAge(age)
                }
            }
        })

        weightEditText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }

            override fun afterTextChanged(s: Editable?) {
                val inputWeight = s.toString().toIntOrNull()
                if (inputWeight != null) {
                    weight = inputWeight
                    saveWeight(weight)
                }
            }
        })

        val waterMain = binding.fragmentWaterMain
        val waterResult = binding.fragmentWaterResult
        val calculateWater = binding.waterCalculate
        val backWater = binding.waterBack

        val viewModel = ViewModelProvider(this).get(WaterViewModel::class.java)

        calculateWater.setOnClickListener {
            val resultStr = viewModel.calculateWaterBalance(age, weight)
            binding.waterResultCard.text = resultStr
            waterMain.visibility = View.GONE
            waterResult.visibility = View.VISIBLE
        }

        backWater.setOnClickListener {
            waterMain.visibility = View.VISIBLE
            waterResult.visibility = View.GONE
        }


        return root
    }

    private fun saveAge(age: Int) {
        val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("age", age)
        editor.apply()
    }

    private fun saveWeight(weight: Int) {
        val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("weight", weight)
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}