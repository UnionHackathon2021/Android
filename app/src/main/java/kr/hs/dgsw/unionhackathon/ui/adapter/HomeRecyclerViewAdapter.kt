package kr.hs.dgsw.unionhackathon.ui.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.RvItemHomeBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.StoreSummery

class HomeRecyclerViewAdapter: RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    interface OnClickHomeItemListener {
        fun onClick(id: Int)
    }

    private lateinit var setOnClickHomeItemListener: OnClickHomeItemListener

    fun setOnClickHomeItemListener(listener: (Int) -> Unit) {
        setOnClickHomeItemListener = object : OnClickHomeItemListener {
            override fun onClick(id: Int) {
                listener(id)
            }
        }
    }

    private val list: MutableList<StoreSummery> = mutableListOf()

    inner class ViewHolder(
        private val binding: RvItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(storeSummery: StoreSummery, position: Int) {
            binding.storeSummery = storeSummery
            binding.layoutRvItemHome.setOnClickListener {
                setOnClickHomeItemListener.onClick(position)
            }
            binding.imageView.load(storeSummery.image)
            when(storeSummery.percent) {
                in 0..33 -> {
                    binding.ivFeelingItemHome.setImageResource(R.drawable.ic_negative)
                    binding.ivPercentItemHome.setTextColor(
                        ResourcesCompat.getColor(
                            binding.root.resources,
                            R.color.negative,
                            binding.root.resources.newTheme()
                        )
                    )
                }

                in 33..66 -> {
                    binding.ivFeelingItemHome.setImageResource(R.drawable.ic_neutral)
                    binding.ivPercentItemHome.setTextColor(
                        ResourcesCompat.getColor(
                            binding.root.resources,
                            R.color.neutral,
                            binding.root.resources.newTheme()
                        )
                    )
                }

                in 66..100 -> {
                    binding.ivFeelingItemHome.setImageResource(R.drawable.ic_positive)
                    binding.ivPercentItemHome.setTextColor(
                        ResourcesCompat.getColor(
                            binding.root.resources,
                            R.color.positive,
                            binding.root.resources.newTheme()
                        )
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemHomeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int =
        list.size

    fun setList(list: List<StoreSummery>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}