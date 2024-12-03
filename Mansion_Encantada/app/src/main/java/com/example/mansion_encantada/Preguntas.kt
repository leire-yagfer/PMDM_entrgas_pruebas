package com.example.mansion_encantada

class Preguntas {

    //objeto estático
    companion object {
        //mapa que asocia cada emoticono con la cantidad que debe aparecer
        var emoticonos = mapOf(
            //clave = emoji   value = count
            Emoticonos.PUERTA to 1,
            Emoticonos.PIRULETA to 1,
            Emoticonos.FANTASMA to 2,
            Emoticonos.PREGUNTA to 12
        )

        //lista mutable que almacenará los emoticonos (de la clase enum) a usar en las preguntas
        val listaEmojis = mutableListOf<Emoticonos>()

        //inicialización: se rellena la lista con los emoticonos y luego se baraja
        init {
            rellenarLista() //rellena la lista con los emoticonos
            listaEmojis.shuffle() //mezcla los emoticonos aleatoriamente
        }//init


        //rellena la lista con los emoticonos (de la clase enum) según las cantidades especificadas en el mapa
        fun rellenarLista(): MutableList<Emoticonos> {
            //itera sobre el mapa y añade los emoticonos a la lista según su cantidad
            for ((emoji, count) in emoticonos) {
                repeat(count) { //inserta cada emoticono la cantidad de veces indicada (1, 2 o 12 en este caso) y ya luego, en el init, se "baraja"
                    listaEmojis.add(emoji)
                }
            }
            return listaEmojis // Devuelve la lista con los emoticonos añadidos
        }//rellenarLista
    }//companion object
}//class
