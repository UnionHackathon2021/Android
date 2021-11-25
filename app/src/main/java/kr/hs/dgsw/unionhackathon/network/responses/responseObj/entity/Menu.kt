package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

import android.os.Parcel
import android.os.Parcelable

data class Menu(
    val title: String,
    val detail: String,
    val price: Int,
    val image: String,
    val option: List<Option>
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.createTypedArrayList(Option) ?: ArrayList<Option>()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(detail)
        parcel.writeInt(price)
        parcel.writeString(image)
        parcel.writeTypedList(option)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Menu> {
        override fun createFromParcel(parcel: Parcel): Menu {
            return Menu(parcel)
        }

        override fun newArray(size: Int): Array<Menu?> {
            return arrayOfNulls(size)
        }
    }
}
