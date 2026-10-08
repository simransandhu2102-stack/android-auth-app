package com.practice.happypets.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import com.practice.happypets.ui.theme.grey_bg

@Composable
fun PawsMainScreen(
    onNavigateToLoginForm: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(10.dp)
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
                painter = painterResource(R.drawable.paws_login_img),
                contentDescription = "login screen image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(380.dp)
            )
            Text(
                style = MaterialTheme.typography.headlineLarge,
                text = stringResource(R.string.discover_a_world_and_complaint_at_happy_pet)
            )
            Spacer(
                modifier = Modifier
                    .padding(10.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.Black
                ),
                onClick = { onNavigateToLoginForm() }
            ) {
                Text(
                    text = stringResource(R.string.login),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.padding(5.dp))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = grey_bg,
                    contentColor = Color.Black
                ),
                onClick = { onNavigateToSignUp() }
            ) {
                Text(
                    text = stringResource(R.string.signup),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewPawsMainScreen() {
    BaseTheme(dynamicColor = false) {
        PawsMainScreen(
            onNavigateToLoginForm = {},
            onNavigateToSignUp = {}
        )
    }
}
