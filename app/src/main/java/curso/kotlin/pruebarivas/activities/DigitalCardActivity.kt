package curso.kotlin.pruebarivas.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import curso.kotlin.pruebarivas.databinding.ActivityDigitalCardBinding

class DigitalCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDigitalCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDigitalCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgClose.setOnClickListener { finish() }

        binding.cardDigital.setOnClickListener {
            val intent = Intent(this, GeneralSettingsActivity::class.java)
            intent.putExtra("typeCard", "Digital")
            startActivity(intent)
        }
    }
}