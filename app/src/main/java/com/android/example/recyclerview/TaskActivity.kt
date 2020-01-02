package com.android.example.recyclerview

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_task.*
import java.util.*

class TaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val task = intent.getSerializableExtra(TASK_KEY) as? Task
        if (task != null) {
            set_task_title.setText(task.title)
        }
        if (task != null) {
            set_task_description.setText(task.description)
        }

        validate.setOnClickListener {
            val newTask = Task(id = task?.id ?: UUID.randomUUID().toString(), title = set_task_title.text.toString(), description = set_task_description.text.toString())
            intent.putExtra(TASK_KEY, newTask)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        val actionbar = supportActionBar
        if (set_task_title.text != null) {
            actionbar!!.title = set_task_title.text
        } else {
            actionbar!!.title = "Ajouter une tâche"
        }
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



    companion object {
        const val TASK_KEY = "reply_key"
    }
}
