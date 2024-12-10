package com.example.madsharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madsharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("NoteData", Context.MODE_PRIVATE)

        // Save Note
        binding.saveNoteButton.setOnClickListener {
            val title = binding.noteTitleEditText.text.toString()
            val content = binding.noteContentEditText.text.toString()
            val date = binding.noteDateEditText.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                val sharedEdit = sharedPreferences.edit()
                sharedEdit.putString("title", title)
                sharedEdit.putString("content", content)
                sharedEdit.putString("date", date)
                sharedEdit.apply()
                Toast.makeText(this, "Note Stored Successfully", Toast.LENGTH_SHORT).show()
                clearFields()
            } else {
                Toast.makeText(this, "Please enter both title and content", Toast.LENGTH_SHORT).show()
            }
        }

        // Display Note
        binding.displayNoteButton.setOnClickListener {
            val title = sharedPreferences.getString("title", "")
            val content = sharedPreferences.getString("content", "")
            val date = sharedPreferences.getString("date", "")

            if (title!!.isNotEmpty() && content!!.isNotEmpty()) {
                val displayText = "Title: $title\nContent: $content\nDate: $date"
                binding.noteDisplayTextView.text = displayText
            } else {
                binding.noteDisplayTextView.text = "No Notes Found"
            }
        }

        // Update Note
        binding.updateNoteButton.setOnClickListener {
            val updatedTitle = binding.noteTitleEditText.text.toString()
            val updatedContent = binding.noteContentEditText.text.toString()
            val updatedDate = binding.noteDateEditText.text.toString()

            if (updatedTitle.isNotEmpty() && updatedContent.isNotEmpty()) {
                val sharedEdit = sharedPreferences.edit()
                sharedEdit.putString("title", updatedTitle)
                sharedEdit.putString("content", updatedContent)
                sharedEdit.putString("date", updatedDate)
                sharedEdit.apply()
                Toast.makeText(this, "Note Updated Successfully", Toast.LENGTH_SHORT).show()
                clearFields()
            } else {
                Toast.makeText(this, "Please enter both title and content", Toast.LENGTH_SHORT).show()
            }
        }

        // Delete Note
        binding.deleteNoteButton.setOnClickListener {
            val sharedEdit = sharedPreferences.edit()
            sharedEdit.remove("title")
            sharedEdit.remove("content")
            sharedEdit.remove("date")
            sharedEdit.apply()
            Toast.makeText(this, "Note Deleted Successfully", Toast.LENGTH_SHORT).show()
            binding.noteDisplayTextView.text = ""
        }
    }

    // Helper method to clear fields after saving or updating
    private fun clearFields() {
        binding.noteTitleEditText.text.clear()
        binding.noteContentEditText.text.clear()
        binding.noteDateEditText.text.clear()
    }
}
