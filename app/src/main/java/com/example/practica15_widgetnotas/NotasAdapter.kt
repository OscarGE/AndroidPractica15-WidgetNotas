package com.example.practica15_widgetnotas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.practica15_widgetnotas.databinding.ItemNotaBinding

class NotasAdapter (private val mContext: Context, private val listaNotas: List<Nota>) : ArrayAdapter<Nota>(mContext,0,listaNotas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding  = ItemNotaBinding.inflate(LayoutInflater.from(mContext),parent,false)
        var descripcion:String=""
        val nota = listaNotas[position]

        binding.nombre.text = nota.nombre
        if(nota.descripcion.indexOf("\n")!=-1)
            descripcion="${nota.descripcion.substring(0,nota.descripcion.indexOf("\n"))}..."
        else if(nota.descripcion.length>50)
            descripcion="${nota.descripcion.substring(0,50)}..."
        else
            descripcion=nota.descripcion

        binding.descripcion.text= descripcion

        return binding.root
    }
}
