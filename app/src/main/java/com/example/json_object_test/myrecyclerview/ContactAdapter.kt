package com.example.json_object_test.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.json_object_test.R
import java.util.ArrayList

class ContactAdapter (private val myList: List<ContactInfo>) : RecyclerView.Adapter<ContactAdapter.myViewHolder>(){

     class myViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvID: TextView = itemView.findViewById(R.id.tvID)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_view, parent, false )

        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentContact = myList[position]

        holder.tvID.text = currentContact.id
        holder.tvName.text = currentContact.name
        holder.tvEmail.text = currentContact.email

    }

    override fun getItemCount(): Int {
        return myList.size
    }


}