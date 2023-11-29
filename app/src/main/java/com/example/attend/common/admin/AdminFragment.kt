package com.example.attend.common.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.attend.R

class AdminFragment : Fragment() {
    private lateinit var btnStudents: Button
    private lateinit var btnTeachers: Button
    private lateinit var fragmentList: ListView

    private val teacherList: List<String> = listOf("Teacher 1", "Teacher 2", "Teacher 3") // Replace with your actual data
    private val studentList: List<String> = listOf("Student 1", "Student 2", "Student 3") // Replace with your actual data

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize buttons and lists
        btnTeachers = view.findViewById(R.id.btnTeachers)
        btnStudents = view.findViewById(R.id.btnStudents)
        fragmentList = view.findViewById(R.id.STList)

        btnTeachers.setOnClickListener {
            populateList(teacherList)
        }

        btnStudents.setOnClickListener {
            populateList(studentList)
        }
    }

    private fun populateList(data: List<String>) {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, data)
        fragmentList.adapter = adapter
    }
}
