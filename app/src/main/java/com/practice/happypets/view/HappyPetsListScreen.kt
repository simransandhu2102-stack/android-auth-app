package com.practice.happypets.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.happypets.model.Pet

@Composable
fun HappyPetsListScreen() {

    val petList = remember { mutableStateListOf<Pet>() }
    var newPetName by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 20.dp, start = 10.dp, end = 5.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = newPetName,
                onValueChange = { newPetName = it },
                label = {
                    Text(
                        text = "Add Pet",
                        fontSize = 16.sp
                    )
                }
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    onClick = {
                        if (newPetName.isNotBlank()) {
                            val newPet = Pet(id = petList.size + 1, name = newPetName)
                            petList.add(newPet)
                            newPetName = ""
                        }
                    }
                ) {
                    Text(text = "Add")
                }

                Button(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f),
                    onClick = {
                        petList.remove(petList.find { pet ->
                            pet.name.contains(newPetName)
                        })
                        newPetName = ""
                    }) {
                    Text(text = "Delete")
                }

                Button(
                    onClick = {
                        petList.sortBy { it.name }
                    },
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(text = "Sort")
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                items(items = petList, key = { it.id }) { pet ->
                    Text(text = pet.name)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHappyPetsList() {
    HappyPetsListScreen()
}
