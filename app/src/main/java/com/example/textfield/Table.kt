package com.example.textfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class Table {
    companion object {


        @Composable
        @OptIn(ExperimentalFoundationApi::class)
        fun CreateTable(list: ArrayList<String>) {
            val input = rememberSaveable {
                mutableStateOf("")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 40.dp)
            ) {
                Text(
                    text = "Динамический список",
                    fontSize = 32.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .padding(8.dp)
                )

                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    contentPadding = PaddingValues(vertical = 8.dp),
                    modifier = Modifier
                        .padding(start = 18.dp, end = 18.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                ) {
                    items(list) { city ->
                        Text(
                            text = city,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .size(width = 400.dp, height = 30.dp)
                                .clip(shape = CircleShape)
                                .background(Color.White)
                                .border(2.dp, Color.White)
                                .clickable(onClick = {
                                    list.remove(city)
                                    input.value = "."
                                    input.value = ""
                                })
                       )
                        Spacer(modifier = Modifier.padding(6.dp))
                    }
                }
               
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Spacer(modifier = Modifier.padding(6.dp))
                    TextField(
                        modifier = Modifier
                            .padding(start = 100.dp, end = 100.dp),
                        value = input.value,
                        placeholder = { Text(text = "Введите город")},
                        onValueChange = { newText ->
                            input.value = newText
                        })
                    Spacer(modifier = Modifier.padding(6.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Добавить",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .clickable(onClick = {
                                    list.add(input.value)
                                input.value = ""
                                })
                        )
                    }
                }
            }
        }



    }
}
