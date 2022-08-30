package com.pedro_bruno.pokedexwithcompose.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Preview
@Composable
fun PokedexAppBar(
    title: String = "Pokédex",
    navController: NavController = NavController(context = LocalContext.current),
    icon: ImageVector = Icons.Default.Favorite,
    popStack: Boolean = false,
    showTitle: Boolean = true,
    backgroundColor: Color = Color(0xFF48D0B0),
    onBackClicked: () -> Unit = {},
    onFavoriteClicked: () -> Unit = {}
) {
    TopAppBar(
        backgroundColor = backgroundColor,
        title = {
            Row(modifier = Modifier.padding(4.dp)) {
                if (popStack) {
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = "Close icon",
                        modifier = Modifier.clickable {
                            onBackClicked.invoke()
                        }
                    )
                } else {
                    Box {}
                }

                if (showTitle) {
                    Text(text = title)
                } else {
                    Box {}
                }
            }
        },
        actions = {
            IconButton(onClick = {
                onFavoriteClicked.invoke()
            }) {
                Icon(imageVector = icon, contentDescription = "favorite")
            }
        },
        elevation = 0.dp
    )
}