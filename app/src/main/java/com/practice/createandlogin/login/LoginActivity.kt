package com.practice.createandlogin.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.createandlogin.R
import com.practice.createandlogin.ui.theme.CreateAndLoginTheme
import com.practice.createandlogin.ui.theme.Typography
import com.practice.createandlogin.ui.theme.grey_bg

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = android.graphics.Color.TRANSPARENT,
                darkScrim = android.graphics.Color.TRANSPARENT
            )
        )
        setContent {
            CreateAndLoginTheme(dynamicColor = false) {
                CreateLoginUI()
            }
        }
    }
}

@Composable
fun CreateLoginUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .statusBarsPadding()
            .background(grey_bg)
    ) {
        ImageNextToText(
            img = R.drawable.pet_splash_top_paws_img,
            str = stringResource(R.string.happy_pet)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.pet_splash_img),
                contentDescription = "splash screen image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(380.dp)
            )
            Text(
                style = Typography.headlineLarge,
                text = stringResource(R.string.get_started_by_finding_the_perfect_companion_for_your_family)
            )

            Spacer(
                modifier = Modifier
                    .padding(12.dp)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {}
            ) {
                Text(
                    style = Typography.bodyLarge,
                    text = stringResource(R.string.welcome),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ImageNextToText(img: Int, str: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(img),
            contentDescription = "splash screen image"
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            style = Typography.bodyLarge,
            text = str,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCreateLoginUI() {
    CreateAndLoginTheme(dynamicColor = false) {
        CreateLoginUI()
    }
}