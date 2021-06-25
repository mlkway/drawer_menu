package com.raywenderlich.drawwaranddelay.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.drawwaranddelay.NavData
import com.raywenderlich.drawwaranddelay.R
import com.raywenderlich.drawwaranddelay.databinding.DrawItemBinding



typealias ImgClick = (position:Int) -> Unit
class DrawerAdapter(private val data: List<NavData>):RecyclerView.Adapter<DrawerAdapter.ViewHolder>() {

     lateinit var imgClick: ImgClick

    var indicator = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawerAdapter.ViewHolder {
        return ViewHolder(DrawItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DrawerAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()=data.size

    inner class ViewHolder(private val binding: DrawItemBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{

        private lateinit var currentData: NavData

        fun bind(){

            currentData = data[adapterPosition]
            binding.navImg.setImageResource(currentData.icon)
            binding.navText.text = currentData.name
            binding.navImg.setOnClickListener(this)
            if (indicator == adapterPosition){
                binding.root.setBackgroundResource(R.color.teal_200)
            }else{
                binding.root.setBackgroundResource(R.color.white)
            }
        }

        override fun onClick(v: View?) {
                indicator = adapterPosition
            imgClick(adapterPosition)
            notifyDataSetChanged()

        }
    }

}