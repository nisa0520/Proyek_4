package com.example.hanyarunrun.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hanyarunrun.R

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo atau Gambar Header
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Judul
        Text(
            text = "Selamat Datang di HanyaRunRun!",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Deskripsi Singkat
        Text(
            text = "Aplikasi ini membantu Anda mengelola data dengan mudah. Mulai dengan melihat daftar data atau menambah data baru!",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Menu Cepat (Navigasi)
        QuickMenuItem("Lihat Data", Icons.Default.List) {}
        QuickMenuItem("Profil Saya", Icons.Default.Person) {}
        QuickMenuItem("Tentang Aplikasi", Icons.Default.Info) {}
    }
}

@Composable
fun QuickMenuItem(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = title, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = title)
        }
    }
}