package com.android.example.recyclerview.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.recyclerview.Task
import kotlinx.coroutines.launch



class TasksViewModel: ViewModel() {
    val tasks = MutableLiveData<List<Task>?>()
    private val repository = TasksRepository()

    fun loadTasks() {
        viewModelScope.launch {
            tasks.postValue(repository.loadTasks())
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteRemoteTasks(task.id)
            val newList = tasks.value?.toMutableList()
            newList?.remove(task)
            tasks.postValue(newList)
        }
    }

    fun createTask(task: Task) {
        viewModelScope.launch {
            repository.createRemoteTasks(task)
            val newList =  tasks.value?.toMutableList()
            newList?.add(task)
            tasks.postValue(newList)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateRemoteTasks(task)
            val newList =  tasks.value?.toMutableList()
            val index = newList?.indexOfFirst { it.id == task.id }
            if (index != null && index >= 0) {
                newList[index] = task
                tasks.postValue(newList)
            }
        }
    }
}