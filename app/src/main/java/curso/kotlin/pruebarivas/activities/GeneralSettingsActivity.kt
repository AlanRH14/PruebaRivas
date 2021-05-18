package curso.kotlin.pruebarivas.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import curso.kotlin.pruebarivas.R
import curso.kotlin.pruebarivas.databinding.ActivityGeneralSettingsBinding

class GeneralSettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGeneralSettingsBinding
    var typeCard = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeneralSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            typeCard = intent.extras!!.getString("typeCard")!!
        } catch (e: Exception) {
            typeCard = ""
        }

        if (typeCard.equals("Digital"))
            binding.lytPhysicalCard.visibility = View.VISIBLE
        else
            binding.lytPhysicalCard.visibility = View.GONE

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = ""

        var drawable = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
        drawable = DrawableCompat.wrap(drawable!!)
        DrawableCompat.setTint(drawable, ContextCompat.getColor(this, R.color.color_purple))
        supportActionBar!!.setHomeAsUpIndicator(drawable)
        binding.toolbar.setNavigationOnClickListener { finish() }
    }
}