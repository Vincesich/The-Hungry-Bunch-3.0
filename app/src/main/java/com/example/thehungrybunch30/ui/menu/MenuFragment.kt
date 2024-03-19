package com.example.thehungrybunch30.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.thehungrybunch30.R
import com.example.thehungrybunch30.databinding.FragmentMenuBinding
import com.example.thehungrybunch30.ui.carousel_adapter.CarouselAdapter
import com.example.thehungrybunch30.ui.cart.CartItem
import com.google.android.material.carousel.CarouselSnapHelper

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val cartItems = mutableListOf<CartItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val menuViewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root


      // val textView: TextView = binding.texth
    //  homeViewModel.text.observe(viewLifecycleOwner) {
    //    textView.text = it
    //   }
        val navButton : Button = binding.order1Button
        navButton.setOnClickListener{
            addItemToCart(
                R.drawable.chickenchoma, // Image resource ID
                getString(R.string.Monday_meal), // Item name
                300.00, // Price of the item
                50.00 // Delivery fee
            )
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        val navButton2 : Button = binding.order2Button
        navButton2.setOnClickListener{
            addItemToCart(
                R.drawable.coconutbeastew, // Image resource ID
                getString(R.string.Tuesday_meal), // Item name
                300.00, // Price of the item
                50.00 // Delivery fee
            )
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        val navButton3 : Button = binding.order3Button
        navButton3.setOnClickListener{
            addItemToCart(
                R.drawable.chapatindengu, // Image resource ID
                getString(R.string.Wednesday_meal), // Item name
                300.00, // Price of the item
                50.00 // Delivery fee
            )
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        val navButton4 : Button = binding.order4Button
        navButton4.setOnClickListener{
            addItemToCart(
                R.drawable.beefpilau, // Image resource ID
                getString(R.string.Thursday_meal), // Item name
                300.00, // Price of the item
                50.00 // Delivery fee
            )
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        val navButton5 : Button = binding.order5Button
        navButton5.setOnClickListener{
            addItemToCart(
                R.drawable.friedmuttoniugali, // Image resource ID
                getString(R.string.Friday_meal), // Item name
                300.00, // Price of the item
                50.00 // Delivery fee
            )
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        setupCarouselRecyclerView()
        return root
    }

    private fun setupCarouselRecyclerView(){
        val carouselRecyclerView: RecyclerView = binding.carouselRecyclerView
        CarouselSnapHelper().attachToRecyclerView(carouselRecyclerView)
        carouselRecyclerView.adapter = CarouselAdapter(images = getImages()){
            findNavController().navigate(R.id.navigation_cart)
        }
    }
    private fun getImages(): List<Int>{
        return listOf(
            R.drawable.beefsamosas,
            R.drawable.chickensamosas,
            R.drawable.vegetablespringrolls,
            R.drawable.boreworshotdog)
    }
    private fun addItemToCart(imageResId: Int, itemName: String, price: Double, deliveryFee: Double) {
        val newItem = CartItem(imageResId, itemName, price + deliveryFee)
        cartItems.add(newItem)
        // Optionally, you can notify observers of the cart items list that it has been updated.
        // For example, if you're using LiveData, you could call a method like:
        // cartItemsLiveData.value = cartItems
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
