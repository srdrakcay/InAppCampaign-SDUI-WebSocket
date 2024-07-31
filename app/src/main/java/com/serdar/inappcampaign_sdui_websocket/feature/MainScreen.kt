import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.absoluteOffset
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
import com.serdar.inappcampaign_sdui_websocket.R
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponse
import com.serdar.inappcampaign_sdui_websocket.feature.CustomCardShape
import com.serdar.inappcampaign_sdui_websocket.feature.MainViewModel
import com.serdar.inappcampaign_sdui_websocket.feature.ViewScreenType
import com.serdar.inappcampaign_sdui_websocket.util.colorText
import com.serdar.inappcampaign_sdui_websocket.util.position

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {
    if (mainViewModel.socketData.isNotEmpty()) {
        DifferentItemsLazyColumn(mainViewModel.socketData.first())
    }

}
@Composable
fun DifferentItemsLazyColumn(data: SocketResponse) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(top = 40.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(data.socketData) { item ->
            val itemType = ViewScreenType.fromString(item.type)
            when (itemType) {
                ViewScreenType.Text -> {
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
                ViewScreenType.Image -> {
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
              else->{

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
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingCard.dp)
            .graphicsLayer {
                shape = CustomCardShape()
                clip = true
            }
            .height(height.dp)
    ) {
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
        Card(
            shape = RoundedCornerShape(cardTimeCornerRadius.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .absoluteOffset(x = (-15).dp, y = 5.dp)
                .size(sizeW.dp, sizeH.dp),
            elevation = CardDefaults.cardElevation(cardTimeElevation.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
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



@Preview(showBackground = true)
@Composable
fun PreviewGradientCardScreen() {

}
