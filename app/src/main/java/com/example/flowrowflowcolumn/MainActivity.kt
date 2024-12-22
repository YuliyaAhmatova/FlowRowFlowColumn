package com.example.flowrowflowcolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val persons = mutableListOf(
                PersonModel("Андрей", "Протасов", "Инжинер", 77000),
                PersonModel("Александр", "Доманов", "Программист", 110000),
                PersonModel("Анна", "Журкина", "Врач", 35000),
                PersonModel("Александра", "Кононова", "Учитель", 25000),
                PersonModel("Иван", "Петров", "Инжинер", 67000),
                PersonModel("Алексей", "Долотов", "Программист", 140000),
                PersonModel("Анна", "Ломакина", "Учитель", 25000),
                PersonModel("Андрей", "Липов", "Врач", 47000),
                PersonModel("Инга", "Самолетова", "Инжинер", 42000),
                PersonModel("Петр", "Семенов", "Программист", 150000),
                PersonModel("Антон", "Фирсов", "Учитель", 62000),
                PersonModel("Виталий", "Иванов", "Врач", 88000)
            ).sortedWith(
                compareBy<PersonModel> { it.role }.thenBy { it.name }
            )
            FlowColumn(
                Modifier.horizontalScroll(rememberScrollState()),
                maxItemsInEachColumn = 3
            ) {
                persons.forEach { person ->
                    ItemColumn(person)
                }
            }
        }
    }
}

@Composable
fun ItemColumn(person: PersonModel) {
    Column(
        Modifier
            .width(300.dp)
            .padding(5.dp)
            .border(width = 1.dp, Color.Black)
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_android),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = "Имя: ${person.name}",
            fontSize = 20.sp
        )
        Text(
            text = "Фамилия: ${person.secondName}",
            fontSize = 20.sp
        )
        Text(
            text = "Должность: ${person.role}",
            fontSize = 20.sp
        )
        Text(
            text = "Зарплата: ${person.salary}",
            fontSize = 20.sp
        )
    }
}

data class PersonModel(val name: String, val secondName: String, val role: String, val salary: Int)