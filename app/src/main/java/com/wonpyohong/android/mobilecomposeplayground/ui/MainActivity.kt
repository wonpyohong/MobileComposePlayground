package com.wonpyohong.android.mobilecomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wonpyohong.android.mobilecomposeplayground.ui.Conversation
import com.wonpyohong.android.mobilecomposeplayground.ui.SecondScreen
import com.wonpyohong.android.mobilecomposeplayground.ui.theme.MobileComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileComposePlaygroundTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "main") {
                        composable("main") { MainScreen(navController) }
                        composable("conversation") { Conversation(SampleData.conversationSample) }
                        composable("secondScreen") { SecondScreen() }
                    }
                }
            }
        }
    }

    @Composable
    private fun MainScreen(navController: NavHostController) {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "화면 선택")
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("conversation") },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Conversation")
            }
            Button(
                onClick = { navController.navigate("secondScreen") },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "단순 텍스트 화면")
            }
        }
    }
}