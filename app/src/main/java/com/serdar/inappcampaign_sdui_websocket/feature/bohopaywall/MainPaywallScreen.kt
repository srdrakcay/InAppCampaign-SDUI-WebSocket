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
fun SDUIScreens(config: ScreenConfig) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A1A1A),
                        Color(0xFF0A0A0A)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header with close button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {
                Text(
                    text = "Boho Live Silver Weekly",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                )
            }

            // Premium Plans
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Weekly Premium Plan Card
                PremiumPlanCard(
                    coins = "15.000",
                    period = "7 günde bir yenilenir",
                    discount = "-50%",
                    price = "649₺/hafta",
                    originalPrice = "1209,99₺",
                    isPopular = true
                )

                // Weekly Basic Plan Card
                PremiumPlanCard(
                    coins = "7.500",
                    period = "7 günde bir yenilenir",
                    discount = "-35%",
                    price = "410,99₺/hafta",
                    originalPrice = "649₺",
                    isPopular = false
                )
            }

            // Features List
            LazyColumn(
                modifier = Modifier.padding(vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(features) { feature ->
                    FeatureItem(text = feature)
                }
            }

            // Monthly Premium Plan
            PremiumPlanCard(
                coins = "100.000",
                period = "30 günde bir yenilenir",
                discount = "-40%",
                price = "4.399₺/Ay",
                originalPrice = "7399,99₺",
                isMonthly = true
            )

            // Subscribe Button
            GradientButton(
                text = "Subscribe now",
                onClick = { /* Handle subscribe */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )

            // Review Card
            ReviewCard(
                rating = 5,
                review = "Kullandığım en iyi görüntülü ve sesli sohbet uygulaması!",
                author = "Mert Saygın",
                date = "Mayıs 21"
            )

            // Footer
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Terms of Use",
                    color = Color.Gray,
                    modifier = Modifier.clickable { /* Handle terms */ }
                )
                Text(
                    text = " | ",
                    color = Color.Gray
                )
                Text(
                    text = "Privacy Policy",
                    color = Color.Gray,
                    modifier = Modifier.clickable { /* Handle privacy */ }
                )
            }
        }
    }
}

@Composable
fun PremiumPlanCard(
    coins: String,
    period: String,
    discount: String,
    price: String,
    originalPrice: String,
    isPopular: Boolean = false,
    isMonthly: Boolean = false
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF00FF00),
                        Color(0xFF9C27B0)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2A2A2A)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            if (isPopular) {
                Text(
                    text = "EN POPÜLER",
                    color = Color(0xFF9C27B0),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.align(Alignment.End)
                )
            }
            if (isMonthly) {
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
                        text = coins,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Text(
                    text = discount,
                    color = Color(0xFF00FF00),
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Text(
                text = period,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
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
                    text = originalPrice,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyMedium,
                    textDecoration = TextDecoration.LineThrough,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = price,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
private fun FeatureItem(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Composable
private fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF00FF00),
                            Color(0xFF9C27B0)
                        )
                    ),
                    shape = RoundedCornerShape(28.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
private fun ReviewCard(
    rating: Int,
    review: String,
    author: String,
    date: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2A2A2A)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "OMG",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Row(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                repeat(rating) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            Text(
                text = review,
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = author,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = date,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview
@Composable
fun SDUIScreenPreviews() {
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
    SDUIScreens(screenConfig)
}
private val features = listOf(
    "Free Join to Live Influencer Streams",
    "Limitless Messages",
    "3 Free Access to Premium Streams Per Week",
    "3 Free Access to Private Rooms Per Week",
    "Boho Club Membership Tag"
)