package com.example.whatsappkotlin

import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    var mActionMode : ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hideTab()

        myToolBar.title = "WhatsApp"
        setSupportActionBar(myToolBar)


        var myAdapter = myAdapter(supportFragmentManager)

        myAdapter.addFragment(Chats_Fragment(),"CHATS")
        myAdapter.addFragment(Status_Fragment(),"STATUS")
        myAdapter.addFragment(Calls_Fragment(),"CALLS")

        myViewPager.adapter = myAdapter
        tabLayout.setupWithViewPager(myViewPager)
        tabLayout.setTabTextColors(Color.parseColor("#84AFAB"),Color.parseColor("#FFFFFF"))

        button.setOnClickListener {
            startSupportActionMode(ContextualMenu())
        }

        image_back.setOnClickListener {
            hideTab()
            myToolBar.visibility = View.VISIBLE
            tabLayout.visibility = View.VISIBLE
            removeEditText()

        }

        image_close.setOnClickListener {
            removeEditText()
        }

    }

    fun hideTab(){
        editText_search.visibility = View.GONE
        image_close.visibility = View.GONE
        image_back.visibility = View.GONE
    }

    fun removeEditText(){
        editText_search.text.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_whatssapp,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var item = item.itemId
        when(item){
            R.id.itemSearch -> {
//                supportActionBar?.hide()
                myToolBar.visibility = View.GONE
                tabLayout.visibility = View.GONE
                editText_search.visibility = View.VISIBLE
                image_back.visibility = View.VISIBLE
                image_close.visibility = View.VISIBLE
            }
            R.id.item1 -> Toast.makeText(this,"New group",Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this,"New broadcast",Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(this,"WahtssApp web",Toast.LENGTH_SHORT).show()
            R.id.item4 -> Toast.makeText(this,"Starred messages",Toast.LENGTH_SHORT).show()
            R.id.item5 -> Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show()
        }
        return true
    }



    inner class ContextualMenu :androidx.appcompat.view.ActionMode.Callback {
        override fun onActionItemClicked(
            mode: androidx.appcompat.view.ActionMode?,
            item: MenuItem?
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun onCreateActionMode(
            mode: androidx.appcompat.view.ActionMode?,
            menu: Menu?
        ): Boolean {
            mode?.menuInflater?.inflate(R.menu.contextual_menu,menu)
            return true
        }

        override fun onPrepareActionMode(
            mode: androidx.appcompat.view.ActionMode?,
            menu: Menu?
        ): Boolean {
            mode?.title = "Contextual Menu"
            return true
        }

        override fun onDestroyActionMode(mode: androidx.appcompat.view.ActionMode?) {
            mode?.finish()
        }


    }
}

/* :androidx.appcompat.view.ActionMode.Callback */
