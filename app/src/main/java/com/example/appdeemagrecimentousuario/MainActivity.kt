package com.example.appdeemagrecimentousuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appdeemagrecimentousuario.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        recuperarRotina()
    }


    private fun recuperarRotina(){


        db.collection("noticas").document("noticia").get()
            .addOnCompleteListener { documento ->
                if (documento.isSuccessful){


                    val titulo = documento.result.get("Titilo").toString()
                    val noticia = documento.result.get("Noticia").toString()
                    val data = documento.result.get("Data").toString()
                    val autor = documento.result.get("Autor").toString()


                    binding.txtTituloRotina.text = titulo
                    binding.txtRotina.text = noticia
                    binding.txtDataRotina.text = data
                    binding.txtAutorRotina.text = autor
                }

            }
    }



}