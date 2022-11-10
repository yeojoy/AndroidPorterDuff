package me.yeojoy.porterduff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class GridAdapter(
    private val porterDuffs: Array<MyPorterDuff>
) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val porterDuff = porterDuffs[position]
        holder.customView.porterDuffMode = porterDuff.porterDuffMode
        holder.textView.text = porterDuff.title
    }

    override fun getItemCount() = porterDuffs.size


    class GridViewHolder(itemView: View): ViewHolder(itemView) {
        val customView: CustomView = itemView.findViewById(R.id.custom_view)
        val textView: TextView = itemView.findViewById(R.id.text_view_name)
    }
}