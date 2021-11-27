package net.svichch.geekbrains.android.pressureandpulse.ui.listPulse

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.svichch.geekbrains.android.pressureandpulse.databinding.ItemFragmentPulseBinding

class PulseViewAdapter(
) : RecyclerView.Adapter<PulseViewAdapter.ViewHolder>() {

    var testSize = 15
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemFragmentPulseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.time.text = "8:00"
        holder.upperPressure.text = "150"
        holder.lowerPressure.text = "75"
        holder.pulse.text = "70"
    }

    override fun getItemCount(): Int = testSize

    inner class ViewHolder(binding: ItemFragmentPulseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val time: TextView = binding.time
        val upperPressure: TextView = binding.upperPressure
        val lowerPressure: TextView = binding.lowerPressure
        val pulse: TextView = binding.pulse
    }

}