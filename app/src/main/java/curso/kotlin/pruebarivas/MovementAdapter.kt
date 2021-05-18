package curso.kotlin.pruebarivas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import curso.kotlin.pruebarivas.databinding.ItemCardMovementBinding

class MovementAdapter(
    private var movements: MutableList<MovementsModel>
) : RecyclerView.Adapter<MovementAdapter.ViewHolder>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_card_movement, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movemet = movements[position]

        with(holder) {
            if (movemet.typeMovement.equals("INGRESO")) {
                binding.imgBack.setImageResource(R.drawable.ic_arrow_forward)
                binding.imgBack.setColorFilter(
                    ContextCompat.getColor(
                        mContext,
                        R.color.green_color
                    )
                )
            } else {
                binding.imgBack.setImageResource(R.drawable.ic_arrow_back)
                binding.imgBack.setColorFilter(
                    ContextCompat.getColor(
                        mContext,
                        R.color.red_color
                    )
                )
            }

            binding.tvName.text = movemet.titleMovement
            binding.tvDate.text = movemet.date
            binding.tvAmount.text = movemet.amount
        }
    }

    override fun getItemCount(): Int = movements.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCardMovementBinding.bind(view)

    }
}