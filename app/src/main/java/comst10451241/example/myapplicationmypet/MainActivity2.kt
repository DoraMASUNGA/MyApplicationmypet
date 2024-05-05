package comst10451241.example.myapplicationmypet

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    lateinit var progressBar: ProgressBar
    private lateinit var button: Button
    private lateinit var progressBar2: ProgressBar
    private val progressIncrements = floatArrayOf(0.25f, 0.25f, 0.25f, 0.25f) //this array is to store progress in the progress bar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val feedButton = findViewById<Button>(R.id.feedButton)
        val sleepButton = findViewById<Button>(R.id.sleepButton)
        val playButton = findViewById<Button>(R.id.playButton)
        val cleanButton = findViewById<Button>(R.id.cleanButton)

        //To change the pictures when the user presses a button:
        val imageView = findViewById<ImageView>(R.id.imageView3)

        //sleep button:
        sleepButton.setOnClickListener {
            imageView.setImageResource(R.drawable.toodles_is_now_asleep)
        }

        //feed button:
        feedButton.setOnClickListener {
            imageView.setImageResource(R.drawable.i_love_candy)
        }
        //clean button:
        cleanButton.setOnClickListener {
            imageView.setImageResource(R.drawable.time_to_wash_up)
        }
        //play button:
        playButton.setOnClickListener {
            imageView.setImageResource(R.drawable.toodles_is_now_asleep__1_)
        }


        //progress bar for all of the activities

        progressBar = findViewById(R.id.progressBar2)
        button = findViewById(R.id.sleepButton)
        button = findViewById(R.id.cleanButton)
        button = findViewById(R.id.playButton)
        button = findViewById(R.id.feedButton)
        val progressBar2 = findViewById<ProgressBar>(R.id.progressBar2)

        progressBar2.max = 100 //The maximum value the bar can reach is 100

        cleanButton.setOnClickListener { //clean prompt in the progress bar
            val currentProgress = progressBar2.progress
            val newProgress = (currentProgress + 25).coerceIn(1, progressBar2.max)
            progressBar2.progress = newProgress
            progressBar2.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.time_to_wash_up)


            playButton.setOnClickListener {
                val currentProgress = progressBar2.progress    //play prompt in the progress bar
                val newProgress = (currentProgress + 25).coerceIn(1, progressBar2.max)
                progressBar2.progress = newProgress
                progressBar2.visibility = View.VISIBLE
                imageView.setImageResource(R.drawable.toodles_is_now_asleep__1_)



                feedButton.setOnClickListener {
                    val currentProgress = progressBar2.progress    //play prompt in the progress bar
                    val newProgress = (currentProgress + 25).coerceIn(1, progressBar2.max)
                    progressBar2.progress = newProgress
                    progressBar2.visibility = View.VISIBLE
                    imageView.setImageResource(R.drawable.i_love_candy)


                    sleepButton.setOnClickListener {      //sleep prompt in the progress bar
                        val currentProgress = progressBar2.progress
                        val newProgress = (currentProgress + 25).coerceIn(1, progressBar2.max)
                        progressBar2.progress = newProgress
                        progressBar2.visibility = View.VISIBLE
                        imageView.setImageResource(R.drawable.toodles_is_now_asleep)



                        fun updateProgress(buttonIndex: Int) {
                            val currentProgress = progressBar2.progress
                            val newProgress = currentProgress + (progressBar2.max)
                        }

                        //this will take the user tho the 3rd page after the progress bar has reached 100

                        progressBar2.max = 100
                        progressBar2.min = 25
                        if (newProgress == progressBar2.max) {
                            button.isEnabled = false
                        } else
                            progressBar2.visibility = View.VISIBLE

                        val intent = Intent(this, MainActivity5::class.java)
                        startActivity(intent)

                    }

                }

            }
        }
    }
}
