package com.lloydsbankinggroupcc.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lloydsbankinggroupcc.data.datamodels.animals.Animal
import com.lloydsbankinggroupcc.databinding.ItemPetBinding
import com.lloydsbankinggroupcc.ui.PetsClickListener
import com.lloydsbankinggroupcc.util.loadImage

class PetsHomeListAdapter(private val listener: PetsClickListener) :
    ListAdapter<Animal, PetsHomeListAdapter.PetsListAdapterViewHolder>(PetsDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PetsListAdapterViewHolder(
        ItemPetBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
    )


    override fun onBindViewHolder(holder: PetsListAdapterViewHolder, position: Int) {
        val binding by holder::binding
        val item = getItem(position)
        binding.apply {
            age.text = item.age
            petTitle.text = item.name
            description.text = item.description
            gender.text = item.gender
            if (!item.photos.isNullOrEmpty()) {
                loadImage(petImageview, item?.photos[0].medium)
            }
        }

        binding.clickableOverlay.setOnClickListener {
            listener.onPetItemClick(item)
        }

    }


    inner class PetsListAdapterViewHolder(val binding: ItemPetBinding) :
        RecyclerView.ViewHolder(binding.root)

    object PetsDiffUtil : DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }
    }

}