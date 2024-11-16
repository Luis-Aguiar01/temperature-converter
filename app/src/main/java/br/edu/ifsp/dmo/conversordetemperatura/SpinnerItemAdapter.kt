package br.edu.ifsp.dmo.conversordetemperatura

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SpinnerItemAdapter(context: Context, dataset: Array<String>):
    ArrayAdapter<String>(context, R.layout.temperature_unit_spinner_item, dataset) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.temperature_unit_spinner_item, null)
        }
        val temperatureUnit: String? = getItem(position)

        if (itemView != null && temperatureUnit != null) {
            itemView.findViewById<TextView>(R.id.spinner_text).text = temperatureUnit
        }

        return itemView!!
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }
}