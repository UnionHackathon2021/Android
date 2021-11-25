package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

import android.os.Parcel
import android.os.Parcelable

data class Option(
    val title: String,
    val optionList: List<Check>,
    val isCheckBox: Boolean = false,
    var defaultPrice: Int = 0
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.createTypedArrayList(Check) ?: ArrayList<Check>(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeTypedList(optionList)
        parcel.writeByte(if (isCheckBox) 1 else 0)
        parcel.writeInt(defaultPrice)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Option> {
        override fun createFromParcel(parcel: Parcel): Option {
            return Option(parcel)
        }

        override fun newArray(size: Int): Array<Option?> {
            return arrayOfNulls(size)
        }
    }

}