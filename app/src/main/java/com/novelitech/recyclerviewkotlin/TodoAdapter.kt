package com.novelitech.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.novelitech.recyclerviewkotlin.databinding.ItemTodoBinding

class TodoAdapter(
    var todos: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    // It's called when the RecyclerView needs a new Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        // In RecyclerView, the last parameter NEEDS to be always FALSE
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TodoViewHolder(binding)
    }

    // Returns how many items I have in my Recycler View
    override fun getItemCount(): Int {
        return todos.size
    }

    // Bind the data to the items
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // .itemView contains all the views that are in the View (item_todo.xml). In this case, the
        // EditText and Checkbox
//        holder.itemView.apply {
//            holder.binding.tvTitle.text = todos[position].title
//            holder.binding.cbDone.isChecked = todos[position].isChecked
//        }

        with(holder) {
            with(todos[position]) {
                binding.tvTitle.text = title
                binding.cbDone.isChecked = isChecked
            }
        }
    }
}