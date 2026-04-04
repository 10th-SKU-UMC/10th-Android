package com.example.pract

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(private val profileList:ArrayList<Profiles>):RecyclerView.Adapter <ProfileAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProfileAdapter.CustomViewHolder {
        val view= LayoutInflater.from(p0.context).inflate(R.layout.list_item, p0, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(p0: ProfileAdapter.CustomViewHolder, p1: Int) {
        p0.gender.setImageResource(profileList.get(p1).gender)
        p0.name.text=profileList.get(p1).name
        p0.age.text=profileList.get(p1).age.toString()
        p0.job.text=profileList.get(p1).job
    }

    override fun getItemCount(): Int {
    return profileList.size
    }

    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val gender=itemView.findViewById<ImageView>(R.id.rv_profile)
    val name=itemView.findViewById<TextView>(R.id.tv_name)
    val age=itemView.findViewById<TextView>(R.id.tv_age)
    val job=itemView.findViewById<TextView>(R.id.tv_job)
    }


}