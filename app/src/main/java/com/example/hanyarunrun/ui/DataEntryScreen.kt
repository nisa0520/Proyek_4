package com.example.hanyarunrun.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hanyarunrun.viewmodel.DataViewModel


@Composable
fun DataEntryScreen(navController: NavHostController, viewModel: DataViewModel) {
    val context = LocalContext.current
    var kodeProvinsi by remember { mutableStateOf("") }
    var namaProvinsi by remember { mutableStateOf("") }
    var kodeKabupatenKota by remember { mutableStateOf("") }
    var namaKabupatenKota by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }
    var satuan by remember { mutableStateOf("") }
    var tahun by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(12.dp), // Padding lebih kecil biar compact
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Input Data",
                style = MaterialTheme.typography.headlineMedium
            )

            OutlinedTextField(
                value = kodeProvinsi,
                onValueChange = { kodeProvinsi = it },
                label = { Text("Kode Provinsi") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = namaProvinsi,
                onValueChange = { namaProvinsi = it },
                label = { Text("Nama Provinsi") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = kodeKabupatenKota,
                onValueChange = { kodeKabupatenKota = it },
                label = { Text("Kode Kabupaten/Kota") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = namaKabupatenKota,
                onValueChange = { namaKabupatenKota = it },
                label = { Text("Nama Kabupaten/Kota") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = total,
                onValueChange = { total = it },
                label = { Text("Total") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = satuan,
                onValueChange = { satuan = it },
                label = { Text("Satuan") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = tahun,
                onValueChange = { tahun = it },
                label = { Text("Tahun") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    viewModel.insertData(
                        kodeProvinsi = kodeProvinsi,
                        namaProvinsi = namaProvinsi,
                        kodeKabupatenKota = kodeKabupatenKota,
                        namaKabupatenKota = namaKabupatenKota,
                        total = total,
                        satuan = satuan,
                        tahun = tahun
                    )
                    Toast.makeText(context, "Data berhasil ditambahkan!", Toast.LENGTH_SHORT).show()
                    navController.navigate("list")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                    Text("Tambah Data") // Ganti Icon jadi teks aj
            }
            // Tombol Back
            Button(
                onClick = { navController.navigate("list") },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Back")
            }
        }
    }
}
