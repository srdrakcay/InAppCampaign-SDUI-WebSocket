import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponse
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponseItem
import com.serdar.inappcampaign_sdui_websocket.feature.CustomCardShape
import com.serdar.inappcampaign_sdui_websocket.feature.MainViewModel
import com.serdar.inappcampaign_sdui_websocket.feature.ViewScreenType

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {
    if (mainViewModel.socketData.isNotEmpty()) {
        DifferentItemsLazyColumn(mainViewModel.socketData)
    }

}

@Composable
fun DifferentItemsLazyColumn(data: List<SocketResponseItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(data) { item ->
            val itemType = ViewScreenType.fromString(item.type)
            when (itemType) {
                ViewScreenType.Text -> {

                }

                ViewScreenType.Image -> {

                }

                else -> {

                }
            }
        }
    }
}


@Composable
fun GradientCard(
    modifier: Modifier = Modifier,
    paddingCard: Int,
    height: Int,
    roundedCornerShape: Int,
    cardElevation: Int,
    verticalGradient1: Color,
    verticalGradient2: Color,
    painterResource: Int,
    alignment: Alignment,
    imageSize: Int,
    messageText: String,
    alignmentText: Alignment,
    paddingText: Int,
    texSize: Int,
    cardTimeCornerRadius: Int,
    sizeW: Int,
    sizeH: Int,
    cardPadding: Int,
    cardTimeElevation: Int
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .padding(paddingCard.dp)
        .graphicsLayer {
            shape = CustomCardShape()
            clip = true
        }
        .height(height.dp)) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(verticalGradient1, verticalGradient2)
                    )
                )
        ) {
            Image(
                painter = painterResource(id = painterResource),
                contentDescription = "Your Image",
                modifier = Modifier
                    .align(alignment)
                    .size(imageSize.dp)
            )
            Text(
                text = messageText,
                fontSize = texSize.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .align(alignmentText)
                    .padding(paddingText.dp)
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewGradientCardScreen() {

}

