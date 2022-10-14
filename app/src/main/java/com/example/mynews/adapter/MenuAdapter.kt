package com.example.mynews.adapter

import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.data.Category
import com.example.mynews.R


class MenuAdapter(private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.card_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drawables = holder.itemView.context.resources.obtainTypedArray(R.array.menuDrawable)
        val imageId = drawables.getResourceId(position, -1)
        val colors: TypedArray =
            holder.itemView.context.resources.obtainTypedArray(R.array.colorsDrawable)
        val color = colors.getColor(position, 0)
        holder.bind(Category.values()[position].getCategory(), imageId, color, position)
    }

    override fun getItemCount(): Int {
        return Category.values().size
    }

    override fun getItemViewType(position: Int): Int {

        return super.getItemViewType(position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.cardName)
        val image = view.findViewById<ImageView>(R.id.imageView)
        val cardView = view.findViewById<CardView>(R.id.cardHeadName)
        val cardSmallImage = view.findViewById<ImageView>(R.id.imageView)
        val rootElement = view.findViewById<CardView>(R.id.cardHeadName)

        fun bind(text: String, @DrawableRes imageId: Int, color: Int, position: Int) {
            name.text = text
            image.setImageDrawable(itemView.context.getDrawable(imageId))
            cardView.setCardBackgroundColor(color)
            cardSmallImage.setColorFilter(color)
            rootElement.setOnClickListener {
                onClickListener.onClick(position = position)
            }
        }
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }
}