package com.example.viewpagersubmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpagersubmission.databinding.FragmentCollectionObjectBinding

class DemoObjectFragment : Fragment() {
    companion object {
        const val ARG_OBJECT = "object"
    }

    private var _binding: FragmentCollectionObjectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCollectionObjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            binding.tvItem.text = "CONTENT ${getInt(ARG_OBJECT)}"
        }
    }
}