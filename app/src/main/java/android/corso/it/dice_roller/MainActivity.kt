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

    lateinit var dice_image : ImageView /*l'attributo lateinit indica a kotlin che stiamo dichiarando una variabile
                                          che inizializzeremo prima di lanciare il programma, senza quest'attributo
                                          kotlin da errore, in quanto non accetta variabili non inizializzate, o
                                          dovremmo inizializzarla a null*/
    lateinit var dice_image_2 : ImageView

    lateinit var delete_image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        roll_button.text = "Let's roll"

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            RollDice()
        }
        dice_image = findViewById(R.id.dice_image)/*findViwById collega un elemento dal xml ad una variabile
                                                    del codice kotlin*/
        dice_image_2 = findViewById(R.id.dice_image_2)

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

    private fun RollDice(){
        dice_image.setImageResource(getDiceImage())/*setImageResource si usa per modificare un immagine ed assegnarla
                                                    ad una variabile (dice_image) di tipo ImageView. E' possibile
                                                    fare riferime ad immagini specifiche già caricate sotto la cartella
                                                    res -> drawable utilizzando il comando R.drawable.<nome_image>*/
        dice_image_2.setImageResource(getDiceImage())
    }

    private fun getDiceImage() : Int{

        val randomInt = Random.nextInt(6) + 1

        return when(randomInt){
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
}
