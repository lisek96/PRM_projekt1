package com.example.prm_cwiczenia

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.prm_cwiczenia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("create")
        setContentView(binding.root)

        var mealCards : List<CardView> = listOf(binding.cardViewMeal1, binding.cardViewMeal2, binding.cardViewMeal3);
        for(mealCard in mealCards){
            val title : TextView = mealCard.getChildAt(1) as TextView
            if(title.text == ""){
                mealCard.visibility = View.INVISIBLE
            }
        }
        if(intent.getStringExtra("title") != null) {
            for (mealCard in mealCards) {
                if (mealCard.visibility == View.INVISIBLE) {
                    val title : TextView = mealCard.getChildAt(1) as TextView
                    val indigents : TextView = mealCard.getChildAt(2) as TextView
                    val mealImage : ImageView = mealCard.getChildAt(0) as ImageView
                    title.text = intent.getStringExtra("title").toString()
                    indigents.text = intent.getStringExtra("indigents").toString()
                    mealImage.setImageResource(intent.getStringExtra("chosenImage").toString().toInt())
                    mealCard.visibility = View.VISIBLE
                    break
                }
            }
        }
        binding.buttonAdd.setOnClickListener {
            val intent = Intent(this, AddingMealActivity::class.java)
            startActivity(intent);
        }

//        binding.buttonCheck.setOnClickListener {
//            val intent = Intent(this, WinScreen::class.java)
//            startActivity(intent);
//        }

    }

    override fun onStart() {
        super.onStart();
        println("starting");
    }

    override fun onResume() {
        super.onResume()
        println("resume");
    }

    override  fun onPause(){
        super.onPause();
        println("pause")
    }

    override fun onStop(){
        super.onStop()
        println("stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("destroy")
    }
}