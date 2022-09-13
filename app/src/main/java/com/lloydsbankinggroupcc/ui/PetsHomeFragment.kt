package com.lloydsbankinggroupcc.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.lloydsbankinggroupcc.R
import com.lloydsbankinggroupcc.data.datamodels.animals.Animal
import com.lloydsbankinggroupcc.databinding.FragmentPetsHomeBinding
import com.lloydsbankinggroupcc.ui.adapter.PetsHomeListAdapter
import com.lloydsbankinggroupcc.util.DataState
import com.lloydsbankinggroupcc.viewmodel.PetsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class PetsHomeFragment : Fragment(), PetsClickListener {

    private var _binding: FragmentPetsHomeBinding? = null
    private val petsViewModel: PetsViewModel by viewModel()
    private lateinit var adapter: PetsHomeListAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPetsHomeBinding.inflate(inflater, container, false)
        petsViewModel.getListOfPets()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPetsRv()
        observePetData()
        observeDataState()

    }

    private fun setupPetsRv() {
        adapter = PetsHomeListAdapter(this)
        binding.petsRv.adapter = adapter
    }

    private fun observeDataState() {
        petsViewModel.dataState.observe(requireActivity()) { data ->
            when (data.status) {
                DataState.Status.LOADING -> showSnackBar(getResourcesText(R.string.loadingStatus))
                DataState.Status.SUCCESS -> showSnackBar(getResourcesText(R.string.finishStatus))
                DataState.Status.FAILED -> showSnackBar(getResourcesText(R.string.errorStatus))
            }
        }
    }

    private fun getResourcesText(resourceId: Int): String {
        return requireContext().resources.getString(resourceId)
    }

    private fun observePetData() {
        petsViewModel.petsData.observe(viewLifecycleOwner) {
            it?.animals?.let { animals ->
                adapter.submitList(animals)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPetItemClick(pet: Animal) {
        val imageUrl = if (!pet.photos.isNullOrEmpty()) {
            pet.photos[0].large
        } else ""

        val action = PetsHomeFragmentDirections.actionHomeFragmentToDetailFragment(
            imageUrl,
            pet.breeds?.primary,
            pet.size,
            pet.status
        )
        findNavController().navigate(action)
    }

    private fun showSnackBar(text: String) {
        Snackbar.make(requireView(), text, Snackbar.LENGTH_LONG).show()
    }
}