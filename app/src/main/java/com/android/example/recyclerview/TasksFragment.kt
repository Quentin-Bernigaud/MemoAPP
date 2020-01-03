package com.android.example.recyclerview

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.example.recyclerview.network.TasksViewModel
import kotlinx.android.synthetic.main.fragment_tasks.*
import android.os.Bundle as Bundle1

class TasksFragment : Fragment() {
    private val tasksAdapter = TasksAdapter()
    private val tasksViewModel by lazy {
        ViewModelProvider(this).get(TasksViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle1?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle1?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter = tasksAdapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        tasksAdapter.onDeleteClickListener = { task ->
            tasksViewModel.deleteTask(task)
        }

        add_task.setOnClickListener { task ->
            val intent = Intent(activity, TaskActivity::class.java)
            startActivityForResult(intent, ADD_TASK_REQUEST_CODE)
        }

//        avatar.setOnClickListener {
//            val intent = Intent(activity, UserInfoActivity::class.java)
//            startActivity(intent)
//        }

        tasksAdapter.onEditClickListener = { task ->
            val intent = Intent(activity, TaskActivity::class.java)
            intent.putExtra(TaskActivity.TASK_KEY, task)
            startActivityForResult(intent, UPDATE_TASK_REQUEST_CODE)
        }

        tasksViewModel.tasks.observe(this, Observer { newTask ->
            tasksAdapter.tasks = newTask.orEmpty()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_TASK_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val task = data!!.getSerializableExtra(TaskActivity.TASK_KEY) as Task
                tasksViewModel.createTask(task)
            }
        }
        if (requestCode == UPDATE_TASK_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val task = data!!.getSerializableExtra(TaskActivity.TASK_KEY) as Task
                tasksViewModel.updateTask(task)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        tasksViewModel.loadTasks()
    }

    companion object {
        private const val ADD_TASK_REQUEST_CODE = 1
        private const val UPDATE_TASK_REQUEST_CODE = 3
    }
}
