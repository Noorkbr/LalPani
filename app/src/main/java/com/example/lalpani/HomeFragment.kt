package com.example.lalpani

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lalpani.Adapters.DrinkAdapter
import com.example.lalpani.PresentationLayer.DrinkViewModel
import com.example.lalpani.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: DrinkViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: DrinkAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        observer()
        return binding.root
    }
    private fun observer() {
        viewModel.getDrinkData("vodka")
        viewModel.drinkData.observe(viewLifecycleOwner)
        {
            adapter = DrinkAdapter(it)
            binding.mealsRecyclerView.adapter = adapter

        }
    }

}