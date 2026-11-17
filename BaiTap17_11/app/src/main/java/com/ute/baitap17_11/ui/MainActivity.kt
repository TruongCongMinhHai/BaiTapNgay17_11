package com.ute.baitap17_11.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ute.baitap17_11.R
import com.ute.baitap17_11.data.AppDatabase
import com.ute.baitap17_11.repository.StudentRepository
import com.ute.baitap17_11.viewmodel.StudentViewModel
import com.ute.baitap17_11.viewmodel.StudentViewModelFactory

class MainActivity : AppCompatActivity() {

    private val database by lazy { AppDatabase.getDatabase(this) }
    private val repository by lazy { StudentRepository(database.studentDao()) }

    private val viewModel: StudentViewModel by viewModels {
        StudentViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo ViewModel (kèm Factory) sớm để các Fragment dùng chung qua activityViewModels()
        viewModel

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, StudentListFragment())
                .commit()
        }
    }
}