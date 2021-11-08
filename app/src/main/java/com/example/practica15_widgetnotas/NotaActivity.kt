package com.example.practica15_widgetnotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.example.practica15_widgetnotas.databinding.ActivityNotaBinding

class NotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.descripcionDetalle.movementMethod = ScrollingMovementMethod()
        val nota=intent.getSerializableExtra("nota") as Nota
        binding.nombreDetalle.text=nota.nombre
        binding.descripcionDetalle.text=nota.descripcion

        binding.imageBack.setOnClickListener {
            this.finish()
        }
    }
}