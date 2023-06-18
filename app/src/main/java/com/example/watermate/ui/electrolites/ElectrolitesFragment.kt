package com.example.watermate.ui.electrolites

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.watermate.R
import com.example.watermate.databinding.FragmentElectrolitesBinding

class ElectrolitesFragment : Fragment() {

    private var _binding: FragmentElectrolitesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentElectrolitesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val radioGroup = binding.selectElement

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButtonCalcium -> {
                    // Выбран пункт 1
                }
                R.id.radioButtonPotassium -> {
                    // Выбран пункт 2
                }
                R.id.radioButtonMagnesium -> {
                    // Выбран пункт 3
                }
            }
        }

        val ageEditText = binding.ageEditText
        val minusButton = binding.minusButton
        val plusButton = binding.plusButton

        val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val ageKey = "age"

        var age = sharedPreferences.getInt(ageKey, 18)

        ageEditText.setText(age.toString())

        minusButton.setOnClickListener {
            if (age > 0) {
                age--
                ageEditText.setText(age.toString())
                saveAge(age)
            }
        }

        plusButton.setOnClickListener {
            age++
            ageEditText.setText(age.toString())
            saveAge(age)
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

        val electrolitesMain = binding.fragmentElectrolitesMain
        val electrolitesResult = binding.fragmentElectrolitesResult
        val calculateElectrolites = binding.electrolitesCalculate
        val backElectrolites = binding.electrolitesBack

        calculateElectrolites.setOnClickListener {
            electrolitesMain.visibility = View.GONE
            electrolitesResult.visibility = View.VISIBLE
        }

        backElectrolites.setOnClickListener {
            electrolitesMain.visibility = View.VISIBLE
            electrolitesResult.visibility = View.GONE
        }

        return root
    }

    private fun saveAge(age: Int) {
        val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("age", age)
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}