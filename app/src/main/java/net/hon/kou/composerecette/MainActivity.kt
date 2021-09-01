package net.hon.kou.composerecette

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import net.hon.kou.composerecette.ui.theme.ComposeRecetteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRecetteTheme {
                MultiConstraintLayoutSample3()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeRecetteTheme {
        MultiConstraintLayoutSample3()
    }
}

@Composable
fun MultiConstraintLayoutSample3() {
    ConstraintLayout(modifier = Modifier) {
        val (iconRef, textRef) = createRefs()
        Icon(
            Icons.Default.Face,
            contentDescription = "",
            modifier = Modifier.constrainAs(iconRef) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }
        )
        Text(
            text = "Hello",
            modifier = Modifier.constrainAs(textRef) {
                linkTo(
                    start = iconRef.end,
                    top = iconRef.bottom,
                    end = parent.end,
                    bottom = parent.bottom,
                    startMargin = 16.dp,
                    topMargin = 0.dp,
                    endMargin = 0.dp,
                    bottomMargin = 0.dp
                )
            }
        )
    }
}

@Composable
fun MultiConstraintLayoutSample2() {
    ConstraintLayout(modifier = Modifier) {
        val (iconRef, textRef) = createRefs()
        Icon(
            Icons.Default.Face,
            contentDescription = "",
            modifier = Modifier.constrainAs(iconRef) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }
        )
        Text(
            text = "Hello",
            modifier = Modifier.constrainAs(textRef) {
                linkTo(
                    start = iconRef.end,
                    end = parent.end,
                    startMargin = 16.dp,
                    endMargin = 0.dp
                )
            }
        )
    }
}

@Composable
fun MultiConstraintLayoutSample1() {
    ConstraintLayout(modifier = Modifier) {
        val (iconRef, textRef) = createRefs()
        Icon(
            Icons.Default.Face,
            contentDescription = "",
            modifier = Modifier.constrainAs(iconRef) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }
        )
        Text(
            text = "Hello",
            modifier = Modifier.constrainAs(textRef) {
                linkTo(
                    top = iconRef.bottom,
                    bottom = parent.bottom,
                    topMargin = 0.dp,
                    bottomMargin = 0.dp
                )
            }
        )
    }
}

@Composable
fun ConstraintLayoutMargin() {
    ConstraintLayout(modifier = Modifier) {
        val textRef = createRef()
        Text(
            text = "Hello",
            modifier = Modifier.constrainAs(textRef) {
                start.linkTo(parent.start, 24.dp)
                top.linkTo(parent.top, 16.dp)
            }
        )
    }
}

@Composable
fun MyLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (iconRef, textRef) = createRefs()
        Icon(
            Icons.Default.Face,
            contentDescription = "",
            modifier = Modifier.constrainAs(iconRef) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }
        )
        Text(
            text = "Hello",
            modifier = Modifier.constrainAs(textRef) {
                start.linkTo(iconRef.end)
                top.linkTo(iconRef.bottom)
            }
        )
    }
}

data class User(
    val firstName: String,
    val familyName: String
)

//@Preview("PreviewParameter for UserItem", showBackground = true)
//@Composable
//fun UserItem(@PreviewParameter(provider = FakeUserProvider::class, limit = 2) user: User) {
//    Row {
//        Text(text = user.familyName)
//        Spacer(Modifier.size(8.dp))
//        Text(text = user.firstName)
//    }
//}

@Composable
fun ModifierOrder() {
    Box(
        modifier = Modifier
            .size(100.dp, 100.dp)
            .background(Color.Gray)
            .padding(25.dp)
            .clickable { }
            .padding(25.dp)
    )
}

@Composable
fun ModifierScrollable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
//            .scrollable(
//                orientation = Orientation.Vertical,
//                state = rememberScrollState()
//            )
            .verticalScroll(state = rememberScrollState())
    ) {
        repeat(10) {
            Box(
                Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Text(
                    text = "Column $it",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp)
                )
            }
        }
    }
}

@Composable
fun ModifierClickableDisabled() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(50.dp)
            .background(Color.Gray)
            .clickable(enabled = false, onClick = {})
    )
}

@Composable
fun ModifierClickable() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(50.dp)
            .background(Color.Gray)
            .clickable { }
    )
}

@Composable
fun ModifierPadding() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .size(300.dp)
            .padding(10.dp)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.White)
        )
    }
}

