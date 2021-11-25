package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

import android.os.Parcel
import android.os.Parcelable

data class Check(
    val title: String,
    val isChecked: Boolean,
    val price: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeByte(if (isChecked) 1 else 0)
        parcel.writeInt(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Check> {
        override fun createFromParcel(parcel: Parcel): Check {
            return Check(parcel)
        }

        override fun newArray(size: Int): Array<Check?> {
            return arrayOfNulls(size)
        }
    }

}