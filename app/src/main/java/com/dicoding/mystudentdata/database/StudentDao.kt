package com.dicoding.mystudentdata.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudent(student: List<Student>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUniversity(university: List<University>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: List<Course>)

    @Query("SELECT * FROM student")
    fun getAllStudent(): LiveData<List<Student>>

    @Transaction
    @Query("SELECT * FROM student")
    fun getAllStudentAndUniversity(): LiveData<List<StudentAndUniversity>>

    @Transaction
    @Query("SELECT * FROM university")
    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>>
}