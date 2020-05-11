package com.learningmanagement.parent_account.myspace.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.learningmanagement.R

class CustomTypeLevelAdapter(val context: Context, var typeOfLevel: ArrayList<String>) :
    BaseAdapter() {
    var itemItemList = ArrayList<String>()

    init {
        itemItemList = typeOfLevel
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val mInflater: LayoutInflater = LayoutInflater.from(context)

        val view: View
        val vh: ItemRowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.level_spinner_items, parent, false)
            vh = ItemRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemRowHolder
        }
        vh.tvName.text = itemItemList.get(position)
        return view
    }

    private class ItemRowHolder(itemView: View) {
        var tvName: TextView
        init {
            this.tvName = itemView.findViewById(R.id.tvName)
        }
    }

    override fun getItem(position: Int): Any {
        return itemItemList
    }

    override fun getItemId(position: Int): Long {
       return 0
    }

    override fun getCount(): Int {
        return itemItemList.size
    }
}