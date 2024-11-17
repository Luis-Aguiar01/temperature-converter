package br.edu.ifsp.dmo.conversordetemperatura.model

object KelvinStrategy : TemperatureConverter {
    override fun converter(temperature: Double) = temperature
    override fun getScale() = "K"
}