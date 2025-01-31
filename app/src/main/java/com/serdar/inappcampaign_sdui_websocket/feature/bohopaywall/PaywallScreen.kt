package com.serdar.inappcampaign_sdui_websocket.feature.bohopaywall

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

enum class ListType {
    VERTICAL, HORIZONTAL, GRID
}

enum class CardStyle {
    BASIC, ELEVATED, OUTLINED, GRADIENT
}

@Serializable
data class ScreenConfig(
    val type: String,
    val background: BackgroundConfig,
    val padding: Int,
    val children: List<ComponentConfig>,
)

@Serializable
data class BackgroundConfig(
    val brush: GradientColors,
    val style: BackgroundStyle,
)

@Serializable
data class BackgroundStyle(
    val brushType:String,
)

@Serializable
data class ListStyle(
    val spacing: Int,
    val padding: PaddingStyle,
    val cardStyle: CardStyle,
)

@Serializable
data class PaddingStyle(
    val horizontal: Int = 0,
    val vertical: Int = 0,
)

@Serializable
data class ListItemConfig(
    val type: String,
    val data: ItemData,
    val style: ItemStyle,
)

@Serializable
data class ItemData(
    val title: String,
    val subtitle: String? = null,
    val image: String? = null,
    val badge: String? = null,
    val price: String? = null,
    val description: String? = null,
)

@Serializable
data class ItemStyle(
    val backgroundColor: String,
    val cornerRadius: Int,
    val elevation: Int = 0,
    val gradientColors: List<String>? = null,
    val titleColor: String,
    val subtitleColor: String? = null,
    val padding: PaddingStyle = PaddingStyle(),
)

@Serializable
sealed class ComponentConfig {

    @Serializable
    @SerialName("text")
    data class Text(
        val content: String,
        val style: TextStyle,
    ) : ComponentConfig()

    @Serializable
    @SerialName("grid")
    data class Grid(
        val columns: Int,
        val items: List<PlanCardConfig>,
    ) : ComponentConfig()

    @Serializable
    @SerialName("featuresList")
    data class FeaturesList(
        val items: List<String>,
        val style: FeaturesStyle,
    ) : ComponentConfig()

    @Serializable
    @SerialName("button")
    data class Button(
        val content: String,
        val style: ButtonStyle,
    ) : ComponentConfig()

    @Serializable
    @SerialName("lists")
    data class Lists(
        val types: ListType,
        val items: List<ListItemConfig>,
        val style: ListStyle,
        val gridColumns: Int? = null,
    ) : ComponentConfig()

    @Serializable
    @SerialName("reviewCard")
    data class ReviewCard(
        val data: ReviewData,
        val style: ReviewStyle,
    ) : ComponentConfig()
}

@Serializable
data class TextStyle(
    val color: String,
    val fontSize: Int,
    val fontWeight: String? = null,
    val paddingBottom: Int? = null,
)

@Serializable
data class PlanCardConfig(
    val data: PlanData,
    val style: PlanCardStyle,
)

@Serializable
data class PlanData(
    val amount: Int,
    val period: String,
    val discount: Int,
    val originalPrice: String,
    val price: String,
    val tag: String?,
)

@Serializable
data class PlanCardStyle(
    val selectedBorderColor: String,
    val unselectedBorderColor: String,
    val backgroundColor: String,
    val tagBackgroundColor: String,
)

@Serializable
data class FeaturesStyle(
    val bulletColor: String,
    val textColor: String,
    val spacing: Int,
)

@Serializable
data class ButtonStyle(
    val gradient: GradientColors,
    val height: Int,
    val cornerRadius: Int,
)

@Serializable
data class GradientColors(
    val startColor: String,
    val endColor: String,
)

@Serializable
data class ReviewData(
    val title: String,
    val rating: Int,
    val review: String,
    val author: String,
    val date: String,
)

@Serializable
data class ReviewStyle(
    val backgroundColor: String,
    val textColor: String,
    val secondaryTextColor: String,
)

