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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.talkie.inappcampaign_sdui_websocket.R
import com.talkie.inappcampaign_sdui_websocket.data.dto.SocketResponse
import com.talkie.inappcampaign_sdui_websocket.data.resource.WebSocketResource
import com.talkie.inappcampaign_sdui_websocket.feature.MainViewModel
import com.talkie.inappcampaign_sdui_websocket.util.colorText
import com.talkie.inappcampaign_sdui_websocket.util.position

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {
    val dataValues =
        mainViewModel.socketEvent.collectAsState(initial = WebSocketResource.Connecting)
    var data by remember { mutableStateOf(SocketResponse(socketData = listOf())) }

    when (dataValues.value) {
        WebSocketResource.Closed -> {
        }

        WebSocketResource.Closing -> {
        }

        WebSocketResource.Connected -> {
        }

        WebSocketResource.Connecting -> {
        }

        is WebSocketResource.Failure -> {
        }

        is WebSocketResource.Open -> {
            data = (dataValues.value as WebSocketResource.Open).response
        }

    }
    DifferentItemsLazyColumn(data)

}

@Composable
fun DifferentItemsLazyColumn(data: SocketResponse) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(data.socketData) { item ->
            when (item.type) {
                "Text" -> {
                    GradientCard(
                        paddingCard = item.paddingCard,
                        height = item.height,
                        roundedCornerShape = item.roundedCornerShape,
                        cardElevation = item.cardElevation,
                        verticalGradient1 = colorText(item.verticalGradient1),
                        verticalGradient2 = colorText(item.verticalGradient2),
                        painterResource = R.drawable.ic_diamond1,
                        alignment = position(item.alignment),
                        alignmentText = position(item.alignmentText),
                        messageText = item.messageText,
                        paddingText = item.paddingText,
                        imageSize = item.imageSize,
                        texSize = item.texSize,
                        cardTimeCornerRadius = item.cardTimeCornerRadius,
                        sizeW = item.sizeW,
                        sizeH = item.sizeH,
                        cardPadding = item.cardPadding,
                        cardTimeElevation = item.cardTimeElevation
                    )
                }
                "Image" -> {
                    GradientCard(
                        paddingCard = item.paddingCard,
                        height = item.height,
                        roundedCornerShape = item.roundedCornerShape,
                        cardElevation = item.cardElevation,
                        verticalGradient1 = colorText(item.verticalGradient1),
                        verticalGradient2 = colorText(item.verticalGradient2),
                        painterResource = R.drawable.ic_diamond1,
                        alignment = position(item.alignment),
                        alignmentText = position(item.alignmentText),
                        messageText = item.messageText,
                        paddingText = item.paddingText,
                        imageSize = item.imageSize,
                        texSize = item.texSize,
                        cardTimeCornerRadius = item.cardTimeCornerRadius,
                        sizeW = item.sizeW,
                        sizeH = item.sizeH,
                        cardPadding = item.cardPadding,
                        cardTimeElevation = item.cardTimeElevation
                    )
                }
            }
        }
    }
}


@Composable
fun GradientCard(
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
    cardTimeCornerRadius:Int,
    sizeW:Int,
    sizeH:Int,
    cardPadding:Int,
    cardTimeElevation:Int
) {
    Card(
        shape = RoundedCornerShape(roundedCornerShape.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingCard.dp)
            .height(height.dp),
        elevation = CardDefaults.cardElevation(cardElevation.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(verticalGradient1, verticalGradient2)
                    )
                ),
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
            Card(
                shape = RoundedCornerShape(cardTimeCornerRadius.dp),
                modifier = Modifier
                    .size(sizeW.dp, sizeH.dp)
                    .padding(cardPadding.dp),
                elevation = CardDefaults.cardElevation(cardTimeElevation.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "12:00:12",
                        fontSize = texSize.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }


    }

}



@Preview(showBackground = true)
@Composable
fun PreviewGradientCardScreen() {

}

