package com.example.printingapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.add_task.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

const val DB_NAME = "todo.db"

class TaskActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var myCalendar: Calendar
    private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener

    private var finalDate = 0L

    private val labels = arrayListOf("Personal", "Business", "Insurance", "Shopping", "Banking")

    private val db by lazy {
        AppDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_task)

        deadlinefield.setOnClickListener(this)
        save.setOnClickListener(this)

        setUpSpinner()
    }

    private fun setUpSpinner() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, labels)
        labels.sort()
        spinner.adapter = adapter
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.deadlinefield -> setListener()
            R.id.save -> saveTodo()
        }
    }

    private fun saveTodo() {
        val category = spinner.selectedItem.toString()
        val title = titlefield.editText?.text.toString()
        val description = descfield.editText?.text.toString()

        lifecycleScope.launch {
            val id = withContext(Dispatchers.IO) {
                db.todoDao().insertTask(
                    TaskData(
                        title = title,
                        description = description,
                        category = category,
                        deadline = finalDate
                    )
                )
            }
            finish()
        }
    }

    private fun setListener() {
        myCalendar = Calendar.getInstance()
        dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDate()
        }

        DatePickerDialog(
            this,
            dateSetListener,
            myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)
        ).apply {
            datePicker.minDate = System.currentTimeMillis()
            show()
        }
    }

    private fun updateDate() {
        val format = "EEE, d MMM yyyy"
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        finalDate = myCalendar.timeInMillis
        deadline.setText(sdf.format(myCalendar.time))
    }
}

