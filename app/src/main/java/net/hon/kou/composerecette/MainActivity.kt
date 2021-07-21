package net.hon.kou.composerecette

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.hon.kou.composerecette.ui.theme.ComposeRecetteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRecetteTheme {
                ColumnSample()
            }
        }
    }
}

@Composable
fun ColumnSample() {
    Column(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
            .scrollable(
                state = rememberScrollState(),
                orientation = Orientation.Vertical
            )
    ) {
        Box(
            Modifier
                .size(100.dp)
                .background(Color.LightGray)
        )
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Gray)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeRecetteTheme {
        ColumnSample()
    }
}