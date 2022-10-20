package com.example.snackbardemojetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.snackbardemojetpackcompose.ui.theme.SnackBarDemoJetpackComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackbarDemo3()
        }
    }
}

@Composable
fun SnackbarDemo1() {
    Scaffold() {
        Button(onClick = {})
        {
            Text(text = "Click me!")
        }
    }
}

@Composable
fun SnackbarDemo2() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is your message",
                    actionLabel = "Do something"
                )
            }
        }) {
            Text(text = "Click me!")
        }
    }
}

@Composable
fun SnackbarDemo3() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = {
            coroutineScope.launch {
                val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is your message",
                    actionLabel = "Do something"
                )
                when (snackbarResult) {
                    SnackbarResult.Dismissed -> Log.i("snackbarResult", "SnackbarResult.Dismissed")
                    SnackbarResult.ActionPerformed -> Log.i(
                        "snackbarResult",
                        "SnackbarResult.ActionPerformed"
                    )
                }
            }
        }) {
            Text(text = "Click me!")
        }
    }
}