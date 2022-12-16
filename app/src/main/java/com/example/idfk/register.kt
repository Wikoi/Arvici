package com.example.idfk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.idfk.R.id.RegisterBtn
import com.google.firebase.auth.FirebaseAuth


class Register : AppCompatActivity() {

    private lateinit var Email : EditText
    private lateinit var Password : EditText
    private lateinit var RegisterBtn : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Email = findViewById(R.id.Email)
        Password = findViewById(R.id.Password)
        RegisterBtn = findViewById(R.id.RegisterBtn)

        RegisterBtn.setOnClickListener {
            if(Email.toString().isEmpty() || Password.text.toString().isEmpty()){
                Toast.makeText(this, "Please fill out the specific tabs", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(Email.toString(), Password.toString())
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Idk2::class.java)
                        startActivity(intent)

                    }
                    else{
                        Toast.makeText(this, "???", Toast.LENGTH_SHORT).show()
                    }

                }
        }





    }
}