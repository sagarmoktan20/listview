package com.example.listviewpro

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class Myadapter(val context: Activity,val userarraylist: ArrayList<user>) : ArrayAdapter<user>(context,R.layout.each_item,userarraylist) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater= LayoutInflater.from(context)
        val view= inflater.inflate(R.layout.each_item,null)

        val name=view.findViewById<TextView>(R.id.tvnam)
        val lastmsg=view.findViewById<TextView>(R.id.tvmsg)
        val time = view.findViewById<TextView>(R.id.tvtime)
        val img= view.findViewById<CircleImageView>(R.id.profile_image)

        name.text=userarraylist[position].name
        lastmsg.text=userarraylist[position].lastmsg
        time.text=userarraylist[position].lastmsgtime
        img.setImageResource(userarraylist[position].imgid)

        return view
    }

}
