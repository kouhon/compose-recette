package net.hon.kou.composerecette

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.hon.kou.composerecette.ui.theme.ComposeRecetteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRecetteTheme {
                NonCheckedSwitch()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeRecetteTheme {
        NonCheckedSwitch()
    }
}

@Composable
fun NonCheckedSwitch() {
    Switch(
        checked = false, onCheckedChange = null
    )
}

@Composable
fun SwitchSample() {
    val checkedState = remember { mutableStateOf(true) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}

@Composable
fun BoxExample() {
    Box(Modifier.width(200.dp)) {
        Text("This text is Alignment.Center",
            modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun StyleText() {
    Column {
        Text(text = "This is a sample text", color = Color.Red)
        Text("FontSize is 24sp", fontSize = 24.sp)
        Text("Italic", fontStyle = FontStyle.Italic)
        Text("Bold", fontWeight = FontWeight.Bold)
        Text("Sanserif", fontFamily = FontFamily.SansSerif)
        Text(
            "TextAlign.Center", textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp)
        )
    }
}

@Composable
fun StringResourceText() {
    Text(stringResource(id = R.string.app_name))
}

@Composable
fun SimpleText(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun TextSample() {
    Text(text = "This is a sample text")
}

@Composable
fun ShoppingButton() {
    Button(onClick = { /*TODO*/ }) {
        Icon(
            Icons.Filled.ShoppingCart,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Buy now")
    }
}

@Composable
fun FavoriteButton() {
    Button(onClick = { /*TODO*/ }) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}

@Composable
fun ButtonPreview() {
    Button(
        onClick = { /* Do something */ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White,
            disabledContentColor = Color.LightGray
        )
    ) {
        Text(text = "Button")
    }
}

@Composable
fun BoxPropagate() {
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .defaultMinSize(200.dp, 200.dp)
                .background(Color.LightGray)
                .padding(10.dp),
            propagateMinConstraints = true
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Gray)
            )
        }
    }
}

@Composable
fun BoxMatchParent() {
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .defaultMinSize(200.dp, 200.dp)
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Gray)
            )
        }
    }
}

@Composable
fun BoxFillMaxSize() {
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .defaultMinSize(200.dp, 200.dp)
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            )
        }
    }
}

@Composable
fun BoxAlignEndBottom() {
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White),
        contentAlignment = Alignment.BottomEnd
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.LightGray)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray)
        )
    }
}

@Composable
fun BoxSample() {
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.LightGray)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray)
        )
    }
}

@Composable
fun RowWeight() {
    Row(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
    ) {
        Box(
            Modifier
                .fillMaxHeight()
                .width(50.dp)
                .background(Color.LightGray)
        )
        Box(
            Modifier
                .fillMaxHeight()
                .weight(
                    weight = 1f,
                    fill = true
                )
                .background(Color.Gray)
        )
        Box(
            Modifier
                .fillMaxHeight()
                .weight(
                    weight = 1f,
                    fill = true
                )
                .background(Color.DarkGray)
        )
    }
}

@Composable
fun RowAlign() {
    Row(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
    ) {
        Box(
            Modifier
                .size(100.dp)
                .background(Color.LightGray)
                .align(Alignment.Top)
        )
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Gray)
                .align(Alignment.CenterVertically)
        )
        Box(
            Modifier
                .size(100.dp)
                .background(Color.DarkGray)
                .align(Alignment.Bottom)
        )
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