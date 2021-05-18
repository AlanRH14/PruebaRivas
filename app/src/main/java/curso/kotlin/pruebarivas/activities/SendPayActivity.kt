package curso.kotlin.pruebarivas.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import curso.kotlin.pruebarivas.R
import curso.kotlin.pruebarivas.databinding.ActivitySendPayBinding

class SendPayActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySendPayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendPayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        var drawable = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
        drawable = DrawableCompat.wrap(drawable!!)
        DrawableCompat.setTint(drawable, ContextCompat.getColor(this, R.color.color_purple))
        supportActionBar!!.setHomeAsUpIndicator(drawable)

        binding.toolbar.setNavigationOnClickListener { finish() }
    }
}