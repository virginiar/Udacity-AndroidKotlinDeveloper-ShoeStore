package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.viewmodels.ShoeListViewModel


/**
 * A fragment for the Shoe List Screen
 */
class ShoeListFragment : Fragment() {

    private val viewModel : ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_shoe_list, container, false)

        // This fragment has a menu
        setHasOptionsMenu(true)

        // Binding the ViewModel
        binding.shoeViewModel = viewModel
        binding.setLifecycleOwner(this)

        // Listener for the Shoe List
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            for (shoe in shoes) {
                // Inflate the layout for the shoe item view
                val shoeBinding : ItemShoeBinding = DataBindingUtil
                    .inflate(layoutInflater, R.layout.item_shoe, container, false)
                shoeBinding.shoe = shoe
                binding.shoeListLinear.addView(shoeBinding.root)
            }
        })

        // Listener for the Add Shoe Button
        binding.addShoeButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }

}