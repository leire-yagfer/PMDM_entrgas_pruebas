package com.example.mansion_encantada

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mansion_encantada.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //declaro el objeto de binding para acceder a los elementos del layout
    private lateinit var listaImagenes: List<ImageView> //declaro la lista de las imágenes para que sea accesible en toda la clase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inicializo el binding y asigno el layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //llamo al método que inicializa todos los ImageViews
        inicializarComponentes()

        //accedo a la lista de emojis de forma estática
        val listaEmojis = Preguntas.listaEmojis

        //asigno las imágenes tapadas inicialmente
        for (imageView in listaImagenes) {
            imageView.setImageResource(R.drawable.tapada) //asigno la imagen de la casilla tapada
        }

        //asigno el listener de clic para descubrir los emojis
        for (i in listaImagenes.indices) {
            val emoji = listaEmojis[i] //obtengo el emoji en la posición i de listaEmojis
            val imageView = listaImagenes[i] //obtengo el ImageView en la posición i de listaImagenes

            //configuro el clic para revelar el emoji
            imageView.setOnClickListener {
                imageView.setImageResource(emoji.imagen) //cambio la imagen a la del emoji
                imageView.isClickable = false //deshabilito el clic para evitar que se vuelva a presionar
            }
        }
    }//onCreate

    //inicializo los ImageView y los guardo en la lista
    private fun inicializarComponentes() {
        //asigno los ImageViews utilizando el binding
        listaImagenes = listOf(
            binding.h00, binding.h01, binding.h02, binding.h03,
            binding.h10, binding.h11, binding.h12, binding.h13,
            binding.h20, binding.h21, binding.h22, binding.h23,
            binding.h30, binding.h31, binding.h32, binding.h33
        )
    }//inicializarComponentes
}