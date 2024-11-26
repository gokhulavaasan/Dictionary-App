package com.gvapps.dictionaryapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.gvapps.dictionaryapp.R.string.search_a_word
import com.gvapps.dictionaryapp.ui.theme.DictionaryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	private val viewModel by viewModels<MainViewModel>()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			DictionaryAppTheme {
				BarColor()
				val mainState by viewModel.mainState.collectAsState()
				Surface(
					modifier = Modifier
						.fillMaxSize()
						.background(MaterialTheme.colorScheme.background)
				) {
					Scaffold(
						modifier = Modifier
							.fillMaxSize()
							.statusBarsPadding()
							.background(MaterialTheme.colorScheme.background),
						topBar = {
							OutlinedTextField(
								modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
								value = mainState.searchWord,
								onValueChange = {
									viewModel.onEvent(MainUiEvents.OnSearchWordChange(it))
								},
								trailingIcon = {
									Icon(
										imageVector = Icons.Default.Search,
										contentDescription = getString(search_a_word),
										tint = MaterialTheme.colorScheme.primary,
										modifier = Modifier
											.size(30.dp)
											.clickable {
												viewModel.onEvent(MainUiEvents.OnSearchClick)
											}
									)
								},
								label = {
									Text(
										text = getString(search_a_word),
										fontSize = 15.sp,
										modifier = Modifier.alpha(0.7f)
									)
								},
								textStyle = TextStyle(
									color = MaterialTheme.colorScheme.onBackground,
									fontSize = 19.sp
								)
							)
						}
					) { paddingValues ->
						Box(
							modifier = Modifier
								.fillMaxSize()
								.padding(top = paddingValues.calculateTopPadding())
						) {
							MainScreen(mainState)
						}

					}
				}

			}
		}
	}
}

@Composable
private fun BarColor() {
	val systemUiController = rememberSystemUiController()
	val color = MaterialTheme.colorScheme.background
	LaunchedEffect(color) {
		systemUiController.setSystemBarsColor(color)
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	DictionaryAppTheme {
//		Greeting("Android")
	}
}