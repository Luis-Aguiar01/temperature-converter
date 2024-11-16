package br.edu.ifsp.dmo.conversordetemperatura

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.conversordetemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeSpinners()
    }

    private fun initializeSpinners() {
        val spinnerInitialTemperature = binding.spinnerTypeTemperature
        val spinnerTargetTemperature = binding.spinnerTargetTemperature
        val dataset: Array<String> = arrayOf("Kelvin", "Celsius", "Fahrenheit")

        spinnerInitialTemperature.adapter = SpinnerItemAdapter(this, dataset)
        spinnerTargetTemperature.adapter = SpinnerItemAdapter(this, dataset)
    }
}