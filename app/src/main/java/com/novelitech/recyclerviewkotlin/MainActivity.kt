package com.novelitech.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.novelitech.recyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var todoList = mutableListOf(
            Todo("Follow me", true),
            Todo("Learn about RecyclerView", false),
            Todo("Feed my cat", true),
            Todo("Prank my boss", true),
            Todo("Eat some curry", false),
            Todo("Ask my crush out", false),
            Todo("Take a shower", true),
            Todo("I need a break", true)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {

            val title = binding.etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)

            // This function would work too, but it's not recommended due to it would update all
            // the Recycler View because it doesn't know which entry to update. So it would go through
            // all the items to update it.
//            adapter.notifyDataSetChanged()

            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}