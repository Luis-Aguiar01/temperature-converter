package br.edu.ifsp.dmo.conversordetemperatura.model

class FahrenheitStrategy : TemperatureConverter {
    override fun converter(temperature: Double) = 1.8 * temperature + 32
    override fun getScale() = "ºF"
}