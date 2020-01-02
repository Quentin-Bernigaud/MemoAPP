package com.android.example.recyclerview.network

import com.android.example.recyclerview.Task

class TasksRepository {
    private val tasksService = Api.tasksService

    suspend fun loadTasks(): List<Task>? {
        val tasksResponse = tasksService.getTasks()
        return if (tasksResponse.isSuccessful) tasksResponse.body() else null
    }

    suspend fun deleteRemoteTasks(id: String): Boolean {
        val tasksResponse = tasksService.deleteTask(id)
        return tasksResponse.isSuccessful
    }

     suspend fun createRemoteTasks(task: Task): Task? {
        val tasksResponse = tasksService.createTask(task)
        return if (tasksResponse.isSuccessful) tasksResponse.body() else null
    }

    suspend fun updateRemoteTasks(task: Task): Task? {
        val tasksResponse = tasksService.updateTask(task)
        return if (tasksResponse.isSuccessful) tasksResponse.body() else null
    }
}