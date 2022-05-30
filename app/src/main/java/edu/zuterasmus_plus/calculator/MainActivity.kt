package edu.zut.erasmus_plus.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageButton
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity(), OnClickListener {
    private var one: TextView? =null
    private lateinit var two:TextView
    private var three:TextView? = null
    private lateinit var four:TextView
    private var five:TextView? = null
    private var six:TextView? = null
    private var seven:TextView? = null
    private var eight:TextView? = null
    private var nine:TextView? = null
    private var zero:TextView? = null
    private var div:TextView? = null
    private var multi:TextView? = null
    private var sub:TextView? = null
    private var plus:TextView? = null
    private var dot:TextView? = null
    private var equals:TextView? = null
    private lateinit var display:TextView
    private var clear:TextView? = null
    private var backDelete: ImageButton? = null

    private var isError: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        div = findViewById(R.id.div)
        multi = findViewById(R.id.multi)
        sub = findViewById(R.id.sub)
        equals = findViewById(R.id.equals)
        display = findViewById(R.id.display)
        clear = findViewById(R.id.clear)
        backDelete = findViewById(R.id.backDelete)

        one?.setOnClickListener(this)
        two.setOnClickListener(this)
        three?.setOnClickListener(this)
        four.setOnClickListener(this)
        five?.setOnClickListener(this)
        six?.setOnClickListener(this)
        seven?.setOnClickListener(this)
        eight?.setOnClickListener(this)
        nine?.setOnClickListener(this)
        zero?.setOnClickListener(this)
        div?.setOnClickListener(this)
        multi?.setOnClickListener(this)
        div?.setOnClickListener(this)
        multi?.setOnClickListener(this)
        sub?.setOnClickListener(this)
        plus?.setOnClickListener(this)
        dot?.setOnClickListener(this)
        equals?.setOnClickListener(this)
        display?.setOnClickListener(this)
        clear?.setOnClickListener(this)
        backDelete?.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        if (isError) {
            display.text=""
            isError=false
        }

        when  (p0?.id) {
            R.id.one -> display.append("1")
            R.id.two -> display.append("2")
            R.id.three -> display.append("3")
            R.id.four -> display.append("4")
            R.id.five -> display.append("5")
            R.id.six -> display.append("6")
            R.id.seven -> display.append("7")
            R.id.eight -> display.append("8")
            R.id.nine -> display.append("9")
            R.id.zero -> display.append("0")
            R.id.div -> display.append("/")
            R.id.multi -> display.append("*")
            R.id.sub -> display.append("-")
            R.id.plus -> display.append("+")
            R.id.dot -> display.append(".")
            R.id.clear -> display.text = ""
            R.id.equals -> evaluateExpression(display.text.toString())
            R.id.backDelete -> {
                display.text =
                    if ((display.text.length -1) >=0)
                        display.text.subSequence(0,display.text.length -1)
                else display.text
            }
        }
    }

        private fun evaluateExpression(inputString: String) {
            val expression = ExpressionBuilder(inputString).build()
            try {
                // Calculate the result and display
                val result = expression.evaluate()
                display.text = result.toString()
                //lastDot = true // Result contains a dot
            } catch (ex: Exception)
            {
                when(ex) {
                    is IllegalArgumentException, is ArithmeticException -> {
                        display.text = "Error"
                        isError = true
                    }
                    else -> throw ex
                }

            }

        }


    }
