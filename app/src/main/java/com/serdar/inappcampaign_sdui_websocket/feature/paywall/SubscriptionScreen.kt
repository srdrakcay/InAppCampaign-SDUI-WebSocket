package com.arasana.arasana.ui.changeEmail


import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseOutBack
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay

// Örnek JSON:
/*
{
    "packages": [
        {
            "id": "basic_pack",
            "title": "Başlangıç Paketi",
            "description": "100 elmas + 10 bonus elmas",
            "price": 29.99,
            "imageUrl": "https://example.com/basic-pack.png",
            "isVisible": true
        },
        {
            "id": "premium_pack",
            "title": "Premium Paket",
            "description": "500 elmas + 100 bonus elmas + Özel Karakter",
            "price": 99.99,
            "imageUrl": "https://example.com/premium-pack.png",
            "isVisible": true
        }
    ]
}
*/
// Veri sınıfımız

// Preview için örnek veri
object SampleData {
    val samplePackages = listOf(
        DiamondPackage(
            id = "basic_pack",
            title = "Başlangıç Paketi",
            description = "100 elmas + 10 bonus elmas\nYeni başlayanlar için ideal paket!",
            price = 29.99,
            imageUrl = "https://example.com/basic-pack.png"
        ),
        DiamondPackage(
            id = "premium_pack",
            title = "Premium Paket",
            description = "500 elmas + 100 bonus elmas\nÖzel karakter ve kostüm hediye!",
            price = 99.99,
            imageUrl = "https://example.com/premium-pack.png"
        ),
        DiamondPackage(
            id = "ultimate_pack",
            title = "Ultimate Paket",
            description = "1000 elmas + 300 bonus elmas\nTüm özel içerikler dahil!",
            price = 199.99,
            imageUrl = "https://example.com/ultimate-pack.png"
        )
    )
}

data class DiamondPackage(
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    var isVisible: Boolean = true
)@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DiamondPackageCard(
    s: DiamondPackage,
    backgroundColor: Color,
    onBuyClick: () -> Unit,
    onVisibilityChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val expanded by remember { mutableStateOf(s.isVisible) }
    var isVisible by remember { mutableStateOf(false) }
    var startButtonAnimation by remember { mutableStateOf(false) }

    var buttonScale by remember { mutableStateOf(1f) }
    val buttonAnimatedScale by animateFloatAsState(
        targetValue = buttonScale,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )

    val buttonOffset by animateFloatAsState(
        targetValue = if (startButtonAnimation) 1f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 300),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        delay(4000)
        isVisible = true
        delay(1000)
        startButtonAnimation = true
        delay(9000)
        isVisible = false
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(
            initialAlpha = 0f,
            animationSpec = tween(durationMillis = 1000)
        ) + expandVertically(
            animationSpec = tween(durationMillis = 1000, easing = EaseOutBack)
        ),
        exit = fadeOut(
            targetAlpha = 0f,
            animationSpec = tween(durationMillis = 1000)
        ) + shrinkVertically(
            animationSpec = tween(durationMillis = 1000, easing = EaseOutBack)
        ) + slideOutVertically(
            targetOffsetY = { -it },
            animationSpec = tween(durationMillis = 100000, easing = EaseOutBack)
        )
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = s.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                AnimatedVisibility(
                    visible = expanded,
                    enter = fadeIn(initialAlpha = 0.3f) + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .background(
                                    MaterialTheme.colorScheme.surfaceVariant,
                                    shape = RoundedCornerShape(8.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Paket Görseli")
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = s.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "${s.price} TL",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {
                                buttonScale = 0.8f
                                onBuyClick()
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .scale(buttonAnimatedScale)
                                .offset(x = if (startButtonAnimation) (buttonOffset * 4).dp else 0.dp)
                                .pointerInteropFilter { false },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                "Satın Al",
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(buttonScale) {
        if (buttonScale < 1f) {
            delay(100)
            buttonScale = 1f
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiamondPackageCardPreview() {
    MaterialTheme {
        val context= LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            DiamondPackageCard(
                s = SampleData.samplePackages[0],
                backgroundColor = Color(0xFFE3F2FD),
                onBuyClick = {
                    Toast.makeText(context, "Satın Alındı", Toast.LENGTH_SHORT).show()
                },
                onVisibilityChange = { }
            )
        }

    }
}


