package com.pedro_bruno.pokedexwithcompose.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import com.pedro_bruno.pokedexwithcompose.domain.model.StatPokemon
import com.pedro_bruno.pokedexwithcompose.utils.Mocks

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
                    Text(text = title, style = TextStyle(fontSize = 24.sp))
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

@Composable
fun SearchInput(
    hint: String = "Search Pokemon",
    modifier: Modifier,
    valueState: MutableState<String>,
    imeAction: ImeAction = ImeAction.Done,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        modifier = Modifier.then(modifier),
        label = {
            Text(
                text = hint,
                style = TextStyle(color = Color(0xFFCCCCCC), fontSize = 16.sp)
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search",
                tint = Color(0xFFCCCCCC),
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        },
        shape = RoundedCornerShape(20),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(0xFFF6F6F6),
            textColor = Color.Black,
            focusedLabelColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = Color.Black,
            placeholderColor = Color.Black,
            leadingIconColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = imeAction),
        keyboardActions = onAction
    )
}

//@Preview
@Composable
fun CardPokemon(
    pokemon: PokemonDetails = Mocks.mockPokemon,
    onClick: (String) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onClick(pokemon.id.toString()) },
        shape = RoundedCornerShape(20),
        backgroundColor = pokemon.primaryColor,
    ) {
        Row(Modifier.padding(12.dp)) {
            Column() {
                Text(
                    text = pokemon.getFormatID(),
                    style = TextStyle(color = Color.White, fontSize = 10.sp)
                )
                Text(text = pokemon.name, style = TextStyle(color = Color.White, fontSize = 16.sp))
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    for (type in pokemon.listTypes) {
                        TypePokemon(type = type)
                        Spacer(modifier = Modifier.width(20.dp))
                    }
                }
            }
            Spacer(
                modifier = Modifier.fillMaxWidth(if (pokemon.listTypes.size == 2) 0.6f else 0.7f)
            )
            Row {
                Image(
                    painter = rememberImagePainter(data = pokemon.urlImage),
                    contentDescription = "pokemon",
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                )

                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }
        }
    }

}


//@Preview
@Composable
fun TypePokemon(type: String = "Poison") {
    Card(
        shape = RoundedCornerShape(70),
        border = BorderStroke(1.dp, Color.White),
        backgroundColor = Color.White.copy(0.38f),
        modifier = Modifier
            .sizeIn(minWidth = 46.dp, minHeight = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = type, style = TextStyle(color = Color.White, fontSize = 10.sp),
            )
        }

    }


}

@Preview
@Composable
fun RowStats(stat: StatPokemon = StatPokemon("Special-defense", 0)) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stat.name, modifier = Modifier.width(150.dp), fontSize = 16.sp)
        Text(text = stat.base_stat.toString( ), modifier = Modifier.width(50.dp), fontSize = 24.sp)
        Row(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .height(10.dp)
                .border(
                    width = 0.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = Color.Transparent
                )
                .clip(
                    RoundedCornerShape(
                        topStartPercent = 50,
                        topEndPercent = 50,
                        bottomStartPercent = 50,
                        bottomEndPercent = 50
                    )
                )
                .background(Color(0xFFF6F6F6)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                contentPadding = PaddingValues(1.dp),
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(
                        ((stat.base_stat.toFloat() / 100.0).toFloat())
                    )
                    .background(if (stat.base_stat == 0) Color.Transparent else stat.backgroundColor),
                enabled = false,
                elevation = null,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    disabledBackgroundColor = Color.Transparent
                )
            ) {

            }
        }
    }
}
