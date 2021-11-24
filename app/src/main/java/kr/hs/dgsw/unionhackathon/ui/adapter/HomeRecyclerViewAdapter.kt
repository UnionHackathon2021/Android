package kr.hs.dgsw.unionhackathon.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.unionhackathon.databinding.RvItemHomeBinding

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

    private val list: MutableList<String> = mutableListOf()
    private lateinit var binding: RvItemHomeBinding

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RvItemHomeBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]

        val id = 0
        // todo 값 저장 및 onClick 이벤트
        binding.layoutRvItemHome.setOnClickListener {
            setOnClickHomeItemListener.onClick(id)
        }
    }

    override fun getItemCount(): Int =
        list.size

    fun setList(list: List<String>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}