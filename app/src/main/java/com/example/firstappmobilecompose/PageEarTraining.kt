package com.example.firstappmobilecompose

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/*@Preview
@Composable
fun ViewPageEarTraining() {
    Scaffold(
        topBar = { TopAppBar() },
        content = { PageEarTraining() },
    )
}
*/



//Vista juego de entrenamiento de oido
@Composable
fun PageEarTraining() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.MainBlue))
    ) {
        item {
            RowButtonLevel()
            RowButtonLevel()
            RowButtonLevel()
            RowButtonLevelLocked()
            Spacer(modifier = Modifier.height(70.dp))
            ButtonExit()
        }


    }
}


@Composable
fun RowButtonLevel() {
    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            ButtonLevels()
            ButtonLevels()
        }
    }
}

@Composable
fun RowButtonLevelLocked() {
    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            ButtonLevelsLocked()
            ButtonLevelsLocked()
        }
    }
}


//Botones Levels Unlocked
@Composable
fun ButtonLevels() {
    Card(elevation = 0.dp, modifier = Modifier.size(150.dp)) {
        Column(
            modifier = Modifier.background(colorResource(id = R.color.MainBlue))
        ) {
            Text(
                text = "Level",
                color = Color.White,
                modifier = Modifier.absolutePadding(42.dp, 15.dp, 0.dp, 0.dp),
                fontSize = 25.sp

            )

            Spacer(modifier = Modifier.height(10.dp))

            ExtendedFloatingActionButton(
                text = { Text(text = "GO!", color = Color.White, fontSize = 15.sp) },
                modifier = Modifier.size(150.dp, 50.dp),
                onClick = { /*TODO*/ },
                backgroundColor = colorResource(id = R.color.Blue_Buttom)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


//Botones Locked
@Composable
fun ButtonLevelsLocked() {
    Card(elevation = 0.dp, modifier = Modifier.size(150.dp)) {
        Column(
            modifier = Modifier.background(colorResource(id = R.color.MainBlue))
        ) {
            Text(
                text = "Level",
                color = Color.White,
                modifier = Modifier.absolutePadding(42.dp, 15.dp, 0.dp, 0.dp),
                fontSize = 25.sp

            )

            Spacer(modifier = Modifier.height(10.dp))

            ExtendedFloatingActionButton(
                text = { Text(text = "Locked!", color = Color.White, fontSize = 15.sp) },
                modifier = Modifier.size(150.dp, 50.dp),
                onClick = { /*TODO*/ },
                backgroundColor = colorResource(id = R.color.Red_Exit)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

//Boton de Exit
@Composable
fun ButtonExit() {
    val activity =(LocalContext.current as? Activity)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
}