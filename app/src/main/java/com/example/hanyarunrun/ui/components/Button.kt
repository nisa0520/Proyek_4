//package com.example.hanyarunrun.ui.components
//
//import android.content.res.Configuration.UI_MODE_NIGHT_YES
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScope
//import androidx.compose.foundation.layout.defaultMinSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.ProvideTextStyle
//import androidx.compose.material3.Text
//import androidx.compose.material3.ripple
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.graphics.Shape
//import androidx.compose.ui.semantics.Role
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.hanyarunrun.ui.theme.HanyarunrunTheme
//import com.example.hanyarunrun.ui.theme.PrimaryColor
//import com.example.hanyarunrun.ui.theme.PrimaryVariant
//import com.example.hanyarunrun.ui.theme.SecondaryColor
//import com.example.hanyarunrun.ui.theme.BackgroundColor
//import com.example.hanyarunrun.ui.theme.Typography
//
//@Composable
//fun HanyarunrunButton(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
//    shape: Shape = ButtonShape,
//    border: BorderStroke? = null,
//    backgroundGradient: List<Color> = listOf(PrimaryColor, PrimaryVariant),
//    disabledBackgroundGradient: List<Color> = listOf(SecondaryColor, BackgroundColor),
//    contentColor: Color = Color.White,
//    disabledContentColor: Color = Color.Gray,
//    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
//    content: @Composable RowScope.() -> Unit
//) {
//    HanyarunrunSurface(
//        shape = shape,
//        color = Color.Transparent,
//        contentColor = if (enabled) contentColor else disabledContentColor,
//        border = border,
//        modifier = modifier
//            .clip(shape)
//            .background(
//                Brush.horizontalGradient(
//                    colors = if (enabled) backgroundGradient else disabledBackgroundGradient
//                )
//            )
//            .clickable(
//                onClick = onClick,
//                enabled = enabled,
//                role = Role.Button,
//                interactionSource = interactionSource,
//                indication = null
//            )
//    ) {
//        ProvideTextStyle(
//            value = Typography.labelLarge
//        ) {
//            Row(
//                Modifier
//                    .defaultMinSize(
//                        minWidth = ButtonDefaults.MinWidth,
//                        minHeight = ButtonDefaults.MinHeight
//                    )
//                    .padding(contentPadding),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically,
//                content = content
//            )
//        }
//    }
//}
//
//private val ButtonShape = RoundedCornerShape(percent = 50)
//
//@Preview("default", "round")
//@Preview("dark theme", "round", uiMode = UI_MODE_NIGHT_YES)
//@Preview("large font", "round", fontScale = 2f)
//@Composable
//private fun ButtonPreview() {
//    HanyarunrunTheme {
//        HanyarunrunButton(onClick = {}) {
//            Text(text = "Demo")
//        }
//    }
//}
//
//@Preview("default", "rectangle")
//@Preview("dark theme", "rectangle", uiMode = UI_MODE_NIGHT_YES)
//@Preview("large font", "rectangle", fontScale = 2f)
//@Composable
//private fun RectangleButtonPreview() {
//    HanyarunrunTheme {
//        HanyarunrunButton(
//            onClick = {}, shape = RectangleShape
//        ) {
//            Text(text = "Nyoba")
//        }
//    }
//}
