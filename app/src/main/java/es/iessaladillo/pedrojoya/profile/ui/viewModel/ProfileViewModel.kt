package es.iessaladillo.pedrojoya.profile.ui.viewModel

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.profile.data.local.Database.queryAllAvatars
import es.iessaladillo.pedrojoya.profile.data.local.Database.queryDefaultAvatar
import es.iessaladillo.pedrojoya.profile.data.local.entity.Avatar
import es.iessaladillo.pedrojoya.profile.ui.main.ProfileActivity
import java.io.Serializable
import java.util.*
import java.util.function.Predicate

class ProfileViewModel() : ViewModel(){


    var name: String=""
        private set
    var email: String=""
        private set
    var number: String=""
        private set
    var adress: String=""
        private set
    var web: String=""
        private set


    fun saveAvatar(avatar:Avatar) {
        setAvatar(avatar)
    }

    fun getAvatar():Avatar{
        return avatar.value ?: queryDefaultAvatar()
    }

    fun saveData(name: String, email: String, number: String, adress: String, web: String) {
        this.name=name
        this.email=email
        this.number=number
        this.adress=adress
        this.web=web
    }

    fun changeAvatar(id:Int):Avatar{
        return queryAllAvatars().get(id)
    }

companion object{
      var avatar: MutableLiveData<Avatar> = MutableLiveData(queryDefaultAvatar())
     fun setAvatar(avatar:Avatar){
         this.avatar.value=avatar
    }
}






}