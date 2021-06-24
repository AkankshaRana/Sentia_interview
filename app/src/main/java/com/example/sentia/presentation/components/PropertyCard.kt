package com.example.sentia.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sentia.Properties
import com.example.sentia.R
import com.example.sentia.utils.*
import com.example.sentia.utils.loadPicture
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun PropertyCard(
    property: Properties,
    onClick: () -> Unit,
){
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ){
        Column {
            property.property_images[0].attachment.url.let { url ->
                val image = loadPicture(
                    url = url,
                    defaultImage = DEFAULT_PROPERTY_IMAGE).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "Property Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(250.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            property.display_price.let{display_price -> Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 8.dp, end = 8.dp)
            ){
                Text(
                    text = display_price,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h5
                )
                property.agent.avatar.small.url.let { url->
                    val agentImage = loadAgentPicture(
                        url = url,
                        defaultImage = DEFAULT_AGENT_IMAGE).value
                    agentImage?.let { img ->
                        Image(
                            bitmap = img.asImageBitmap(),
                            contentDescription = "agent_face",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .requiredHeight(50.dp)
                                .requiredWidth(50.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop)
                    }
                }
            }

            }
            property.location.address.let{address->
                Text(text = address,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h5
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    Image(painter = painterResource(
                        id = R.drawable.ic_outline_king_bed_24),
                        contentDescription = "Bed")
                    Text(text = property.bathrooms.toString(),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h6)
                }
                Row(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    Image(painter = painterResource(
                        id = R.drawable.ic_outline_bathtub_24),
                        contentDescription = "Bathrooms",)
                    Text(text = property.bedrooms.toString(),
                        modifier = Modifier.align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h6)
                }
                Row(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(painter = painterResource(
                        id = R.drawable.ic_outline_directions_car_24),
                        contentDescription = "Car Park",)
                    Text(text = property.carspaces.toString(),
                        style = MaterialTheme.typography.h6)
                }
            }
        }
    }
}