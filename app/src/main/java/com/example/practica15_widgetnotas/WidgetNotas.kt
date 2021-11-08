package com.example.practica15_widgetnotas

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.util.Log
import android.widget.RemoteViews

class WidgetNotas: AppWidgetProvider(){
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ){
        for(i in appWidgetIds.indices){
            val widgetId = appWidgetIds[i]
            actualizarWidget(context, appWidgetManager, widgetId)
        }
    }
    companion object {
        fun actualizarWidget(context: Context, appWidgetManager: AppWidgetManager, widgetId: Int){
            Log.d(null, "Actualizar")
            val prefs =  context.getSharedPreferences("WidgetPref", Context.MODE_PRIVATE)

            val controles = RemoteViews(context.packageName, R.layout.widget_notas)

            appWidgetManager.updateAppWidget(widgetId, controles)
        }
    }
}