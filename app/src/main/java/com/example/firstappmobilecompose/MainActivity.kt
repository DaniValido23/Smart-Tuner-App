package com.example.firstappmobilecompose

import android.graphics.drawable.Icon
import android.icu.text.CaseMap
import android.media.ThumbnailUtils
import android.os.Bundle
import android.provider.MediaStore
import android.service.controls.templates.ThumbnailTemplate
import android.text.style.BackgroundColorSpan
import android.view.View
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstappmobilecompose.ui.theme.FirstAppMobileComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ViewPagePrincipal()
            //ViewPageEarTraining()
            ViewPageTuner()
        }
    }
}

//Scaffold
@Preview
@Composable
fun ViewPagePrincipal() {
    Scaffold(
        topBar = { Toolbar() },
        content = { PagePrincipal() },
    )
}

@Preview
@Composable
fun ViewPageEarTraining() {
    Scaffold(
        topBar = { Toolbar() },
        content = { PageEarTraining() },
        bottomBar = { Bottombar() }
    )
}

@Preview
@Composable
fun ViewPageTuner(){
    Scaffold(
        topBar = { Toolbar() },
        content = { PageTuner()},
        bottomBar = { Bottombar() }
    )
}


//TopAppBar---->Smart Tuner
@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "Smart Tuner", color = Color.Black) },
        backgroundColor = colorResource(id = R.color.Secondary_Color)
    )
}

@Composable
fun Bottombar() {
    TopAppBar(
        title = {
            Text(
                text = "Navigation-Bar",
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        backgroundColor = colorResource(id = R.color.purple_200)
    )
}

//Main page
@Composable
fun PagePrincipal() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.MainBlue))
    ) {

        item {
            Text(
                text = "Smart Tuner",
                fontSize = 40.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(0.dp, 25.dp, 0.dp, 30.dp),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .height(400.dp),
                painter = painterResource(id = R.drawable.img_mobile),
                contentDescription = "Smart Tuner"
            )

            Text(
                text = "Hi, Daniel",
                fontSize = 25.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(0.dp, 80.dp, 0.dp, 20.dp),
                textAlign = TextAlign.Center,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ExtendedFloatingActionButton(
                    backgroundColor = colorResource(id = R.color.Blue_Buttom),
                    onClick = { /*...*/ },
                    text = { (Text(text = "Go Tune!", color = Color.White)) },
                    modifier = Modifier.absolutePadding(0.dp, 10.dp, 0.dp, 100.dp)
                )
            }
            ButtonExit()
        }
    }
}

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

//Vista Afinador
@Preview
@Composable
fun PageTuner() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Background_color_for_black))
    ) {
        item {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .height(400.dp),
                painter = painterResource(id = R.drawable.top_electric_guitar),
                contentDescription = "Smart Tuner"
            )
            ButtonChangeTopGuitar()
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
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExtendedFloatingActionButton(
            backgroundColor = colorResource(id = R.color.Red_Exit),
            onClick = { /*...*/ },
            text = { (Text(text = "Exit", color = Color.White)) },
        )
    }
}

@Composable
fun ButtonChangeTopGuitar() {
    Column(
        modifier = Modifier.
        fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Change Top Guitar")
        }
    }
}


/////////////////////////////////////////////////////////////



//Composable Prueba git

//Prueba numero 2 despues de reiniciar el equipo (El emulador ya funciona borrando el archivo .lock)

//Smart Tuner