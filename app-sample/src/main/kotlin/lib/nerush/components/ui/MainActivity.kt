package lib.nerush.components.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import lib.nerush.components.ui.details.DetailsScreen
import lib.nerush.components.ui.main.MainScreen
import lib.nerush.components.ui.main.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

private val ROUTE_MAIN = "main"
private val ROUTE_DETAILS = "details/{id}"

@Composable
private fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE_MAIN) {
        composable(route = ROUTE_MAIN) {
            MainScreen(openBook = { id -> navController.navigate("details/$id") })
        }
        composable(route = ROUTE_DETAILS) {
            DetailsScreen()
        }
    }
}