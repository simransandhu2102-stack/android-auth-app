package com.practice.happypets.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.practice.happypets.R
import com.practice.happypets.ui.theme.BaseTheme
import com.practice.happypets.ui.theme.Typography
import com.practice.happypets.ui.theme.grey_bg
import com.practice.happypets.viewmodel.HappyPetsViewModel


@Composable
fun PawsLoginScreen(
    viewModel: HappyPetsViewModel,
    onNavigateToList: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(grey_bg)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            ImageNextToText()
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paws_login_girl_standing_img),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 65.dp, y = (-50).dp)
                        .fillMaxSize()

                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(45.dp)
        ) {

            Spacer(modifier = Modifier.height(285.dp))
            Text(
                text = "Login",
                fontSize = 62.sp,
                style = Typography.bodyLarge,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Please sign in to continue.",
                fontSize = 18.sp,
                style = Typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(50.dp))
            LoginField(
                emailValue = uiState.email,
                passwordValue = uiState.password,
                onEmailChange = { viewModel.onEmailChange(it) },
                onPasswordChange = { viewModel.onPasswordChange(it) }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 20.dp, end = 20.dp),
                text = "FORGET",
                fontSize = 18.sp,
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onNavigateToList() }
            ) {
                Text(
                    color = Color.Black,
                    text = "LOGIN",
                    style = Typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                style = Typography.bodyLarge
            )
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = "Sign Up",
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun LoginField(
    emailValue: String = "",
    passwordValue: String = "",
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {}
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Black,      // Line color when clicked/active
                unfocusedIndicatorColor = Color.Black,   // Line color when idle
            ),
            value = emailValue,
            onValueChange = onEmailChange,
            placeholder = {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "EMAIL",
                        style = Typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.sym_action_email),
                    contentDescription = null
                )
            }
        )

        TextField(
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Black,      // Line color when clicked/active
                unfocusedIndicatorColor = Color.Black,   // Line color when idle
            ),
            value = passwordValue,
            onValueChange = onPasswordChange,
            placeholder = {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "PASSWORD",
                        style = Typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(android.R.drawable.ic_lock_idle_lock),
                    contentDescription = null
                )
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    BaseTheme(dynamicColor = false) {
        PawsLoginScreen(
            viewModel = viewModel(),
            onNavigateToList = {}
        )
    }
}
