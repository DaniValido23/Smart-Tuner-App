package com.example.firstappmobilecompose

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/*
@Preview
@Composable
fun ViewPageTuner(){
    Scaffold(
        topBar = { TopAppBar() },
        content = { PageTuner()},
    )
}*/




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

