package com.pdt.blockchainid.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.pdt.blockchainid.R
import com.pdt.blockchainid.databinding.LayoutListInfoBinding
import com.pdt.blockchainid.model.ListInfoItem

class CardAdapter(
    context: Context

    ):RecyclerView.Adapter<CardAdapter.CardAdapterHolders>() {
    private var mListCard: ArrayList<ListInfoItem> = arrayListOf()

    private var mContext = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapterHolders {
        val binding = LayoutListInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardAdapterHolders(binding)
    }

    override fun onBindViewHolder(holder: CardAdapterHolders, position: Int) {
        val currentCard = mListCard[position]
        val id = currentCard.id
        val name = currentCard.name
        val sex = currentCard.sex
        val address = currentCard.add



        holder.tvID.text = id.toString()
        holder.tvName.text = name
        holder.tvSex.text = sex
        holder.tvAddress.text = address
        holder.tvName.setOnClickListener{

            Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount(): Int = mListCard.size

    inner class CardAdapterHolders(binding: LayoutListInfoBinding):RecyclerView.ViewHolder(binding.root){
        val tvID:TextView = binding.inputID
        val tvName:TextView = binding.inputName
        val tvSex:TextView = binding.inputSex
        val tvAddress:TextView = binding.inputAddress
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setListCard(listPhoto: ArrayList<ListInfoItem>) {
        this.mListCard = listPhoto
        notifyDataSetChanged()
    }

}

