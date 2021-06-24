package com.example.sentia.presentation

import android.os.Bundle
import android.util.Log
import android.util.Property
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sentia.Properties

class PropertyDetailFragment : Fragment() {

    lateinit var propertyDetail: Properties

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Detail Fragment: ", "CREATED")
        arguments?.getParcelable<Properties>("propertyDetail")?.let { property ->
            propertyDetail = property
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            bottom = 6.dp,
                            top = 6.dp)
                ) {
                    Text(
                        text = propertyDetail.description,
                        style = TextStyle(
                            fontSize = 21.sp,
                            color = Color.DarkGray
                        ),
                        modifier = Modifier
                            .padding(6.dp)
                    )
                    Text(
                        text = propertyDetail.display_price,
                        style = TextStyle(
                            fontSize = 21.sp,
                            color = Color.DarkGray
                        ),
                        modifier = Modifier
                            .padding(6.dp)
                    )

                }

            }
        }
    }
}