package com.example.thehungrybunch30.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.thehungrybunch30.R
import com.example.thehungrybunch30.databinding.FragmentHomeBinding
import com.example.thehungrybunch30.ui.carousel_adapter.CarouselAdapter
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

// Assuming you have the RecyclerView reference as carouselRecyclerView
        val imageList = listOf(R.drawable.beefsamosas, R.drawable.chickensamosas, R.drawable.vegetablespringrolls, R.drawable.boreworshotdog)
        val carouselAdapter = CarouselAdapter(requireContext(), imageList)
        val carouselRecyclerView : RecyclerView = binding.carouselRecyclerView
        carouselRecyclerView.adapter = carouselAdapter

        // my carousel layout manager
       carouselRecyclerView.setLayoutManager(CarouselLayoutManager())
        // multi browse strategy for the carousel view
        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(carouselRecyclerView)

       val textView: TextView = binding.texth
      homeViewModel.text.observe(viewLifecycleOwner) {
        textView.text = it
       }
        val navButton : Button = binding.order1Button
        navButton.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        val navButton2 : Button = binding.order2Button
        navButton2.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        val navButton3 : Button = binding.order3Button
        navButton3.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        val navButton4 : Button = binding.order4Button
        navButton4.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        val navButton5 : Button = binding.order5Button
        navButton5.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
