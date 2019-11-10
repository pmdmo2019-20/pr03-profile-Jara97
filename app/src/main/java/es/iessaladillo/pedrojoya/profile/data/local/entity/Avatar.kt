package es.iessaladillo.pedrojoya.profile.data.local.entity

import android.os.Parcel
import android.os.Parcelable

// TODO: Avatar class

class Avatar(val id: Int, val drawable: Int, val name: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(drawable)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Avatar> {
        override fun createFromParcel(parcel: Parcel): Avatar {
            return Avatar(parcel)
        }

        override fun newArray(size: Int): Array<Avatar?> {
            return arrayOfNulls(size)
        }
    }

}
