package br.edu.ifsp.dmo.conversordetemperatura.model

object FahrenheitStrategy : TemperatureConverter {
    override fun converter(temperature: Double) = (temperature - 273.15) * 1.8 + 32
    override fun getScale() = "ºF"
}