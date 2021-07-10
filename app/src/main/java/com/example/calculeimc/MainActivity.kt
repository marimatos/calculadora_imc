package com.example.calculeimc

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInfo.setOnClickListener {
            val it = Intent(this@MainActivity, InfoActivity::class.java)
            startActivity(it)
        }


        btnCalc.setOnClickListener {
            calcularIMC(edt_peso.text.toString(), edt_altura.text.toString())

        }
    }


    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloat()
        val altura = altura.toFloat() / 100
        if (peso != null && altura != null)
        {
            val imc = peso / (altura * altura)
            txt_result.text = "Seu IMC é %.2f".format(imc)
            classificacaoIMC(imc.toString())
        }
    }

    private fun classificacaoIMC(imc: String) {
        val imc = imc.toFloat()

        if (imc < 18.5)  {
            txt_classification.text = "Baixo Peso"
        } else if (imc < 24.9) {
            txt_classification.text = "Peso Normal"
        } else if (imc < 29.9) {
            txt_classification.text = "Excesso de peso"
        } else if (imc < 34.9) {
            txt_classification.text = "Obesidade de Classe 1"
        } else if (imc < 39.9) {
            txt_classification.text = "Obesidade de Classe 2"
        } else {
            txt_classification.text = "Obesidade de Classe 3"
        }
    }

}