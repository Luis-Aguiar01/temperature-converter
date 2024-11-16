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
        val spinner = binding.spinnerTypeTemperature
        val spinner2 = binding.spinnerTargetTemperature

        spinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.temperature_units,
            android.R.layout.simple_spinner_item
        )
        spinner2.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.temperature_units,
            android.R.layout.simple_spinner_item
        )
    }
}