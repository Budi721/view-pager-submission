package com.example.viewpagersubmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagersubmission.databinding.CollectionDemoBinding
import com.google.android.material.tabs.TabLayoutMediator

class CollectionDemoFragment: Fragment() {
    private var _binding: CollectionDemoBinding? = null
    private val binding get() = _binding!!

    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CollectionDemoBinding.inflate(inflater, container, false)
        demoCollectionAdapter = DemoCollectionAdapter(this)
        viewPager = binding.pager
        viewPager.adapter = demoCollectionAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            tab.text = "${(position + 1)}"
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}