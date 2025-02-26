package com.example.hanyarunrun.ui.splash

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.hanyarunrun.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashScreen(navController: NavController) {
    var visible by remember { mutableStateOf(false) }

    // Animasi masuk setelah delay
    LaunchedEffect(Unit) {
        delay(500)
        visible = true
        delay(2000)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    val bitmap = BitmapFactory.decodeResource(
        LocalContext.current.resources,
        R.drawable.data // Ganti sesuai nama file gambar kamu
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = androidx.compose.ui.graphics.Color(0xFFFFF5E1)
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(1000)) + scaleIn(animationSpec = tween(1000)),
            exit = fadeOut(animationSpec = tween(1000)) + scaleOut(animationSpec = tween(1000))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Welcome To My App",
                    fontSize = 24.sp,
                    color = androidx.compose.ui.graphics.Color(0xFF000000),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
