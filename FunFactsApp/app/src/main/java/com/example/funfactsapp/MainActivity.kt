package com.example.funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfactsapp.ui.theme.FunFactsAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FunFactsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FunFactsScreen(modifier: Modifier = Modifier) {
    // List of fun facts
    val funFacts = listOf(
        "Honey never spoils! Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still perfectly edible.",
        "Octopuses have three hearts, nine brains, and blue blood!",
        "Bananas are berries, but strawberries aren’t!",
        "A day on Venus is longer than a year on Venus.",
        "You can't hum while holding your nose. Go ahead, try it!"
    )

    // Remember state to store the current fact index
    var currentFactIndex by remember { mutableStateOf(Random.nextInt(funFacts.size)) }

    // Function to get next random fact
    fun getNextFact() {
        currentFactIndex = Random.nextInt(funFacts.size)
    }

    // Display the current fact and the button to cycle to the next fact
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7FA)) // Light blue background to match the image
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Wild, dynamic styling similar to "BanG Dream!"
        Text(
            text = "Do you know?",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF1E90FF), // Dark blue color similar to "BanG Dream!"
            letterSpacing = 8.sp, // Extra letter spacing to make it more dynamic
            fontStyle = FontStyle.Italic, // Italic to give it a more wild look
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Fun Fact styled with script-like font, italicized
        Text(
            text = funFacts[currentFactIndex],
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            color = Color(0xFF34495E), // Darker color for readability
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to get next fact
        Button(onClick = { getNextFact() }) {
            Text(
                text = "Next Fact",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold, // Bold button text
                letterSpacing = 2.sp, // Add spacing for consistency
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FunFactsScreenPreview() {
    FunFactsScreen()
}
