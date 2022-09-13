package com.lloydsbankinggroupcc.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.lloydsbankinggroupcc.databinding.FragmentPetDetailBinding
import com.lloydsbankinggroupcc.util.loadImage


class PetDetailFragment : Fragment() {

    private var _binding: FragmentPetDetailBinding? = null
    private val args: PetDetailFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPetDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayPetDetail()
    }

    private fun displayPetDetail() {
        loadImage(binding.petImage, args.imageUrl)
        binding.apply {
            breed.text = args.primaryBreed
            size.text = args.size
            status.text = args.status
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}