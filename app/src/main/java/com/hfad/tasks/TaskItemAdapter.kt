package com.hfad.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.hfad.tasks.databinding.TaskItemBinding

class TaskItemAdapter(val clickListener: (taskId: Long) -> Unit) :
    ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallback()) {
    /*RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>() {
        var data = listOf<Task>()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun getItemCount() = data.size

         */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        //data[position]
        holder.bind(item, clickListener)
    }

    //class TaskItemViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {
    class TaskItemViewHolder(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {

        //val taskName = rootView.findViewById<TextView>(R.id.task_name)
        //val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)

        companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                //val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskItemViewHolder(binding)
            }
        }

        fun bind(item: Task, clickListener: (taskId: Long) -> Unit) {
            //rootView
            //taskName.text = item.taskName
            //taskDone.isChecked = item.taskDone
            binding.task = item
            binding.root.setOnClickListener {
                clickListener(item.taskId)
            }
            /*Toast.makeText(
                binding.root.context, "Click task ${item.taskId}",
                Toast.LENGTH_SHORT
            ).show()

             */
        }
    }
}