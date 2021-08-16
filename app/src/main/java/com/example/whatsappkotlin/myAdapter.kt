package com.example.whatsappkotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class myAdapter(Frg:FragmentManager) : FragmentPagerAdapter(Frg) {


    var fragments = ArrayList<Fragment>()
    var tabTitle = ArrayList<String>()

    fun addFragment(fragm : Fragment , tabTitle:String){
        this.fragments.add(fragm)
        this.tabTitle.add(tabTitle)
    }
    override fun getItem(position: Int): Fragment {
        return this.fragments[position]
    }

    override fun getCount(): Int {
        return this.fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return this.tabTitle[position]
    }

}