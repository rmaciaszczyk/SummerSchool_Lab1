package edu.zut.erasmus_plus.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageButton
import android.widget.TextView
import edu.zut.erasmus_plus.calculator.databinding.ActivityMainBinding
import edu.zut.erasmus_plus.calculator.databinding.CalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity(), OnClickListener {
    private var isError: Boolean = true
    private lateinit var binding: CalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.one?.setOnClickListener(this)
        binding.two.setOnClickListener(this)
        binding.three?.setOnClickListener(this)
        binding.four.setOnClickListener(this)
        binding.five?.setOnClickListener(this)
        binding.six?.setOnClickListener(this)
        binding.seven?.setOnClickListener(this)
        binding.eight?.setOnClickListener(this)
        binding.nine?.setOnClickListener(this)
        binding.zero?.setOnClickListener(this)
        binding.div?.setOnClickListener(this)
        binding.multi?.setOnClickListener(this)
        binding.div?.setOnClickListener(this)
        binding.multi?.setOnClickListener(this)
        binding.sub?.setOnClickListener(this)
        binding.plus?.setOnClickListener(this)
        binding.dot?.setOnClickListener(this)
        binding.equals?.setOnClickListener(this)
        binding.display?.setOnClickListener(this)
        binding.clear?.setOnClickListener(this)
        binding.backDelete?.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        if (isError) {
            binding.display.text=""
            isError=false
        }

        when  (p0?.id) {
            R.id.one -> binding.display.append("1")
            R.id.two -> binding.display.append("2")
            R.id.three -> binding.display.append("3")
            R.id.four -> binding.display.append("4")
            R.id.five -> binding.display.append("5")
            R.id.six -> binding.display.append("6")
            R.id.seven -> binding.display.append("7")
            R.id.eight -> binding.display.append("8")
            R.id.nine -> binding.display.append("9")
            R.id.zero -> binding.display.append("0")
            R.id.div -> binding.display.append("/")
            R.id.multi -> binding.display.append("*")
            R.id.sub -> binding.display.append("-")
            R.id.plus -> binding.display.append("+")
            R.id.dot -> binding.display.append(".")
            R.id.clear -> binding.display.text = ""
            R.id.equals -> evaluateExpression(binding.display.text.toString())
            R.id.backDelete -> {
                binding.display.text =
                    if ((binding.display.text.length -1) >=0)
                        binding.display.text.subSequence(0,binding.display.text.length -1)
                else binding.display.text
            }
        }
    }

        private fun evaluateExpression(inputString: String) {
            val expression = ExpressionBuilder(inputString).build()
            try {
                // Calculate the result and display
                val result = expression.evaluate()
                binding.display.text = result.toString()
                //lastDot = true // Result contains a dot
            } catch (ex: Exception)
            {
                when(ex) {
                    is IllegalArgumentException, is ArithmeticException -> {
                        binding.display.text = "Error"
                        isError = true
                    }
                    else -> throw ex
                }

            }

        }


    }
