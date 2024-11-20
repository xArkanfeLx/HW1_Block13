package com.example.mytrainingsession

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mytrainingsession.Exercise

class ListAdapter(context: Context, exerciseList: MutableList<Exercise>) :
    ArrayAdapter<Exercise>(context, R.layout.exersice_list_item, exerciseList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val exercise = getItem(position)
        if (view == null) view =
            LayoutInflater.from(context).inflate(R.layout.exersice_list_item, parent, false)

        val imgIV = view?.findViewById<ImageView>(R.id.imgIV)
        val nameTV = view?.findViewById<TextView>(R.id.nameTV)

        exercise?.gifImage?.let { imgIV?.setImageResource(it) }
        nameTV?.text = exercise?.name

        return view!!
    }
}