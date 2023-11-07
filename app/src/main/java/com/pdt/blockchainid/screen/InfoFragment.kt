package com.pdt.blockchainid.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdt.blockchainid.R
import com.pdt.blockchainid.adapter.CardAdapter
import com.pdt.blockchainid.databinding.FragmentAddCardBinding
import com.pdt.blockchainid.databinding.FragmentInfoBinding
import com.pdt.blockchainid.model.ListInfoItem

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private lateinit var mAdapter: CardAdapter
    private lateinit var mListCard: ArrayList<ListInfoItem>


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
        // Inflate the layout for this fragment
        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        initView()
        initData()
        onHandle()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initView() {

    }

    private fun initData() {
        mListCard = arrayListOf(
            ListInfoItem("Da Nang, Viet Nam",9913344112, "Pham Dinh Thoan", "Nam"),
            ListInfoItem("Quang Binh, Viet Nam",344112553, "Nguyen Minh Hoang", "Nam"),
            ListInfoItem("Da Nang, Viet Nam",9913344112, "Pham Thu Quynh", "Nu"),
            ListInfoItem("TP HCM, Viet Nam",9913344112, "Hoang Thao Nguyen", "Nu"),
        )

        mAdapter = CardAdapter(mContext)
        binding.listCardRV.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false)
        binding.listCardRV.adapter = mAdapter

        mAdapter.setListCard(mListCard)
    }

    private fun onHandle() {

    }

}