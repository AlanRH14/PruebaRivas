package curso.kotlin.pruebarivas.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import curso.kotlin.pruebarivas.MovementAdapter
import curso.kotlin.pruebarivas.MovementsModel
import curso.kotlin.pruebarivas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var linearLayout: RecyclerView.LayoutManager
    private lateinit var movementAdapter: MovementAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movementAdapter = MovementAdapter(getMovements())
        linearLayout = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayout
            adapter = movementAdapter
        }

        binding.imgSendPay.setOnClickListener {
            val intent = Intent(this, SendPayActivity::class.java)
            startActivity(intent)
        }

        binding.imgCardSetting.setOnClickListener {
            val intent = Intent(this, GeneralSettingsActivity::class.java)
            intent.putExtra("typeCard", "Debito")
            startActivity(intent)
        }

        binding.imgNext.setOnClickListener {
            val intent = Intent(this, DigitalCardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getMovements(): MutableList<MovementsModel> {
        val movement = mutableListOf<MovementsModel>()
        val moventOxxo = MovementsModel(1, "Compra en Oxxo", "14 Abr 2021", "$70.00", "EGRESO")
        val moventQr = MovementsModel(2, "Pago con QR", "14 Abr 2021", "$230.00", "EGRESO")
        val moventTraspaso = MovementsModel(3, "Traspaso a cuenta", "14 Abr 2021", "$200.00", "INGRESO")
        val moventQr2 = MovementsModel(4, "Pago con QR", "14 Abr 2021", "$15.00", "EGRESO")
        val moventQr3 = MovementsModel(4, "Pago con QR", "22 Abr 2021", "$1500.00", "EGRESO")

        movement.add(moventOxxo)
        movement.add(moventQr)
        movement.add(moventTraspaso)
        movement.add(moventQr2)
        movement.add(moventQr3)

        return movement
    }
}