fun brushType(config: BackgroundConfig):Brush{
  return  when(config.style.brushType){
        "Horizantal" -> Brush.horizontalGradient(
            colors = listOf(
                Color(android.graphics.Color.parseColor(config.brush.startColor)),
                Color(android.graphics.Color.parseColor(config.brush.endColor))
            )
        )
      "Vertical" ->  Brush.verticalGradient(
          colors = listOf(
              Color(android.graphics.Color.parseColor(config.brush.startColor)),
              Color(android.graphics.Color.parseColor(config.brush.endColor))
          )
      )
      "Linear" ->  Brush.linearGradient(
          colors = listOf(
              Color(android.graphics.Color.parseColor(config.brush.startColor)),
              Color(android.graphics.Color.parseColor(config.brush.endColor))
          )
      )

      else -> {
          Brush.horizontalGradient(
              colors = listOf(
                  Color(android.graphics.Color.parseColor(config.brush.startColor)),
                  Color(android.graphics.Color.parseColor(config.brush.endColor))
              ))
      }
  }
}

@Composable
fun SDUIScreen(config: ScreenConfig) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush =
               brushType(config.background)

            )
            .padding(config.padding.dp)
    ) {
        config.children.forEach { component ->
            when (component) {
                is ComponentConfig.Text -> SDUIText(component)
                is ComponentConfig.Grid -> SDUIGrid(component)
                is ComponentConfig.FeaturesList -> SDUIFeaturesList(component)
                is ComponentConfig.Button -> SDUIButton(component)
                is ComponentConfig.ReviewCard -> SDUIReviewCard(component)
                is ComponentConfig.Lists -> SDUIList(component)
            }
        }
    }
}

@Composable
fun SDUIText(config: ComponentConfig.Text) {
    Text(
        text = config.content,
        color = Color(android.graphics.Color.parseColor(config.style.color)),
        fontSize = config.style.fontSize.sp,
        fontWeight = when (config.style.fontWeight) {
            "bold" -> FontWeight.Bold
            else -> FontWeight.Normal
        },
        modifier = Modifier.padding(bottom = (config.style.paddingBottom ?: 0).dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SDUIGrid(config: ComponentConfig.Grid) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(config.columns), modifier = Modifier.fillMaxWidth()
    ) {
        items(config.items) { planConfig ->
            var isSelected by remember { mutableStateOf(false) }
            Card(modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (isSelected) 2.dp else 1.dp, color = Color(
                        android.graphics.Color.parseColor(
                            if (isSelected) planConfig.style.selectedBorderColor
                            else planConfig.style.unselectedBorderColor
                        )
                    ), shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp), onClick = { isSelected = !isSelected }) {
                Text("${planConfig.data.tag}")
                Text("${planConfig.data.amount}")
                Text(planConfig.data.price)
            }
        }
    }
}

@Composable
fun SDUIFeaturesList(config: ComponentConfig.FeaturesList) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        config.items.forEach { feature ->
            Row(
                modifier = Modifier.padding(vertical = config.style.spacing.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "•",
                    color = Color(android.graphics.Color.parseColor(config.style.bulletColor)),
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = feature,
                    color = Color(android.graphics.Color.parseColor(config.style.textColor))
                )
            }
        }
    }
}

@Composable
fun SDUIButton(config: ComponentConfig.Button) {
    Button(
        onClick = { config.content },
        modifier = Modifier
            .fillMaxWidth()
            .height(config.style.height.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor(config.style.gradient.startColor)),
                            Color(android.graphics.Color.parseColor(config.style.gradient.endColor))
                        )
                    ), shape = RoundedCornerShape(config.style.cornerRadius.dp)
                ), contentAlignment = Alignment.Center
        ) {
            Text(
                text = config.content, color = Color.White, fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SDUIReviewCard(config: ComponentConfig.ReviewCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(config.data.title)
            Text(config.data.date)
            Text(config.data.author)
        }
    }
}


