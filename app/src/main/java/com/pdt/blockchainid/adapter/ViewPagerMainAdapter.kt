package com.pdt.blockchainid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pdt.blockchainid.screen.AddCardFragment
import com.pdt.blockchainid.screen.InfoFragment


class ViewPagerMainAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return AddCardFragment()
            1 -> return InfoFragment()
            else -> return AddCardFragment()
        }
    }
}