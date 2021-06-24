package com.example.sentia.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sentia.Properties
import com.example.sentia.repository.PropertyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyListViewModel
@Inject
constructor(
    private val repository: PropertyRepository
): ViewModel(){

    val property: MutableState<List<Properties>> =  mutableStateOf(ArrayList())

    init{
        newSearch()
    }
    private fun newSearch(){
        viewModelScope.launch {
            val result = repository.get()
            property.value = result
        }
    }
}