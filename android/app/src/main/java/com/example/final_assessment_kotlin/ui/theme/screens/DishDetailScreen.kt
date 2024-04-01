package com.example.final_assessment_kotlin.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.final_assessment_kotlin.R
import com.example.final_assessment_kotlin.ui.theme.controller.DishController
import com.example.final_assessment_kotlin.ui.theme.model.Payload
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ProductDetailsScreen(navController: NavController, id: Int) {

    var dish : Payload by remember {
        mutableStateOf(Payload())
    }

    val productController = ApiUtility.apiUtilityFun().create(DishController::class.java)

    LaunchedEffect(Unit) {
        val response = withContext(Dispatchers.IO){
            productController.getSingleProduct(id)
        }
        Log.d("DishDetailScreen", response.toString())
        if(response.isSuccessful){
            response.body()?.let{ data ->
                dish = data.payload
                Log.d("DishDetailScreen", "$dish")

            }
        }
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        AsyncImage(
            model = dish.imageUrl,
            placeholder = painterResource(id = R.drawable.download),
            error = painterResource(id = R.drawable.download),
            contentDescription = " dish logo",
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = dish.name ?: "",
            modifier = Modifier.padding(10.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
            ), fontWeight = FontWeight.Black
        )
        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "${dish.price}" ?: "",
            modifier = Modifier.padding(10.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
            ), fontWeight = FontWeight.Black
        )

        Spacer(modifier = Modifier.width(10.dp))

        Button(onClick = {
            navController.navigate("mainScreen")
            println("Button CLicked")
        }) {
            Text(text = "Continue")
        }

    }
}

