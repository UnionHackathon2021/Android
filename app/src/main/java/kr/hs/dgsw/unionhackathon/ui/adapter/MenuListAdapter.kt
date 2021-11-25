package kr.hs.dgsw.unionhackathon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.ItemMenuBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Menu

class MenuListAdapter: RecyclerView.Adapter<MenuListAdapter.ViewHolder>() {

    private val list = ArrayList<Menu>()

    fun submitList(newList: List<Menu>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: ItemMenuBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(menu: Menu) {
            binding.menu = menu
            binding.btnOpenAddMenuPageMenu.setOnClickListener {
                val bundle = bundleOf("menu" to menu)
                it.findNavController().navigate(R.id.action_storeInfoFragment_to_menuDetailFragment, bundle)
            }
            binding.ivMenuItem.load(menu.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuBinding.inflate(inflater)
        binding.root.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuListAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}