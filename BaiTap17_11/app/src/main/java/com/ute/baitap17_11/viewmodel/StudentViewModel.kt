package com.ute.baitap17_11.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ute.baitap17_11.model.Student
import com.ute.baitap17_11.repository.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: StudentRepository) : ViewModel() {

    val allStudents: LiveData<List<Student>> =
        repository.allStudents.asLiveData(Dispatchers.IO)

    fun insert(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(student)
    }

    fun delete(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(student)
    }
}