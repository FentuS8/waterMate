package com.example.watermate.ui.dehydration_treatment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.watermate.R
import com.example.watermate.databinding.FragmentDehydrationTreatmentBinding
import com.example.watermate.models.DehydrationTreatment
import com.example.watermate.ui.dehydration.DehydrationViewModel

class DehydrationTreatmentFragment : Fragment() {

    private var _binding: FragmentDehydrationTreatmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDehydrationTreatmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val radioGroup = binding.selectDegree

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButtonFirst -> {
                    // Выбран пункт 1
                }
                R.id.radioButtonSecond -> {
                    // Выбран пункт 2
                }
                R.id.radioButtonThird -> {
                    // Выбран пункт 3
                }
            }
        }

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

        val dehydrationTreatmentMain = binding.fragmentDehydrationTreatmentMain
        val dehydrationTreatmentResult = binding.fragmentDehydrationTreatmentResult
        val calculateDehydrationTreatment = binding.dehydrationTreatmentCalculate
        val backDehydrationTreatment = binding.dehydrationTreatmentBack

        val viewModel = ViewModelProvider(this).get(DehydrationTreatmentViewModel::class.java)

        calculateDehydrationTreatment.setOnClickListener {
            val selectedDegree = when (radioGroup.checkedRadioButtonId) {
                R.id.radioButtonFirst -> 1
                R.id.radioButtonSecond -> 2
                R.id.radioButtonThird -> 3
                else -> 0 // значение по умолчанию
            }
            val selectedAge = ageEditText.text.toString().toIntOrNull() ?: 0
            val selectedWeight = weightEditText.text.toString().toIntOrNull() ?: 0

            val resultStr = viewModel.calculateDehydrationTreatment(selectedDegree, selectedAge, selectedWeight)
            binding.dehydrationTreatmentResultCard.text = resultStr
            dehydrationTreatmentMain.visibility = View.GONE
            dehydrationTreatmentResult.visibility = View.VISIBLE
        }

        backDehydrationTreatment.setOnClickListener {
            dehydrationTreatmentMain.visibility = View.VISIBLE
            dehydrationTreatmentResult.visibility = View.GONE
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