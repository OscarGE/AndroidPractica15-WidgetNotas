package com.example.practica15_widgetnotas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.practica15_widgetnotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DialogNota.DialogNotaListener {
    private var nota1=Nota(
        "Clase de Matemáticas",
        "- Estudiar para el examen del vierens\n" +
                "- Una recta es secante respecto a otra cuando ambas comparten un punto en común. Es decir, dos rectas son secantes cuando se cruzan o intersecan.\n" +
                "- La hipotenusa es el lado de un triángulo rectángulo que se encuentra al frente del ángulo recto o de 90º. Así, se se trata del lado de mayor longitud de la figura.\n"
    )
    private var nota2=Nota(
        "Letra del las Mañanitas",
        "Estas son las mañanitas\n" +
                "Que cantaba el rey David\n" +
                "Hoy por ser día de tu santo\n" +
                "Te las cantamos aquí\n" +
                "Despierta, mi bien, despierta\n" +
                "Mira que ya amaneció\n" +
                "Ya los pajaritos cantan\n" +
                "La luna ya se metió\n" +
                "Qué linda está la mañana\n" +
                "En que vengo a saludarte\n" +
                "Venimos todos con gusto\n" +
                "Y placer a felicitarte\n" +
                "El día en que tú naciste\n" +
                "Nacieron todas las flores\n" +
                "En la pila del bautismo\n" +
                "Cantaron los ruiseñores\n" +
                "Ya viene amaneciendo\n" +
                "Ya la luz del día nos dio\n" +
                "Levántate de mañana, mira que ya amaneció\n" +
                "Si yo pudiera bajarte, las estrellas y un lucero\n" +
                "Para poder demostrarte lo mucho que yo te quiero\n" +
                "Con jazmines y flores este día quiero adornar\n" +
                "Hoy por ser día de tu santo\n" +
                "Te venimos a cantar"
    )
    private var nota3=Nota(
        "Preguntas del día",
        "¿Por qué el cielo es azul?\n" +
                "¿Cuál es el significado de la vida?\n" +
                "¿Cómo sabemos si estamos haciendo lo correcto?"
    )
    private var listaNotas: MutableList<Nota> = mutableListOf(nota1, nota2, nota3)

    private lateinit var adaptador:NotasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adaptador=NotasAdapter(this,listaNotas)
        binding.lista.adapter=adaptador

        binding.imageButton.setOnClickListener{
            val dialogNota = DialogNota()
            dialogNota.show(supportFragmentManager, "anadir nota")

        }

        binding.lista.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, NotaActivity::class.java)
            intent.putExtra("nota",listaNotas[i])
            startActivity(intent)
        }

    }

    override fun applyTexts(editNombre: String, editDescripcion: String) {
        listaNotas.add(Nota(editNombre,editDescripcion))
        adaptador=NotasAdapter(this,listaNotas)
        val lista: ListView = findViewById(R.id.lista)
        lista.adapter=adaptador
    }
}