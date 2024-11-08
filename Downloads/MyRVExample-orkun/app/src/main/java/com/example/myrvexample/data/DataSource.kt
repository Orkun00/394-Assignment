package com.example.myrvexample.data

import android.content.Context
import com.example.myrvexample.R
import com.example.myrvexample.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

class DataSource(private val context: Context) {

    fun loadEmployees(): List<User> {
        // Open the JSON file in the res/raw directory
        val inputStream = context.resources.openRawResource(R.raw.stocks)
        val reader = InputStreamReader(inputStream)

        // Define the type of the list of Employee objects
        val employeeType = object : TypeToken<List<User>>() {}.type

        // Parse the JSON file into a List<Employee> using Gson
        return Gson().fromJson(reader, employeeType)
    }
}
