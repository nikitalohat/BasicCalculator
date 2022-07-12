package com.lohat.calci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClear.setOnClickListener {
            txtInput.text=""
            txtOutput.text=""
        }

        btnOpenBracket.setOnClickListener {
            txtInput.text = addToInputText("(")
        }

        btnCloseBracket.setOnClickListener {
            txtInput.text = addToInputText(")")
        }

        btnDivide.setOnClickListener {
            txtInput.text = addToInputText("÷")
        }

        btn7.setOnClickListener {
            txtInput.text = addToInputText("7")
        }

        btn8.setOnClickListener {
            txtInput.text = addToInputText("8")
        }

        btn9.setOnClickListener {
            txtInput.text = addToInputText("9")
        }
        btnMultiply.setOnClickListener {
            txtInput.text = addToInputText("×")
        }

        btn4.setOnClickListener {
            txtInput.text = addToInputText("4")
        }

        btn5.setOnClickListener {
            txtInput.text = addToInputText("5")
        }

        btn6.setOnClickListener {
            txtInput.text = addToInputText("6")
        }

        btnSub.setOnClickListener {
            txtInput.text = addToInputText("-")
        }

        btn1.setOnClickListener {
            txtInput.text = addToInputText("1")
        }

        btn2.setOnClickListener {
            txtInput.text = addToInputText("2")
        }

        btn3.setOnClickListener {
            txtInput.text = addToInputText("3")
        }

        btnAddition.setOnClickListener {
            txtInput.text = addToInputText("+")
        }

        btn0.setOnClickListener {
            txtInput.text = addToInputText("0")
        }

        btnDecimal.setOnClickListener {
            txtInput.text = addToInputText(".")
        }

        btnIsEqualTo.setOnClickListener {
            showResult()
        }


    }
    private fun addToInputText(buttonValue : String): String {
        return "${txtInput.text}$buttonValue"
    }

    private fun getExpression() : String{
        var expression = txtInput.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"),"*")
        return expression
    }
    private fun showResult(){
        try {
            val expression = getExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                //error message
                txtOutput.text = "Error"
                txtOutput.setTextColor(ContextCompat.getColor(this, R.color.red))
            }else{
                //result
                txtOutput.text = DecimalFormat("0.######").format(result).toString()
                txtOutput.setTextColor(ContextCompat.getColor(this, R.color.pink))
            }

        }catch (e: Exception){
                //error message
            txtOutput.text = "Error"
            txtOutput.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}