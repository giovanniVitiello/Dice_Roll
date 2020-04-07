package android.corso.it.dice_roller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView /*l'attributo lateinit indica a kotlin che stiamo dichiarando una variabile
                                          che inizializzeremo prima di lanciare il programma, senza quest'attributo
                                          kotlin da errore, in quanto non accetta variabili non inizializzate, o
                                          dovremmo inizializzarla a null*/
    lateinit var diceImage2 : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        roll_button.text = "Let's roll"

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        
        val result1 : TextView = findViewById(R.id.result_1)
        val result2 : TextView = findViewById(R.id.result_2)
        val result3 : TextView = findViewById(R.id.result_3)
        val result4 : TextView = findViewById(R.id.result_4)
        val result5 : TextView = findViewById(R.id.result_5)
        val result6 : TextView = findViewById(R.id.result_6)

        val roll100 : Button = findViewById(R.id.roll_100)
        roll100.setOnClickListener {
            rollDice100()
        }


        diceImage = findViewById(R.id.dice_image)/*findViwById collega un elemento dal xml ad una variabile
                                                    del codice kotlin*/
        diceImage2 = findViewById(R.id.dice_image_2)

        val deleteButton : Button = findViewById(R.id.delete_dice)

        deleteButton.setOnClickListener {
            deleteImage()
        }
    }

    /**
     * Click listener for the Roll button.
     */
/* --------------un solo dado tirato---------------
    private fun rollDice(){
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()... the Toast need to see a little message when you press the button

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
*/

    /*------------ two dice roll -------------*/

    private fun rollDice(){
            dice_image.setImageResource(getDiceImage())/*setImageResource si usa per modificare un immagine ed assegnarla
                                                    ad una variabile (dice_image) di tipo ImageView. E' possibile
                                                    fare riferime ad immagini specifiche già caricate sotto la cartella
                                                    res -> drawable utilizzando il comando R.drawable.<nome_image>*/
            dice_image_2.setImageResource(getDiceImage())

    }

    private fun getDiceImage() : Int{

        return when(Random.nextInt(6) + 1){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
    }

    private fun deleteImage(){
        dice_image.setImageResource(R.drawable.empty_dice)
        dice_image_2.setImageResource(R.drawable.empty_dice)
    }


    private fun rollDice100(){
        var a = 0
        var b = 0
        var c = 0
        var d = 0
        var e = 0
        var f = 0
        for(i in 0..100){
            val result = Random.nextInt(6) + 1

            when (result) {
                1 -> a++
                2 -> b++
                3 -> c++
                4 -> d++
                5 -> e++
                6 -> f++
            }
        }
        result_1.text = a.toString()
        result_2.text = b.toString()
        result_3.text = c.toString()
        result_4.text = d.toString()
        result_5.text = e.toString()
        result_6.text = f.toString()
        rollDice()
    }

}