@Composable
fun SDUIList(config: ComponentConfig.Lists) {
    when (config.types) {
        ListType.HORIZONTAL -> {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(config.style.spacing.dp),
                contentPadding = PaddingValues(
                    horizontal = config.style.padding.horizontal.dp,
                    vertical = config.style.padding.vertical.dp
                )
            ) {
                items(config.items.size) { index ->
                    ListItem(config.items[index], config.style.cardStyle)
                }
            }
        }

        ListType.VERTICAL -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(config.style.spacing.dp),
                contentPadding = PaddingValues(
                    horizontal = config.style.padding.horizontal.dp,
                    vertical = config.style.padding.vertical.dp
                )
            ) {
                items(config.items.size) { index ->
                    ListItem(config.items[index], config.style.cardStyle)
                }
            }
        }

        ListType.GRID -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(config.gridColumns ?: 2),
                horizontalArrangement = Arrangement.spacedBy(config.style.spacing.dp),
                verticalArrangement = Arrangement.spacedBy(config.style.spacing.dp),
                contentPadding = PaddingValues(
                    horizontal = config.style.padding.horizontal.dp,
                    vertical = config.style.padding.vertical.dp
                )
            ) {
                items(config.items.size) { index ->
                    ListItem(config.items[index], config.style.cardStyle)
                }
            }
        }
    }
}

@Composable
fun ListItem(config: ListItemConfig, cardStyle: CardStyle) {
    val itemModifier = Modifier
        .padding(
            horizontal = config.style.padding.horizontal.dp,
            vertical = config.style.padding.vertical.dp
        )
        .clip(RoundedCornerShape(config.style.cornerRadius.dp))

    when (cardStyle) {
        CardStyle.BASIC -> BasicCard(config, itemModifier)
        CardStyle.ELEVATED -> ElevatedCard(config, itemModifier)
        CardStyle.OUTLINED -> OutlinedCard(config, itemModifier)
        CardStyle.GRADIENT -> GradientCard(config, itemModifier)
    }
}

@Composable
fun BasicCard(config: ListItemConfig, modifier: Modifier) {
    Card(
        modifier = modifier, colors = CardDefaults.cardColors(
            Color(android.graphics.Color.parseColor(config.style.backgroundColor))
        )
    ) {
        CardContent(config)
    }
}

@Composable
fun ElevatedCard(config: ListItemConfig, modifier: Modifier) {
    Card(
        modifier = modifier.shadow(
            elevation = config.style.elevation.dp,
            shape = RoundedCornerShape(config.style.cornerRadius.dp)
        ),
        colors = CardDefaults.cardColors(Color(android.graphics.Color.parseColor(config.style.backgroundColor)))
    ) {
        CardContent(config)
    }
}

@Composable
fun OutlinedCard(config: ListItemConfig, modifier: Modifier) {
    Card(
        modifier = modifier.border(
            width = 1.dp,
            color = Color(android.graphics.Color.parseColor(config.style.backgroundColor)),
            shape = RoundedCornerShape(config.style.cornerRadius.dp)
        )
    ) {
        CardContent(config)
    }
}

@Composable
fun GradientCard(config: ListItemConfig, modifier: Modifier) {
    Card(
        modifier = modifier
    ) {
        Box(modifier = Modifier.background(brush = Brush.horizontalGradient(colors = config.style.gradientColors?.map {
            Color(android.graphics.Color.parseColor(it))
        } ?: listOf(Color.Gray, Color.DarkGray)))) {
            CardContent(config)
        }
    }
}

