package com.serdar.inappcampaign_sdui_websocket.feature.bohopaywall
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


@Composable
fun PremiumPlanCard(
    config: ListItemConfig,
    modifier: Modifier=Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF00FF00),
                        Color(0xFF9C27B0)
                    )
                ),
                shape = RoundedCornerShape(config.style.cornerRadius.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2A2A2A)
        ),
        shape = RoundedCornerShape(config.style.cornerRadius.dp)
    ) {
        Column(
            modifier = modifier.padding(16.dp)
        ) {
            if (config.data.isMonthly) {
                Text(
                    text = "EN POPÜLER",
                    color = Color(0xFF9C27B0),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.align(Alignment.End)
                )
            }
            if (config.data.isPopular) {
                Text(
                    text = "EN İYİ TEKLİF",
                    color = Color(0xFF9C27B0),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.align(Alignment.End)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = config.data.price.toString(),
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        fontSize = config.style.titleSize.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Text(
                    text = config.data.badge.toString(),
                    color = Color(0xFF00FF00),
                    fontSize = config.style.subTitleSize.sp,
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Text(
                text = config.data.subtitle.toString(),
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = config.style.subTitleSize.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = config.data.description.toString(),
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyMedium,
                    textDecoration = TextDecoration.LineThrough,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = config.data.price.toString(),
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
