package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding
    lateinit var adapter: RecipeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Recipe>()
        list.add(Recipe("MAC Ruby Woo Lipstick", "Ruby Woo", "1999", "MAC Cosmetics"))
        list.add(Recipe("Urban Decay Naked Palette", "Neutral tones", "2007", "Urban Decay"))
        list.add(Recipe("Fenty Beauty Pro Filt'r Foundation", "Range of", "2014", "Fenty Beauty"))
        list.add(Recipe("Renaissance Eyeshadow Palette", "Range of", "2000", "Anastasia Beverly Hills"))
        list.add(Recipe("NARS Cutie Blush", "Peachy pink", "2015", "NARS Cosmetics"))

        adapter = RecipeAdapter() { recipe, position ->
            findNavController().navigate(
                FirstFragmentDirections.toSecondFragment(
                    recipe.name,
                    recipe.shade,
                    recipe.year,
                    recipe.company
                )
            )
            Toast.makeText(requireContext(), "Clicked element №$position", Toast.LENGTH_SHORT)
                .show()
        }
        adapter.setList(list)
        binding.rv.adapter = adapter

        binding.firstBtnToSecond.setOnClickListener {

            findNavController().navigate(
                FirstFragmentDirections.toSecondFragment(
                    "Name",
                    "Shade",
                    "Release year",
                    "Company"
                )
            )
        }
    }
}