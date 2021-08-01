package net.hon.kou.composerecette

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                RowHorizontalSpace()
            }
        }
    }
}

@Composable
fun RowHorizontalSpace() {
    Column(
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Row(
            modifier = Modifier
                .width(300.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceAround
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
        Row(
            modifier = Modifier
                .width(300.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween
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
        Row(
            modifier = Modifier
                .width(300.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly
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
}

@Composable
fun RowSample() {
    Row(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom
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

@Composable
fun ColumnSample() {
    Column(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White),
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.LightGray)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .weight(
                    weight = 1f,
                    fill = true
                )
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.DarkGray)
                .weight(
                    weight = 1f,
                    fill = true
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeRecetteTheme {
        RowHorizontalSpace()
    }
}