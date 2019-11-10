package es.iessaladillo.pedrojoya.profile.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.profile.R
import es.iessaladillo.pedrojoya.profile.data.local.entity.Avatar
import es.iessaladillo.pedrojoya.profile.ui.avatar.AvatarActivity
import es.iessaladillo.pedrojoya.profile.ui.viewModel.ProfileViewModel
import es.iessaladillo.pedrojoya.profile.utils.*
import kotlinx.android.synthetic.main.profile_activity.*
import kotlinx.android.synthetic.main.profile_form.*
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.profile.data.local.Database.queryAllAvatars


class ProfileActivity : AppCompatActivity() {

    private  val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)
        setListeners()
        setData()
        txtName.requestFocus()
        // TODO
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        setData()
    }

    override fun onResume() {
        super.onResume()
        setData()
    }

    private fun setData() {
        imgAvatar.setImageResource(viewModel.getAvatar().drawable)

        txtName.setText(viewModel.name)
        txtEmail.setText(viewModel.email)
        txtPhone.setText(viewModel.number)
        txtAdress.setText(viewModel.adress)
        txtWeb.setText(viewModel.web)
        lblAvatar.text = viewModel.getAvatar().name

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.profile_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setListeners() {
        imgEmail.setOnClickListener { startActivity(newEmailIntent(txtEmail.text.toString())) }
        imgPhone.setOnClickListener { startActivity(newDialIntent(txtPhone.text.toString())) }
        imgAdress.setOnClickListener { startActivity(newSearchInMapIntent(txtAdress.text.toString())) }
        imgWeb.setOnClickListener{ startActivity(newWebSearchIntent(txtWeb.text.toString())) }
        imgAvatar.setOnClickListener{ startActivity(Intent(this,AvatarActivity::class.java)) }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnuSave) {
            save()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun save() {

        txtName.hideSoftKeyboard()

        if(txtName.text.toString().isBlank()){
            txtName.requestFocus()
            txtName.setError("Name is required")
        }
        else if(!txtEmail.text.toString().isValidEmail()){
            txtEmail.requestFocus()
            txtEmail.setError("Invalid email")

        }
        else if(!txtPhone.text.toString().isValidPhone()){
            txtPhone.requestFocus()
            txtPhone.setError("Invalid Phone")

        }
        else if(txtAdress.text.toString().isBlank()){
            txtAdress.requestFocus()
            txtAdress.setError("Adress is required")

        }
        else if(!txtWeb.text.toString().isValidUrl()){
            txtWeb.requestFocus()
            txtWeb.setError("Invalid Url")
        }
        else{
            viewModel.saveAvatar(viewModel.getAvatar())
            viewModel.saveData(txtName.text.toString(),txtEmail.text.toString(),txtPhone.text.toString(),txtAdress.text.toString(),txtWeb.text.toString())
            this.toast("User saved successfully")
        }

    }
}
