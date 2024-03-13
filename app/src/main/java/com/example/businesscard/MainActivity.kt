package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Logo(name = getString(R.string.full_name), title = getString(R.string.title))
                    ContactInfo(phone = getString(R.string.phone_number), social = getString(R.string.social_media) , email = getString(R.string.email))
                }
            }
        }
    }
}

@Composable
fun LogoText(name: String, title: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(4.dp)) {
        Text(
            text = name,
            color = Color.Black,
            fontSize = 50.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            color = Color.Black,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(1.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}
@Composable
fun Logo(name: String, title: String, modifier: Modifier = Modifier) {
    val icon = painterResource(R.drawable.ic_launcher_foreground)
    Column {
        Image(
            painter = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(Color.Green),
            modifier = Modifier
                .height(400.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 50.dp)
                .clip(CircleShape)
        )
        LogoText(
            name = name,
            title = title,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
fun ContactInfo(phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(10.dp)) {
        Text(
            text = phone,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = social,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = email,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Logo(name = stringResource(R.string.full_name), title = stringResource(R.string.title))
            ContactInfo(phone = stringResource(R.string.phone_number), social = stringResource(R.string.social_media), email = stringResource(R.string.email)
            )
        }

    }
}