@Composable
fun CardContent(config: ListItemConfig) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        config.data.title.let {
            Text(
                text = it,
                color = Color(android.graphics.Color.parseColor(config.style.titleColor)),
                style = MaterialTheme.typography.titleMedium
            )
        }
        config.data.subtitle?.let {
            Text(
                text = it, color = Color(
                    android.graphics.Color.parseColor(
                        config.style.subtitleColor ?: "#808080"
                    )
                ), style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun SDUIScreenPreview() {
    val jsonString = """
{
  "type": "screen",
   "background": {
    "brush": {
      "startColor": "#FF5800",
      "endColor": "#F44336"
    },
    "style":{
      "brushType": "Vertical"
    }
  },
  "padding": 16,
  "children": [
    {
      "type": "text",
      "content": "Welcome to Boho Paywall",
      "style": {
        "color": "#000000",
        "fontSize": 20,
        "fontWeight": "bold",
        "paddingBottom": 8
      }
    },
    {
      "type": "grid",
      "columns": 1,
      "items": [
        {
          "data": {
            "amount": 10,
            "period": "month",
            "discount": 20,
            "originalPrice": "${'$'}12.99",
            "price": "${'$'}9.99",
            "tag": "Best Deal"
          },
          "style": {
            "selectedBorderColor": "#FF9800",
            "unselectedBorderColor": "#E0E0E0",
            "backgroundColor": "#FFFFFF",
            "tagBackgroundColor": "#FFC107"
          }
        },
         {
          "data": {
            "amount": 10,
            "period": "month",
            "discount": 20,
            "originalPrice": "${'$'}12.99",
            "price": "${'$'}9.99",
            "tag": "Best Deal"
          },
          "style": {
            "selectedBorderColor": "#FF9800",
            "unselectedBorderColor": "#E0E0E0",
            "backgroundColor": "#FFFFFF",
            "tagBackgroundColor": "#FFC107"
          }
        },
         {
          "data": {
            "amount": 10,
            "period": "month",
            "discount": 20,
            "originalPrice": "${'$'}12.99",
            "price": "${'$'}9.99",
            "tag": "Best Deal"
          },
          "style": {
            "selectedBorderColor": "#FF9800",
            "unselectedBorderColor": "#E0E0E0",
            "backgroundColor": "#FFFFFF",
            "tagBackgroundColor": "#FFC107"
          }
        }
      ]
    },
    {
      "type": "featuresList",
      "items": [
        "Unlimited access",
        "Ad-free experience",
        "Priority support"
      ],
      "style": {
        "bulletColor": "#FF5722",
        "textColor": "#333333",
        "spacing": 8
      }
    },
    {
      "type": "button",
      "content": "Subscribe Now",
      "style": {
        "gradient": {
          "startColor": "#FF9800",
          "endColor": "#F44336"
        },
        "height": 48,
        "cornerRadius": 8
      }
    },
    {
      "type": "lists",
      "types": "HORIZONTAL",
      "items": [
        {
          "type": "listItem",
          "data": {
            "title": "Premium Plan",
            "subtitle": "Best for professionals",
            "image": "https://example.com/image.png",
            "badge": "Popular",
            "price": "${'$'}9.99/month",
            "description": "Access to exclusive content"
          },
          "style": {
            "backgroundColor": "#FAFAFA",
            "cornerRadius": 12,
            "elevation": 4,
            "titleColor": "#000000",
            "subtitleColor": "#757575",
            "padding": {
              "horizontal": 16,
              "vertical": 12
            }
          }
        },
         {
          "type": "listItem",
          "data": {
            "title": "Premium Plan",
            "subtitle": "Best for professionals",
            "image": "https://example.com/image.png",
            "badge": "Popular",
            "price": "${'$'}9.99/month",
            "description": "Access to exclusive content"
          },
          "style": {
            "backgroundColor": "#FAFAFA",
            "cornerRadius": 12,
            "elevation": 4,
            "titleColor": "#000000",
            "subtitleColor": "#757575",
            "padding": {
              "horizontal": 16,
              "vertical": 12
            }
          }
        },
         {
          "type": "listItem",
          "data": {
            "title": "Premium Plan",
            "subtitle": "Best for professionals",
            "image": "https://example.com/image.png",
            "badge": "Popular",
            "price": "${'$'}9.99/month",
            "description": "Access to exclusive content"
          },
          "style": {
            "backgroundColor": "#FAFAFA",
            "cornerRadius": 12,
            "elevation": 4,
            "titleColor": "#000000",
            "subtitleColor": "#757575",
            "padding": {
              "horizontal": 16,
              "vertical": 12
            }
          }
        }
      ],
      "style": {
        "spacing": 16,
        "padding": {
          "horizontal": 16,
          "vertical": 12
        },
        "cardStyle": "ELEVATED"
      }
    },
    {
      "type": "reviewCard",
      "data": {
        "title": "Great Service!",
        "rating": 5,
        "review": "I've been using this for months, and it's amazing.",
        "author": "John Doe",
        "date": "2024-01-31"
      },
      "style": {
        "backgroundColor": "#FFFFFF",
        "textColor": "#000000",
        "secondaryTextColor": "#757575"
      }
    }
  ]
}

    """.trimIndent()
    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    val screenConfig = json.decodeFromString<ScreenConfig>(jsonString)
    SDUIScreen(screenConfig)
}

