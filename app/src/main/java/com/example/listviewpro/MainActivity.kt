package com.example.listviewpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userarraylist:ArrayList<user>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val name= arrayOf("Obito","Madara","Naruto","Mikasa Ackerman")
        val lastmsg= arrayOf("I declare a war against leaf village","It sounds a lot of fun","talk no jutsu","I think i am in wrong group")
        val lastmsgtime= arrayOf("5:35 PM","5:36 PM","5:35 PM","5:36 PM",)
        val phoneNumber= arrayOf("9865710591","3845873","34876387","3463483")
        val imgid= intArrayOf(R.drawable.pic1,R.drawable.pic17,R.drawable.pic18,R.drawable.pic25)

        userarraylist=ArrayList()

        for (eachIndex in name.indices){
            val user =user(name[eachIndex], lastmsg[eachIndex], lastmsgtime[eachIndex], phoneNumber[eachIndex],imgid[eachIndex])
            userarraylist.add(user)
        }

        val listview=findViewById<ListView>(R.id.listview)
        listview.adapter=Myadapter(this,userarraylist)

        listview.setOnItemClickListener { parent, view, position, id ->
            val username=userarraylist[position].name
            val img=userarraylist[position].imgid
            val message=userarraylist[position].lastmsg
            val  phone=userarraylist[position].phoneNumber
            val i =Intent(this,useractivity::class.java)
            i.putExtra("name",username)
            i.putExtra("imgid",img)
            i.putExtra("phoneNumber",phone)
            startActivity(i)
        }
    }
}