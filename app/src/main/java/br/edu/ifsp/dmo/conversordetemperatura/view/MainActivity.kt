package br.edu.ifsp.dmo.conversordetemperatura.view

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.conversordetemperatura.adapters.SpinnerItemAdapter
import br.edu.ifsp.dmo.conversordetemperatura.databinding.ActivityMainBinding
import br.edu.ifsp.dmo.conversordetemperatura.model.CelsiusStrategy
import br.edu.ifsp.dmo.conversordetemperatura.model.FahrenheitStrategy
import br.edu.ifsp.dmo.conversordetemperatura.model.KelvinStrategy
import br.edu.ifsp.dmo.conversordetemperatura.model.TemperatureConverter
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var strategy: TemperatureConverter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeSpinners()
        setOnClickListener()
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
            handleConversion()
        }
    }

    private fun handleConversion() {
        val initialScale = readSpinnerValue(binding.spinnerInitialTemperature)
        val targetScale = readSpinnerValue(binding.spinnerTargetTemperature)
        val temperatureK = getTemperatureInKelvin()
        val result = binding.temperatureResult

        when (targetScale.lowercase()) {
            "celsius" -> strategy = CelsiusStrategy()
            "fahrenheit" -> strategy = FahrenheitStrategy()
            "kelvin" -> strategy = KelvinStrategy()
        }

        val convertedTemperature = strategy.converter(temperatureK)
        result.text = "${convertedTemperature}${strategy.getScale()}"
    }

    private fun readTemperature() = try {
        binding.inputTemperature.text.toString().toDouble()
    } catch (e: NumberFormatException) {
        throw NumberFormatException("Conversion Error.")
    }

    private fun readSpinnerValue(spinner: Spinner) = spinner.selectedItem.toString()

    private fun getTemperatureInKelvin(): Double {
        val initialScale = readSpinnerValue(binding.spinnerInitialTemperature)
        val temperature = readTemperature()

        return when (initialScale.lowercase()) {
            "celsius" -> temperature + 273.15
            "fahrenheit" -> (temperature - 32) * 5 / 9 + 273.15
            "kelvin" -> temperature
            else -> throw IllegalArgumentException("Invalid Scale.")
        }
    }
}