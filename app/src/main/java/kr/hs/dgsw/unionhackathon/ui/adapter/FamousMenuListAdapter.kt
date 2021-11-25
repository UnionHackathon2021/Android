package kr.hs.dgsw.unionhackathon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.unionhackathon.databinding.ItemStoreFamousMenuBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Menu

class FamousMenuListAdapter: RecyclerView.Adapter<FamousMenuListAdapter.ViewHolder>() {
    private val list = ArrayList<Menu>()

    fun submitList(newList: List<Menu>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: ItemStoreFamousMenuBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(menu: Menu) {
            binding.menu = menu
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoreFamousMenuBinding.inflate(inflater)
        binding.root.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
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