package com.example.bookmyshow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        val signupOption = findViewById<TextView>(R.id.signupOption)

        // Handle login button click
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Simple validation (you can improve this with more complex logic)
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else {
                // For simplicity, consider these values are valid
                // In a real app, you would validate against a database or server
                if (email == "user@example.com" && password == "password123") {
                    // If login is successful, redirect to the next activity (e.g., HomeActivity)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Close login activity
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Handle forgot password text click
        forgotPassword.setOnClickListener {
            // You can create a forgot password activity here
            Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show()
        }

        // Handle sign-up option click
        signupOption.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


        val fabHome = findViewById<FloatingActionButton>(R.id.fabHome)
        // Set an onClick listener for the FAB
        fabHome.setOnClickListener {
            // Start HomeActivity when the FAB is clicked
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
