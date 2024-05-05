IMAD Ice Task 5
ST10451241
Dora Dreshney Masunga


GitHub link:
https://github.com/DoraMASUNGA/MyApplicationmypet.git
YouTube Link:
https://youtu.be/F6LJsI5LvpY?si=HCuGnYb1ViCiGm5S
Tamagotchi App Research Findings:
The Tamagotchi app was created by Akihiro Yokoi of Wiz and Aki Maita of Bandi which is a toy company headquartered in Taito in Japan. The app was invented in 1996, which won the Nobel Prize in 1997 for economics. But unfortunately, the app got banned after the app distracted the users' daily lives.
The app Overview: the Tamagotchi App allows a user to visit a virtual world, play games, earn Points and items and basically raise the character. The app requires an iPhone, iPad, or any Android device to run, and a Bluetooth connection must be enabled in order to work.
 Pet being washed Pet eating
 Welcome Page Pet Playing

Purpose: 
Write a paragraph on the purpose of the app. It should mostly be entertainment/educational.
The app is for educational purposes. 

It teaches children responsibility and caring for other things and people. It is designed to entertain and engage with young users, particularly children, through interactive virtual simulation. Users can interact with the app, a digital character, by taking care of the pet and engaging in multiple activities like putting the app to sleep, feeding the mouse, bathing it and basically caring for the pet as a whole. The app's purpose is to provide a fun and interactive experience for users to bond with the pet and foster a sense of companionship while also offering educational elements such as problem-solving.

Design Considerations:
General design:
Does your design suit the users of the app? Is the design and pictures attractive to children? Use of colors in the design?
I later in my design process changed the images/pet form a Cat (Garfield) to a Mouse (Mickey).
The design of the app is suitable for young users. It has pictures that are highly stimulating to my target audience in a manner that is attractive to children. 
The app offers an iconic symbol of mickey mouse, that is easily identifiable to majority of the general public.
    
Intuitive design:
Is your design easy to follow? From top to bottom as users would expect?

Yes, the design is easy to follow and simple for kids to understand and work with. 
Theapp is designed from top to bottom. 

Content prioritization:
Did you include only the necessary interface elements?
Do you only display essential content and functionalities the user needs?

Only the necessary elements were added to the design of the app. Nothing added will confuse the user. 

Legible Text Content:
Did you use a font that is easy to read? Is the text size large enough?

Yes, the font that I used is easy to read and see. 
I used the font “sans-serif-condensed”, with a font size of 24sp.

Make Interface Elements Clearly Visible:
Can the user clearly see all components on the screen? Is it spaced well (not too crowded or too much space between them?
The user can clearly see all the components on the screen, the app design is spaced well and not too crowded or too spaced apart.

Hand Position Controls:
Are the buttons in a position where it will be easily reached by users?
The buttons are in a position where both left and right-handed users an efficiently use the app.


Images:
Why did you choose the specific images of the pet?
I chose the specific apps out of nostalgia from my childhood. Images that are very simple to interpret and images that convey one action to the user.
  



Code:
First Page: 
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Welcome Page
        //Button to enter to the next Page
        val toodlesButton = findViewById<Button>(R.id.toodlesButton)
        toodlesButton.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }
}





Second Page: 

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
Third Page:

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity5 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playagainButton = findViewById<Button>(R.id.playagainButton)
        playagainButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val exitButton = findViewById<Button>(R.id.exitButton)
        exitButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
Reference List:
// Android Developers. (n.d.). Create a view class | Views. [online] Available at: https://developer.android.com/develop/ui/views/layout/custom-views/create-view.
//Android Developers. (n.d.). ProgressBar. [online] Available at: https://developer.android.com/reference/android/widget/ProgressBar#inherited-fields [Accessed 5 May 2024].
//GeeksforGeeks. (2022). ProgressBar in Android. [online] Available at: https://www.geeksforgeeks.org/progressbar-in-android/ [Accessed 5 May 2024]
//Stack Overflow. (n.d.). Playing different sounds on different buttons. [online] Available at: https://stackoverflow.com/questions/59685586/playing-different-sounds-on-different-buttons [Accessed 5 May 2024].
//Stack Overflow. (n.d.). Setprogress for a progress bar across fragments android using Kotlin. [online] Available at: https://stackoverflow.com/questions/51701105/setprogress-for-a-progress-bar-across-fragments-android-using-kotlin [Accessed 5 May 2024].









Reference List:

Feldman, B. (2017). Congress Has Entered the War Over Garfield’s Gender. [online] Intelligencer. Available at: https://nymag.com/intelligencer/2017/03/congress-has-entered-the-war-over-garfields-gender.html. 
Pinterest. (n.d.). Garfield Cartoon: Fútbol | Odie and Garfield Playing Soccer. [online] Available at: https://za.pinterest.com/pin/107523509828467872/   [Accessed 19 Apr. 2024] 
Pinterest. (n.d.). Garfield Eating Popcorn Cartoon Vinyl Wall Decal | Garfield and odie, Garfield, Garfield cat. [online] Available at: https://www.pinterest.ca/pin/garfield-eating-popcorn-cartoon-vinyl-wall-decal--1049901731855121526/  [Accessed 19 Apr. 2024].
PNGitem.com. (n.d.). Transparent Garfield Clipart - Garfield Taking A Bath, HD Png Download , Transparent Png Image - PNGitem. [online] Available at: https://www.pngitem.com/middle/mxxTwm_transparent-garfield-clipart-garfield-taking-a-bath-hd/  [Accessed 19 Apr. 2024]. 
