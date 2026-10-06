package com.practice.createandlogin.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.createandlogin.R
import com.practice.createandlogin.ui.theme.Typography

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CreateLoginUI() }
    }
}

@Composable
fun CreateLoginUI() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ImageNextToText(
            img = R.drawable.pet_splash_top_paws_img,
            str = stringResource(R.string.happy_pet)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.pet_splash_img),
                contentDescription = "splash screen image"
            )
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
            style = Typography.labelSmall,
            text = str,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCreateLoginUI() {
    CreateLoginUI()
}