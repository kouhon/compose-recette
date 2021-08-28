package net.hon.kou.composerecette

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class FakeUserProvider : PreviewParameterProvider<User> {
    override val values = listOf(
        User(
            firstName = "信長",
            familyName = "織田"
        ),
        User(
            firstName = "蘭丸",
            familyName = "森"
        )
    ).asSequence()
    override val count: Int
        get() = values.count()
}