package com.example.final_assessment_kotlin.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.final_assessment_kotlin.R
import com.example.final_assessment_kotlin.ui.theme.controller.DishController
import com.example.final_assessment_kotlin.ui.theme.model.Payload
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun DishScreen(navController: NavController) {
    var dishResponse : List<Payload> by remember {
        mutableStateOf(listOf())
    }

    val productController = ApiUtility.apiUtilityFun().create(DishController::class.java)

    LaunchedEffect(Unit) {
        val response = withContext(Dispatchers.IO){
            productController.getDishes()
        }
        Log.d("API data response", response.toString())
        if(response.isSuccessful){
            response.body()?.let{
                dishResponse = it.payload
            }
        }
    }

    LazyColumn {
        items(dishResponse){ dish ->
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
                .border(color = Color.Gray, width = 1.dp, shape = RoundedCornerShape(10.dp))

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Spacer(modifier = Modifier.width(10.dp))
                    AsyncImage(
                        model = dish.imageUrl,
                        placeholder = painterResource(id = R.drawable.download),
                        error = painterResource(id = R.drawable.download),
                        contentDescription = " product logo",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            text = dish.name ?: "",
                            modifier = Modifier.padding(10.dp),
                            fontSize = 13.sp, maxLines = 1)
                        Text(text = dish.category ?: "",
                            modifier = Modifier.padding(10.dp),
                            fontSize = 10.sp, maxLines = 2)
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                }
            }
        }
    }
}


