package com.serdar.inappcampaign_sdui_websocket.feature.onetoone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.serdar.inappcampaign_sdui_websocket.R
import com.serdar.inappcampaign_sdui_websocket.feature.MainViewModel

@Composable
fun OneToOneScreen(mainViewModel: MainViewModel = hiltViewModel()) {
    Scaffold(modifier = Modifier, containerColor = Color.Black, topBar = {
        TopBarContent()
    }, bottomBar = {

    }) { paddingValues ->
        DifferentItemsLazyColumn(
            Modifier
                .padding(paddingValues)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF000000), Color(0xFFAC03F4), Color(0xFFDD1584)
                        )
                    )
                ), mainViewModel.socketData
        )
    }
}

@Composable
fun TopBarContent() {
    Row(
        modifier = Modifier
            .background(
                Color.Transparent
            )
            .padding(start = 10.dp, end = 10.dp, bottom = 23.dp, top = 23.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Image
        Image(
            painter = painterResource(id = R.drawable.profile_place_holder),
            contentDescription = "Logo",
            modifier = Modifier
                .size(38.dp)
                .align(Alignment.CenterVertically)
        )
        // First Button
        Button(modifier = Modifier, colors = ButtonDefaults.buttonColors(
            Color(0xFFAB47BC)
        ), onClick = { }) {
            Text(text = "Moments")
        }
        // First Icon
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterVertically)
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notification",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterVertically)
        )

        Button(colors = ButtonDefaults.buttonColors(
            Color(0xFFAB47BC)
        ), onClick = {}) {
            Image(
                painter = painterResource(id = R.drawable.ic_diamond),
                contentDescription = "Market Logo",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(28.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(text = "Market")
        }
    }
}

@Composable
fun GetImageFromCoil(imageUrl: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true).build(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun GetImageFromCoilMini(imageUrl: String, modifier: Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true).build(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Preview
@Composable
fun TopBarContentPreview() {
    TopBarContent()
}