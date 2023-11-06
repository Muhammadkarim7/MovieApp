package com.example.movieapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Models.User
import com.example.movieapp.databinding.ItemRvBinding


class Adapter(val list: ArrayList<User>, val rvAction: RvAction): RecyclerView.Adapter<Adapter.Vh>(){
    inner class Vh(val itemRvBinding: ItemRvBinding): RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(user: User, position:Int){
            itemRvBinding.txt1.text = user.name
            itemRvBinding.txt2.text = user.about
            itemRvBinding.txtDate.text = user.date

            itemRvBinding.root.setOnClickListener {
                rvAction.about(user, position)
            }

            itemRvBinding.btn1.setOnClickListener {
                rvAction.edt(position)
            }
            itemRvBinding.btn2.setOnClickListener {
                rvAction.delete(user, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    interface RvAction{
        fun delete(user: User, position: Int)
        fun edt(position: Int)
        fun about(user: User, position: Int)
    }
}