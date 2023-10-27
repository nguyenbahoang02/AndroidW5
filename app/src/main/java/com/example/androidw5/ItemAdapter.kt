package com.example.androidw5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView

class ItemAdapter(val items: ArrayList<ItemModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var itemView: View
        var viewHolder: ViewHolder
        if (p1 == null) {
            itemView = LayoutInflater.from(p2?.context).inflate(R.layout.item, p2, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = p1
            viewHolder = itemView.tag as ViewHolder
        }

        viewHolder.mail.text = items[p0].mail
        viewHolder.title.text = items[p0].title
        viewHolder.avatar.text = items[p0].mail.first().uppercase()
        viewHolder.time.text = items[p0].time
        viewHolder.content.text = items[p0].content
        viewHolder.checkBox.isChecked = items[p0].selected

        viewHolder.title.ellipsize = android.text.TextUtils.TruncateAt.END
        viewHolder.content.ellipsize = android.text.TextUtils.TruncateAt.END

        if (items[p0].selected) {
            viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_on)
        } else viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_off)

        viewHolder.checkBox.setOnClickListener {
            items[p0].selected = !items[p0].selected
            if (items[p0].selected) {
                viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_on)
            } else viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_off)
            notifyDataSetChanged()
        }

        return itemView
    }

    class ViewHolder(itemView: View) {
        var mail: TextView
        var title: TextView
        var content: TextView
        var avatar: TextView
        var time: TextView
        var checkBox: CheckBox

        init {
            mail = itemView.findViewById(R.id.mail)
            title = itemView.findViewById(R.id.title)
            avatar = itemView.findViewById(R.id.textView)
            time = itemView.findViewById(R.id.time)
            content = itemView.findViewById(R.id.content)
            checkBox = itemView.findViewById(R.id.checkBox)
        }
    }
}