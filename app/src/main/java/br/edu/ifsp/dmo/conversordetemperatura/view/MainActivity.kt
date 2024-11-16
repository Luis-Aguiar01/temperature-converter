package br.edu.ifsp.dmo.conversordetemperatura.view

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.conversordetemperatura.adapters.SpinnerItemAdapter
import br.edu.ifsp.dmo.conversordetemperatura.databinding.ActivityMainBinding
import br.edu.ifsp.dmo.conversordetemperatura.model.TemperatureConverter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var strategy: TemperatureConverter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeSpinners()
    }

    private fun initializeSpinners() {
        val spinnerInitialTemperature = binding.spinnerInitialTemperature
        val spinnerTargetTemperature = binding.spinnerTargetTemperature
        val dataset: Array<String> = arrayOf("Celsius", "Kelvin", "Fahrenheit")

        spinnerInitialTemperature.adapter = SpinnerItemAdapter(this, dataset)
        spinnerTargetTemperature.adapter = SpinnerItemAdapter(this, dataset)
    }

    private fun setOnClickListener() {
        binding.button.setOnClickListener {
            
        }
    }

    private fun readTemperature() = try {
        binding.inputTemperature.toString().toDouble()
    } catch (e: NumberFormatException) {
        throw NumberFormatException("Conversion Error.")
    }

    private fun readSpinnerValue(spinner: Spinner) = spinner.selectedItem.toString()


}