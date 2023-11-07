package com.pdt.blockchainid.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lutech.aiart.extentionFunction.startActivityFromFragment
import com.pdt.blockchainid.R
import com.pdt.blockchainid.databinding.FragmentAddCardBinding

class AddCardFragment : Fragment() {
    private var _binding: FragmentAddCardBinding? = null
    private val binding get() = _binding!!

    private lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddCardBinding.inflate(inflater, container, false)

        initView()
        initData()
        onHandle()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initView() {

    }

    private fun initData() {

    }

    private fun onHandle() {
        binding.btnTryNow.setOnClickListener {
            startActivityFromFragment(mContext, AddCardActivity::class.java)
        }
    }
}