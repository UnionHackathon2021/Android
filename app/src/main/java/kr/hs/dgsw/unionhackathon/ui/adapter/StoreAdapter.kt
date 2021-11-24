package kr.hs.dgsw.unionhackathon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.unionhackathon.databinding.ItemMenuListBinding
import kr.hs.dgsw.unionhackathon.databinding.ItemStoreFamousMenuListBinding
import kr.hs.dgsw.unionhackathon.databinding.ItemStoreHeaderBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Category
import kr.hs.dgsw.unionhackathon.ui.viewmodel.StoreInfoViewModel

class StoreAdapter(
    private val viewModel: StoreInfoViewModel
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = ArrayList<Category>()

    fun submitList(newList: List<Category>) {
        val categoryList = arrayListOf(
            Category("", "", ArrayList(), true),
            Category("", "", ArrayList(), true),
        )
        categoryList.addAll(newList)

        list.clear()
        list.addAll(categoryList)

        notifyDataSetChanged()
    }

    inner class ItemHeaderViewHolder(
        private val binding: ItemStoreHeaderBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.vm = viewModel
        }
    }

    inner class ItemHeaderFamousMenuViewHolder(
        private val binding: ItemStoreFamousMenuListBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val adapter = FamousMenuListAdapter()
            viewModel.store.value?.let {
                binding.rvFamousMenuList.adapter = adapter
                adapter.submitList(it.famousMenuList)
            }
        }
    }

    inner class ItemViewHolder(
        private val binding: ItemMenuListBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.category = category

            val adapter = MenuListAdapter()
            binding.rvMenuList.adapter = adapter
            adapter.submitList(category.menuList)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (list[position].isHeader) {
            return when (position) {
                0 -> FIRST_HEADER
                1 -> FAMOUS_MENU_HEADER
                else -> throw IllegalStateException("Not Found ViewHolder Type")
            }
        }
        return ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            FIRST_HEADER -> {
                val binding = ItemStoreHeaderBinding.inflate(inflater)
                binding.root.layoutParams = ViewGroup.LayoutParams(
                    MATCH_PARENT,
                    WRAP_CONTENT
                )
                ItemHeaderViewHolder(binding)
            }

            FAMOUS_MENU_HEADER -> {
                val binding = ItemStoreFamousMenuListBinding.inflate(inflater)
                binding.root.layoutParams = ViewGroup.LayoutParams(
                    MATCH_PARENT,
                    WRAP_CONTENT
                )
                ItemHeaderFamousMenuViewHolder(binding)
            }

            ITEM -> {
                val binding = ItemMenuListBinding.inflate(inflater)
                binding.root.layoutParams = ViewGroup.LayoutParams(
                    MATCH_PARENT,
                    WRAP_CONTENT
                )
                ItemViewHolder(binding)
            }

            else -> throw IllegalStateException("Not Found ViewHolder Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemHeaderViewHolder -> {
                holder.bind()
            }
            is ItemHeaderFamousMenuViewHolder -> {
                holder.bind()
            }
            is ItemViewHolder -> {
                holder.bind(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    companion object {
        private const val ITEM = 0
        private const val FIRST_HEADER = 1
        private const val FAMOUS_MENU_HEADER = 2
    }
}