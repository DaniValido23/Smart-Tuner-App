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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firstappmobilecompose.ui.theme.FirstAppMobileComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewPagePrincipal()
            //ViewPageTuner()
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route){
        composable(NavigationItem.Home.route){
            PagePrincipal()
        }
        composable(NavigationItem.Hearing.route){
            PageEarTraining()
        }
        composable(NavigationItem.Tuning.route){
            NavigationItem.Tuning
        }
    }
}

//Scaffold
@Preview
@Composable
fun ViewPagePrincipal() {
    val navController= rememberNavController()
    Scaffold(
        topBar = { Toolbar() },
        content = { PagePrincipal() },
        bottomBar = { BottomNavigationBar(navController)}
    )
    Navigation(navController=navController)
}

@Preview
@Composable
fun ViewPageEarTraining() {
    Scaffold(
        topBar = { Toolbar() },
        content = { PageEarTraining() },
    )
}

@Preview
@Composable
fun ViewPageTuner(){
    Scaffold(
        topBar = { Toolbar() },
        content = { PageTuner()},
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
                    modifier = Modifier.absolutePadding(0.dp, 10.dp, 0.dp, 80.dp)
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
@Composable
fun PageTuner() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.MainBlue))
    ) {
        item {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .height(400.dp),
                painter = painterResource(id=R.drawable.guitarra),
                contentDescription = "Smart Tuner"
            )
            Spacer(modifier = Modifier.height(80.dp))
            ButtonChangeTopGuitar()
            Spacer(modifier = Modifier.height(180.dp))
            CustomLinearProgressBar()
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

@Composable
private fun CustomLinearProgressBar(){
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp),
            backgroundColor = Color.LightGray,
            color = Color.Red //progress color
        )
    }
}


//Bottom Bar Navigation
sealed class NavigationItem(var route:String,var icon:Int,var title:String){
    object Home : NavigationItem("home",R.drawable.home,"HOME")
    object Hearing : NavigationItem("hearing",R.drawable.hearing,"HEARING")
    object Tuning : NavigationItem("tuning",R.drawable.guitar,"TUNER")
}

@Composable

fun BottomNavigationBar(navController:NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Tuning,
        NavigationItem.Hearing,

    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.Secondary_Color),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black,
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}


/////////////////////////////////////////////////////////////



//Composable Prueba git

//Prueba numero 2 despues de reiniciar el equipo (El emulador ya funciona borrando el archivo .lock)

//Smart Tuner