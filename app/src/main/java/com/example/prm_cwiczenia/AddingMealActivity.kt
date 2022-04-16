package com.example.prm_cwiczenia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prm_cwiczenia.databinding.ActivityAddingMealBinding
import com.example.prm_cwiczenia.databinding.ActivityMainBinding

class AddingMealActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddingMealBinding.inflate(layoutInflater)}
    private var chosenImage : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageButtonBigos.setImageResource(R.drawable.bigos);
        binding.imageButtonPierogi.setImageResource(R.drawable.pierogi);
        binding.imageButtonPizza.setImageResource(R.drawable.pizza);

        val density = resources.displayMetrics.density
        println("desnity $density")

        binding.buttonCancel.setOnClickListener{
           val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.buttonAddMeal.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("title", binding.textViewTitleInput.text.toString())
            intent.putExtra("indigents", binding.textMultiLineIndigientsInput.text.toString())
            intent.putExtra("chosenImage", chosenImage.toString())
            startActivity(intent);
        }

        binding.imageButtonPierogi.setOnClickListener{
            setChosenImage(R.drawable.pierogi)
        }
        binding.imageButtonBigos.setOnClickListener{
            setChosenImage(R.drawable.bigos)
        }
        binding.imageButtonPizza.setOnClickListener{
            setChosenImage(R.drawable.pizza)
        }
    }

    private fun setChosenImage(imageId: Int){
        binding.imageButtonChosenImage.setImageResource(imageId)
        chosenImage = imageId
    }
}