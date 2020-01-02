package com.android.example.recyclerview.network

import com.android.example.recyclerview.Task
import retrofit2.Response
import retrofit2.http.*

interface TasksService {
    @GET("tasks")
    suspend fun getTasks(): Response<List<Task>>

    @DELETE("tasks/{id}")
    suspend fun deleteTask(@Path("id") id: String): Response<Boolean>

    @POST("tasks")
    suspend fun createTask(@Body task: Task): Response<Task>

    @PATCH("tasks/{id}")
    suspend fun updateTask(@Body task: Task, @Path("id") id: String = task.id): Response<Task>
}