@Composable
fun ModifierBackground() {
    Box(
        modifier = Modifier
            .background(Color.DarkGray, CircleShape)
            .size(300.dp)
    )
}

@Composable
fun ModifierFillMaxSize() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    )
}

@Composable
fun ModifierSize() {
    Column {
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .size(300.dp)
        )
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .size(100.dp, 100.dp)
        )
    }
}

@Composable
fun SpacerWeight() {
    Row(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
    ) {
        Box(
            Modifier
                .height(100.dp)
                .weight(weight = 1f, fill = true)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.width(50.dp))
        Box(
            Modifier
                .height(100.dp)
                .weight(weight = 2f, fill = true)
                .background(Color.Gray)
        )
    }
}

@Composable
fun SpacerSample() {
    Column(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
    ) {
        Box(
            Modifier
                .size(100.dp)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.size(50.dp))
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Gray)
        )
    }
}

sealed class Item(var dist: String, var icon: ImageVector) {
    object Home : Item("Home", Icons.Filled.Home)
    object Email : Item("Email", Icons.Filled.Email)
    object Stars : Item("Stars", Icons.Filled.Star)
    object Lists : Item("Lists", Icons.Filled.List)
}
@Composable
fun MultipleItemsBottomNavigation() {
    var selectedItem = remember { mutableStateOf(0) }
    val items = listOf(Item.Home, Item.Email, Item.Stars, Item.Lists)
    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.dist) },
                label = { Text(item.dist) },
                alwaysShowLabel = false,
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index }
            )
        }
    }
}

@Composable
fun SimpleBottomNavigation() {
    var selectedItem = remember { mutableStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")
    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index }
            )
        }
    }
}

@Composable
fun TopAppBarSample() {
    TopAppBar(
        title = { Text("My TopAppBar") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Menu, contentDescription = "Open drawer")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit text")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Share, contentDescription = "Share text")
            }
        }
    )
}

@Composable
fun CenterProgressIndicator() {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun SimpleLinearProgress() {
    LinearProgressIndicator()
}

@Composable
fun SimpleProgress() {
    CircularProgressIndicator()
}

@Composable
fun IconToggleButtonSample() {
    var checked = remember { mutableStateOf(false) }
    IconToggleButton(
        checked = checked.value,
        onCheckedChange = {
            checked.value = it
        }
    ) {
        val tint = animateColorAsState(
            if (checked.value) {
                Color(0xFFEC407A)
            } else {
                Color(0xFFB0BEC5)
            }
        )
        Icon(Icons.Filled.Favorite, contentDescription = "お気に入り", tint = tint.value)
    }
}

@Composable
fun IconButtonSample() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.Favorite, contentDescription = "お気に入り")
    }
}

@Composable
fun SimpleFab() {
    Row {
        FloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.Favorite, contentDescription = "お気に入り")
        }
        FloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.Add, contentDescription = "追加")
        }
        FloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.Edit, contentDescription = "変更")
        }
        FloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.Share, contentDescription = "共有")
        }
    }
}

@Composable
fun SimpleCardPreview() {
    Card(modifier = Modifier
        .padding(16.dp)
        .wrapContentSize()
    ) {
        CardContent()
    }
}

@Composable
fun CardContent() {
    Column {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "カード画像",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 1.7731f),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(16.dp)) {
            Text(
                "Title goes here",
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                "Secondary line text techbooster techbooster",
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
fun CardSample() {
    Card {
        Text("Card contents is here")
    }
}

@Composable
fun ConformAlertDialog() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { },
            title = {
                Text(text = "位置情報を使いますか？")
            },
            text = {
                Text("GPSから位置情報を取得するとタイムラインを自動記録できます。")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("使う")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("キャンセル")
                }
            }
        )
    }
}

@Composable
fun SimpleAlertDialog() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Network disconnected")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = null
        )
    }
}


@Composable
fun SwitchWithText() {
    Row(
        Modifier
            .width(320.dp)
            .padding(horizontal = 16.dp)) {
        Text(
            text = "Jetpack Compose Switch",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp),
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(Modifier.weight(1f))
        val checkedState = remember { mutableStateOf(true) }
        Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun ColoredSwitch() {
    Switch(
        checked = true, onCheckedChange = null,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red
        )
    )
}

@Composable
fun DisabledSwitch() {
    Switch(
        checked = true, onCheckedChange = null,
        enabled = false
    )
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