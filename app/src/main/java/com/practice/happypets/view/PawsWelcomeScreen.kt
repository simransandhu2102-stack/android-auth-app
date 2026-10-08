package com.practice.happypets.view

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.practice.happypets.R
import com.practice.happypets.ui.theme.BaseTheme
import com.practice.happypets.ui.theme.Typography
import com.practice.happypets.ui.theme.grey_bg

@Composable
fun WelcomeScreen(onNavigateToLogin: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .statusBarsPadding()
            .background(grey_bg)
    ) {
        ImageNextToText()
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
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                onClick = { onNavigateToLogin() }
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
fun ImageNextToText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.padding(5.dp))
        Image(
            painter = painterResource(R.drawable.pet_splash_top_paws_img),
            contentDescription = "splash screen image",
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            style = Typography.bodyLarge,
            text = stringResource(R.string.happy_pet),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWelcomeScreen() {
    BaseTheme(dynamicColor = false) {
        WelcomeScreen(
            onNavigateToLogin = {}
        )
    }
}
