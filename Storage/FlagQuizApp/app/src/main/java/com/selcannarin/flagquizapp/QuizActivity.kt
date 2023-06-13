package com.selcannarin.flagquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.selcannarin.flagquizapp.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var questions:ArrayList<Flags>
    private lateinit var wrongAnswers:ArrayList<Flags>
    private lateinit var rightQuestion:Flags
    private lateinit var allAnswers:HashSet<Flags>
    private lateinit var db:DatabaseHelper

    private var questionCounter = 0
    private var rightCounter = 0
    private var wrongCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = DatabaseHelper(this)
        questions = Flagsdao().random5Flags(db)

        loadQuestion()

        binding.buttonAnswer1.setOnClickListener {
             rightControl(binding.buttonAnswer1)
            questionCounterControl()
        }
        binding.buttonAnswer2.setOnClickListener {
            rightControl(binding.buttonAnswer2)
            questionCounterControl()
        }
        binding.buttonAnswer3.setOnClickListener {
            rightControl(binding.buttonAnswer3)
            questionCounterControl()
        }
        binding.buttonAnswer4.setOnClickListener {
            rightControl(binding.buttonAnswer4)
            questionCounterControl()
        }
        db.close()



    }

    fun loadQuestion(){

        binding.textViewQuestionNumber.text = "${questionCounter+1}. Question"

        rightQuestion = questions.get(questionCounter)

        binding.imageViewFlag.setImageResource(resources.getIdentifier(rightQuestion.flag_image,"drawable",packageName))

        wrongAnswers = Flagsdao().random3WrongAnswer(db,rightQuestion.flag_id)

        allAnswers = HashSet()

        allAnswers.add(rightQuestion)
        allAnswers.add(wrongAnswers.get(0))
        allAnswers.add(wrongAnswers.get(1))
        allAnswers.add(wrongAnswers.get(3))

        binding.buttonAnswer1.text = allAnswers.elementAt(0).flag_name
        binding.buttonAnswer2.text = allAnswers.elementAt(1).flag_name
        binding.buttonAnswer3.text = allAnswers.elementAt(2).flag_name
        binding.buttonAnswer4.text = allAnswers.elementAt(3).flag_name

    }

    fun questionCounterControl(){
        questionCounter++

        if(questionCounter != 5){
            loadQuestion()
        }else{
            val intent = Intent(this@QuizActivity,ResultActivity::class.java)
            intent.putExtra("rightCounter",rightCounter)
            startActivity(intent)
            finish()
        }
    }

    fun rightControl(button: Button){
        val buttonText = button.text.toString()
        val rightAnswer = rightQuestion.flag_name

        if(buttonText == rightAnswer){
            rightCounter++
        }else{
            wrongCounter++
        }

        binding.textViewTrue.text = "True : $rightCounter"
        binding.textViewFalse.text = "False : $wrongCounter"
    }
}