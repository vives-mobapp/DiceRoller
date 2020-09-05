package be.vives.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Heel belangrijk dat je geen bewerkingen voor de super calls doet!
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun rollDice() {

        // Genereer een willekeurig getal tussen 1 en 6.
        val nOfEyes = Random.nextInt(6) + 1

        // Beslis welke afbeelding overeenkomt met het juist gegenereerde getal.
        // Je kan een afbeelding opvragen via R.drawable.<naam>
        val whichImage = when (nOfEyes) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Vraag de ImageView op via zijn ID.
        val diceImageView: ImageView = findViewById(R.id.diceImageView)

        // Het is nu heel gemakkelijk om de afbeelding van je ImageView te wijzigen
        // via de functie .setImageResource
        diceImageView.setImageResource(whichImage)
    }

    // Vanaf deze functie opgeroepen wordt, is je content geladen.
    override fun onStart() {

        // Heel belangrijk dat je geen bewerkingen voor de super calls doet!
        super.onStart()

        // Vraag de Button op via zijn ID.
        val rollButton: Button = findViewById(R.id.roll_button)

        // Voeg een onClickListener toe aan je Button.
        rollButton.setOnClickListener {
            // Toon een Toast voor een bepaalde periode.
            Toast.makeText(this, "they see me rollin'", Toast.LENGTH_SHORT).show()

            // Rol de dobbelsteen.
            rollDice()
        }
    }
}

