package kr.hs.dgsw.unionhackathon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.unionhackathon.databinding.ItemCheckboxBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Check

class CheckBoxAdapter(val onCheckedChanged: (Int) -> Unit): RecyclerView.Adapter<CheckBoxAdapter.ViewHolder>() {

    private var total = 0
    private val list = ArrayList<Check>()

    fun submitList(newList: List<Check>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: ItemCheckboxBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(check: Check) {
            binding.check = check
            binding.chkOption.setOnCheckedChangeListener { buttonView, isChecked ->
                total += if (isChecked) check.price else -(check.price)
                onCheckedChanged.invoke(total)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCheckboxBinding.inflate(LayoutInflater.from(parent.context))
        binding.root.layoutParams = ViewGroup.LayoutParams(
            MATCH_PARENT, WRAP_CONTENT
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}