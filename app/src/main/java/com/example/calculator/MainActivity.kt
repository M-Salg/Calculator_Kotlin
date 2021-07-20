package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        button_parebeses_esquerda.setOnClickListener {
            input.text = addToInputText("(")
        }
        button_parenteses_direita.setOnClickListener {
            input.text = addToInputText(")")
        }
        button_zero.setOnClickListener {
            input.text = addToInputText("0")
        }
        button_um.setOnClickListener {
            input.text = addToInputText("1")
        }
        button_dois.setOnClickListener {
            input.text = addToInputText("2")
        }
        button_tres.setOnClickListener {
            input.text = addToInputText("3")
        }
        button_quatro.setOnClickListener {
            input.text = addToInputText("4")
        }
        button_cinco.setOnClickListener {
            input.text = addToInputText("5")
        }
        button_seis.setOnClickListener {
            input.text = addToInputText("6")
        }
        button_sete.setOnClickListener {
            input.text = addToInputText("7")
        }
        button_oito.setOnClickListener {
            input.text = addToInputText("8")
        }
        button_nove.setOnClickListener {
            input.text = addToInputText("9")
        }
        button_ponto.setOnClickListener {
            input.text = addToInputText(".")
        }
        button_divisao.setOnClickListener {
            input.text = addToInputText("÷")
        }
        button_multiplica.setOnClickListener {
            input.text = addToInputText("×")
        }
        button_menos.setOnClickListener {
            input.text = addToInputText("-")
        }
        button_mais.setOnClickListener {
            input.text = addToInputText("+")
        }

        button_igual.setOnClickListener {
            showResult()
        }



    }

    private fun addToInputText(buttonValue: String): String{
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String{
        var expression = input.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"), "*")
        return expression


    }

    private fun showResult (){
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if(result.isNaN()){
                //Show error message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }else{
                //Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception){

        }

    }
}