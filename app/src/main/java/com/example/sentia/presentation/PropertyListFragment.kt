package com.example.sentia.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sentia.R
import com.example.sentia.presentation.components.PropertyCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PropertyListFragment : Fragment() {

    private val viewModel: PropertyListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("onCreateView:","Called")
        return ComposeView(requireContext()).apply {
            setContent {

                val properties = viewModel.property.value

                LazyColumn {
                    itemsIndexed(items = properties){
                        index, property ->
                        PropertyCard(
                            property = property,
                            onClick = {
                                val bundle = Bundle()
                                bundle.putParcelable("propertyDetail", property)
                                findNavController().navigate(
                                    R.id.view_property_detail,
                                    bundle)
                            })
                        }
                    }
                }
            }
        }
    }