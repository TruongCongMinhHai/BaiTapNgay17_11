package com.ute.baitap17_11.repository

import com.ute.baitap17_11.data.StudentDao
import com.ute.baitap17_11.model.Student
import kotlinx.coroutines.flow.Flow

class StudentRepository(private val studentDao: StudentDao) {

    val allStudents: Flow<List<Student>> = studentDao.getAllStudents()

    suspend fun insert(student: Student) {
        studentDao.insertStudent(student)
    }

    suspend fun delete(student: Student) {
        studentDao.deleteStudent(student)
    }
}