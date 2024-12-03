package com.example.mansion_encantada
/*
Esta clase es una enumeración que define emoticonos con su imagen asociada (recurso drawable)
y su representación en texto Unicode (emoji), centralizando su uso en la aplicación.
*/


enum class Emoticonos(val imagen:Int, val emoji:String) {
    PIRULETA(R.drawable.piruleta, "🍭"),
    PUERTA(R.drawable.puerta, "🚪"),
    FANTASMA(R.drawable.fantasma, "👻"),
    BRUJULA(R.drawable.brujula, "🧭"),
    PREGUNTA(R.drawable.interrogacion, "❓"),;
}