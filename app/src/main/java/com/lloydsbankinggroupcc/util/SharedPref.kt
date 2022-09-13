package com.lloydsbankinggroupcc.util

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.lloydsbankinggroupcc.network.ApiClient

class SharedPref {

    companion object {
        private const val AUTH_TOKEN_KEY_enc = "com.lloydsbankinggroupcc.enc_prefs.auth_token"
    }

    private val masterKeyAlias: MasterKey = MasterKey.Builder(petAppContext())
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptedSharedPreference = EncryptedSharedPreferences.create(
        petAppContext(),
        "lloydsbankinggroupcc_shared_prefs",
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private fun setEncryptedString(value: String) {
        with(encryptedSharedPreference.edit()) {
            putString(AUTH_TOKEN_KEY_enc, value)
            apply()
        }
    }

    private fun getEncryptedString(key: String, defValue: String = ""): String {
        return encryptedSharedPreference.getString(key, defValue) ?: defValue
    }


    var authToken: String
        get() = getEncryptedString(AUTH_TOKEN_KEY_enc)
        set(value) {
            setEncryptedString(value)
            ApiClient.resetRetrofitClient()
        }
}