package es.iessaladillo.pedrojoya.profile.ui.avatar


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.profile.ui.viewModel.ProfileViewModel
import kotlinx.android.synthetic.main.avatar_activity.*
import es.iessaladillo.pedrojoya.profile.R
import es.iessaladillo.pedrojoya.profile.data.local.Database.queryAllAvatars
import es.iessaladillo.pedrojoya.profile.ui.main.ProfileActivity


class AvatarActivity : AppCompatActivity() {
    private var id:Int=1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avatar_activity)
        checkImage()
        setListeners()
        // TODO
    }

    private fun setListeners() {
        checkImg1.setOnCheckedChangeListener{ _, a:Boolean ->
            if(a){
                checkImg3.isChecked = false
                checkImg2.isChecked = false
                checkImg4.isChecked = false
                checkImg5.isChecked = false
                checkImg6.isChecked = false
                checkImg7.isChecked = false
                checkImg8.isChecked = false
                checkImg9.isChecked = false
                id=1
            }
            if(noImgChecked()){
                checkImg1.isChecked =true;
            }
        }
        checkImg3.setOnCheckedChangeListener{ _, a:Boolean ->
            if(a){
                checkImg1.isChecked = false
                checkImg2.isChecked = false
                checkImg4.isChecked = false
                checkImg5.isChecked = false
                checkImg6.isChecked = false
                checkImg7.isChecked = false
                checkImg8.isChecked = false
                checkImg9.isChecked = false
                id=7
            }
            if(noImgChecked()){
                checkImg3.isChecked =true
            }

        }
        checkImg2.setOnCheckedChangeListener{ _, a:Boolean ->
            if(a){
                checkImg1.isChecked = false
                checkImg3.isChecked = false
                checkImg4.isChecked = false
                checkImg5.isChecked = false
                checkImg6.isChecked = false
                checkImg7.isChecked = false
                checkImg8.isChecked = false
                checkImg9.isChecked = false
                id=4
            }
            if(noImgChecked()){
                checkImg2.isChecked =true;
            }

        }
        checkImg4.setOnCheckedChangeListener{ _, a:Boolean ->
            if(a){
                checkImg1.isChecked = false
                checkImg2.isChecked = false
                checkImg3.isChecked = false
                checkImg5.isChecked = false
                checkImg6.isChecked = false
                checkImg7.isChecked = false
                checkImg8.isChecked = false
                checkImg9.isChecked = false
                id=2
            }
            if(noImgChecked()){
                checkImg4.isChecked =true;
            }

        }
        checkImg5.setOnCheckedChangeListener{ _, a:Boolean ->
            if(a){
                checkImg1.isChecked = false
                checkImg2.isChecked = false
                checkImg4.isChecked = false
                checkImg3.isChecked = false
                checkImg6.isChecked = false
                checkImg7.isChecked = false
                checkImg8.isChecked = false
                checkImg9.isChecked = false
                id=5
            }
            if(noImgChecked()){
                checkImg5.isChecked =true;
            }

        }
        checkImg6.setOnCheckedChangeListener{ _, a:Boolean ->
            if(a){
                checkImg1.isChecked = false
                checkImg2.isChecked = false
                checkImg4.isChecked = false
                checkImg5.isChecked = false
                checkImg3.isChecked = false
                checkImg7.isChecked = false
                checkImg8.isChecked = false
                checkImg9.isChecked = false
                id=8
            }
            if(noImgChecked()){
                checkImg6.isChecked =true;
            }

        }
        checkImg7.setOnCheckedChangeListener{ _, a:Boolean ->
            if(a){
                checkImg1.isChecked = false
                checkImg2.isChecked = false
                checkImg4.isChecked = false
                checkImg5.isChecked = false
                checkImg6.isChecked = false
                checkImg3.isChecked = false
                checkImg8.isChecked = false
                checkImg9.isChecked = false
                id=3
            }
            if(noImgChecked()){
                checkImg7.isChecked =true;
            }

        }
        checkImg8.setOnCheckedChangeListener{ _, a:Boolean ->
            if(a){
                checkImg1.isChecked = false
                checkImg2.isChecked = false
                checkImg4.isChecked = false
                checkImg5.isChecked = false
                checkImg6.isChecked = false
                checkImg7.isChecked = false
                checkImg3.isChecked = false
                checkImg9.isChecked = false
                id=6
            }
            if(noImgChecked()){
                checkImg8.isChecked =true;
            }
        }
        checkImg9.setOnCheckedChangeListener{ _, a:Boolean ->
            if(a){
                checkImg1.isChecked = false
                checkImg2.isChecked = false
                checkImg4.isChecked = false
                checkImg5.isChecked = false
                checkImg6.isChecked = false
                checkImg7.isChecked = false
                checkImg8.isChecked = false
                checkImg3.isChecked = false
                id=9
            }
            if(noImgChecked()){
                checkImg9.isChecked =true;
            }

        }
    }

    private fun noImgChecked(): Boolean {
        if(!checkImg1.isChecked&&
            !checkImg2.isChecked&&
            !checkImg3.isChecked&&
            !checkImg4.isChecked&&
            !checkImg5.isChecked&&
            !checkImg6.isChecked&&
            !checkImg7.isChecked&&
            !checkImg8.isChecked&&
            !checkImg9.isChecked){

                return true
        }
            return false

    }

    private fun checkImage() {
        checkImg1.isChecked = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.avatar_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnuSelect) {
            ProfileViewModel.setAvatar(queryAllAvatars()[id-1])
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        const val EXTRA_AVATAR = "EXTRA_AVATAR"

    }

}


