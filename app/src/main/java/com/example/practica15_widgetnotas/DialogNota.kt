package com.example.practica15_widgetnotas

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment

class DialogNota : DialogFragment() {
    private lateinit var listener:DialogNotaListener
    interface DialogNotaListener {
        fun applyTexts(editNombre: String,editDescripcion: String)
    }
    override fun onCreateDialog( savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            val binding = inflater.inflate(R.layout.dialog_nota, null)

            builder.setView(binding)
                .setPositiveButton("Guardar",
                    DialogInterface.OnClickListener { dialog, id ->
                        val editNombre= binding.findViewById<EditText>(R.id.editNombre).text.toString()
                        val editDescripcion= binding.findViewById<EditText>(R.id.editDescripcion).text.toString()

                        listener.applyTexts(editNombre,editDescripcion)
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = context as DialogNotaListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException((context.toString() +
                    " must implementDialogNotaListener"))
        }
    }
}