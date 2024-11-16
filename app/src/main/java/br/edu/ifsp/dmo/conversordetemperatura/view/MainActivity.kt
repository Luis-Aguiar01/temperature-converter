package br.edu.ifsp.dmo.conversordetemperatura.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.conversordetemperatura.adapters.SpinnerItemAdapter
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
        val spinnerInitialTemperature = binding.spinnerInitialTemperature
        val spinnerTargetTemperature = binding.spinnerTargetTemperature
        val dataset: Array<String> = arrayOf("Celsius", "Kelvin", "Fahrenheit")

        spinnerInitialTemperature.adapter = SpinnerItemAdapter(this, dataset)
        spinnerTargetTemperature.adapter = SpinnerItemAdapter(this, dataset)
    }
}