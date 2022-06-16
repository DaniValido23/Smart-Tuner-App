package com.example.firstappmobilecompose

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    val navController= rememberNavController()
    Scaffold(
        topBar = { TopAppBar() },
        bottomBar = { BottomNavigationBar(navController)}
    ) {
        Navigation(navController = navController)
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
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
            PageTuner()
        }
    }
}


//TopAppBar---->Smart Tuner
@Composable
fun TopAppBar() {
    TopAppBar(
        title = { Text(text = "Smart Tuner", color = Color.Black) },
        backgroundColor = colorResource(id = R.color.Secondary_Color)
    )
}

//BottomAppBar----->Smart Tuner
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
/*
@Preview
@Composable
fun BottomNavigationPreview(){
    BottomNavigationBar()
}

@Preview
@Composable
fun TopAppBarPreview(){
    TopAppBar()
}*/



//Main page
@Composable
fun PagePrincipal() {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
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
                    modifier = Modifier.absolutePadding(0.dp, 10.dp, 0.dp, 30.dp)
                )

                val activity =(LocalContext.current as? Activity)
                ExtendedFloatingActionButton(
                    backgroundColor = colorResource(id = R.color.Red_Exit),
                    onClick = { activity?.finish()},
                    text = { (Text(text = "Exit", color = Color.White)) },
                )
            }

        }
    }
}









//Bottom Bar Navigation
sealed class NavigationItem(var route:String,var icon:Int,var title:String){
    object Home : NavigationItem("home",R.drawable.home,"HOME")
    object Hearing : NavigationItem("hearing",R.drawable.hearing,"HEARING")
    object Tuning : NavigationItem("tuning",R.drawable.guitar,"TUNER")
}



