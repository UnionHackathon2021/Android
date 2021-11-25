package kr.hs.dgsw.unionhackathon.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.ItemReviewBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Review

class ReviewRecyclerViewAdapter : RecyclerView.Adapter<ReviewRecyclerViewAdapter.ViewHolder>() {

    private val list: ArrayList<Review> = ArrayList()

    class ViewHolder(private val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(review: Review) {
            binding.data = review

            setWeight(review)

            val resourceId = when (review.sentiment) {
                "positive" -> R.drawable.ic_positive_filled
                "neutrality" -> R.drawable.ic_neutrality_filled
                "negative" -> R.drawable.ic_negative_filled
                else -> R.drawable.ic_positive_filled
            }

            binding.ivMostItemReview.background =
                ContextCompat.getDrawable(binding.root.context, resourceId)

            val menuAdapter = ReviewMenuRecyclerViewAdapter()
            binding.rvMenuRvItemReview.adapter = menuAdapter
            if (review.menu != null)
                menuAdapter.setList(review.menu)
        }

        private fun setWeight(review: Review) {
            binding.layout.weightSum = 100f

            val paramsPositive = LinearLayout.LayoutParams(0, MATCH_PARENT, review.positive.toFloat())
            val paramsNeutrality = LinearLayout.LayoutParams(0, MATCH_PARENT, review.neutral.toFloat())
            val paramsNegative = LinearLayout.LayoutParams(0, MATCH_PARENT, review.negative.toFloat())

            binding.positiveItemReview.layoutParams = paramsPositive

            binding.neutralityItemReview.layoutParams = paramsNeutrality

            binding.negativeItemReview.layoutParams = paramsNegative
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int =
        list.size

    fun setList(newList: List<Review>) {
        Log.d("TAG", "setList: $newList")
        this.list.clear()
        this.list.addAll(newList)
        notifyDataSetChanged()
    }
}