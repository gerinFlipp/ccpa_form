package com.example.ccpaformkotlin

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {

    val firstName = MutableLiveData<String?>("")
    val lastName = MutableLiveData<String?>("")
    val email = MutableLiveData<String?>("")
    val radioChecked = MutableLiveData<Int?>()
    val agreeToTerms = MutableLiveData<Boolean>(false)  // this shouldn't be null


    val valid = MediatorLiveData<Boolean>().apply {
        addSource(firstName) {
            value = checkFields()
        }
        addSource(lastName) {
            value = checkFields()
        }
        addSource(email) {
            value = checkFields()
        }
        addSource(radioChecked) {
            value = checkFields()
        }
        addSource(agreeToTerms) {
            value = checkFields()
        }
    }

    fun checkFields() : Boolean {
        if (firstName.value.isNullOrBlank()) {
            return false
        }
        if (lastName.value.isNullOrBlank()) {
            return false
        }
        if (validateIncorrectEmail(email.value)) {
            return false
        }
        if (radioChecked.value != R.id.Ccpa_radiogroup_option_get_data
            && radioChecked.value != R.id.Ccpa_radiogroup_option_delete_data
            && radioChecked.value != R.id.Ccpa_radiogroup_option_sell_data) {
            return false
        }
        if (agreeToTerms.value != true) {
            return false
        }
        return true
    }

    fun validateIncorrectEmail(emailInput : String?) :Boolean {
        if (emailInput.isNullOrBlank()) {
            return true
        }
       return !android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()
    }

}