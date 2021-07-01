package com.qbo.appqbocoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //realiza un seguimiento de cualquier corrutina que crea mediante los elementos launch o async.
        //Creamos la corrutina indicando el ámbito, lanzador y el despachador

        GlobalScope.launch(Dispatchers.Main) {
            //withContext, es una función suspendida
            //que ejecuta el código en un subproceso IO
            val resultado = withContext(Dispatchers.IO){
                ProveedorDeDatos.TareaPesada()
            }
            mostrarMensaje(if (resultado) "Terminó la carga" else "Error")
        }

    }

    private fun mostrarMensaje(mensaje: String){
        Toast.makeText(this, mensaje,  Toast.LENGTH_LONG).show()
    }
}