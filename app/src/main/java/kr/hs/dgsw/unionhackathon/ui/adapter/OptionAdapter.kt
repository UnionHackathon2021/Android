package kr.hs.dgsw.unionhackathon.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.unionhackathon.databinding.ItemOptionCheckboxBinding
import kr.hs.dgsw.unionhackathon.databinding.ItemOptionRadioBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Check
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Option
import kr.hs.dgsw.unionhackathon.ui.viewmodel.MenuDetailViewModel
import java.lang.IllegalArgumentException

class OptionAdapter(
    private val viewModel: MenuDetailViewModel
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = ArrayList<Option>()

    companion object {
        const val CHECKBOX = 0
        const val RADIO_BUTTON = 1
    }

    fun getTotalPrice(): Int {
        var totalPrice = 0
        list.forEach { totalPrice += it.defaultPrice }
        return totalPrice
    }

    fun submitList(newList: List<Option>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class CheckboxViewHolder(
        private val binding: ItemOptionCheckboxBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(option: Option) {
            val checkBoxAdapter = CheckBoxAdapter {
                option.defaultPrice = it
                viewModel.priceEvent.call()
            }
            binding.tvCheckBoxListNameOption.text = option.title
            binding.rvCheckBoxListOption.adapter = checkBoxAdapter
            checkBoxAdapter.submitList(option.optionList)
        }
    }

    inner class RadioButtonViewHolder(
        private val binding: ItemOptionRadioBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(option: Option) {
            option.optionList.forEach {
                val radioButton = RadioButton(itemView.context)
                radioButton.text = String.format("%s (%,d원 추가)", it.title, it.price)
                radioButton.layoutParams =
                    ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
                binding.radioGroupOption.addView(radioButton)
            }

            (binding.radioGroupOption[0] as RadioButton).isChecked = true

            binding.tvRadioButtonListNameOption.text = option.title

            binding.radioGroupOption.setOnCheckedChangeListener { group, checkedId ->
                val checkedButton = itemView.findViewById<RadioButton>(checkedId)
                val index = binding.radioGroupOption.indexOfChild(checkedButton)
                option.defaultPrice = option.optionList[index].price
                viewModel.priceEvent.call()
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].isCheckBox) CHECKBOX else RADIO_BUTTON
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            CHECKBOX -> {
                val binding = ItemOptionCheckboxBinding.inflate(inflater)
                binding.root.layoutParams = ViewGroup.LayoutParams(
                    MATCH_PARENT, WRAP_CONTENT
                )
                CheckboxViewHolder(binding)
            }
            RADIO_BUTTON -> {
                val binding = ItemOptionRadioBinding.inflate(inflater)
                binding.root.layoutParams = ViewGroup.LayoutParams(
                    MATCH_PARENT, WRAP_CONTENT
                )
                RadioButtonViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Illegal ViewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is CheckboxViewHolder -> {
                holder.bind(list[position])
            }
            is RadioButtonViewHolder -> {
                holder.bind(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}