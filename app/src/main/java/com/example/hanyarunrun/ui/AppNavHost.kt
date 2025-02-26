package com.example.hanyarunrun.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.hanyarunrun.ui.screen.home.HomeScreen
import com.example.hanyarunrun.ui.screen.profile.ProfileScreen
import com.example.hanyarunrun.ui.splash.SplashScreen
import com.example.hanyarunrun.viewmodel.DataViewModel

@Composable
fun AppNavHost(viewModel: DataViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val currentBackStack = navController.currentBackStackEntryAsState()
            if (currentBackStack.value?.destination?.route != "splash") {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "splash",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("splash") { SplashScreen(navController) }
            composable("home") { HomeScreen() }
            composable("list") { DataListScreen(navController, viewModel) }
            composable("profile") { ProfileScreen() }
            composable("form") { DataEntryScreen(navController, viewModel) }
            composable(
                route = "edit/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("id") ?: 0
                EditScreen(navController, viewModel, dataId = id)
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("home", Icons.Default.Home, "Home"),
        BottomNavItem("list", Icons.Default.List, "Data List"),
        BottomNavItem("profile", Icons.Default.Person, "Profile")
    )
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: "home"

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xFF3AAFA9) // Warna latar navbar
    ) {
        items.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    if (selected) {
                        // Icon + Text untuk item yang dipilih
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(45)
                                )
                                .padding(horizontal = 15.dp, vertical = 5.dp)
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                tint = Color.Black
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = item.label,
                                color = Color.Black
                            )
                        }
                    } else {
                        // Hanya icon untuk item yang tidak dipilih
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            tint = Color.White.copy(alpha = 0.7f)
                        )
                    }
                }
            )
        }
    }
}

data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)
