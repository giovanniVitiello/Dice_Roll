package android.corso.it.dice_roller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var dice_image : ImageView /*l'attributo lateinit indica a kotlin che stiamo dichiarando una variabile
                                          che inizializzeremo prima di lanciare il programma, senza quest'attributo
                                          kotlin da errore, in quanto non accetta variabili non inizializzate, o
                                          dovremmo inizializzarla a null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        roll_button.text = "Let's roll"
        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        dice_image = findViewById(R.id.dice_image)
        }
        
    }
    private fun rollDice(){
        
        val randomInt = Random.nextInt(6) + 1

        val drawable = when(randomInt){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }

        dice_image.setImageResource(drawable)
    }


}
