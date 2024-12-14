package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
//                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                Surface(color = MaterialTheme.colorScheme.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        // Outer Card
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(10.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(25.dp)),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                CreateImageProfile()
                TopDivider()
                CreateInfo()
                PortfolioButton()
                Content()
            }

        }

    }
}

@Composable
fun Content() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0f)) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))

        }
    }

}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn() {
        items(data) { item ->
            Text(item)
        }
    }
}

@Composable
private fun PortfolioButton() {
    Button(
        modifier = Modifier,
        enabled = true,
        onClick = {
            Log.d("Clicked", "CreateBizCard: Clicked")

        },
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
    ) {
        Text(text = "Portfolio")

    }
}

@Composable
private fun TopDivider() {
    HorizontalDivider(
        modifier = Modifier.padding(0.dp, 6.dp),
        thickness = 1.dp
    )
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Haris S.",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp)
        )

        Text(
            text = "Practice makes perfect.",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.bodySmall
        )
    }

}


@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape, border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 20.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image", modifier = Modifier.size(20.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        CreateBizCard()

    }
}