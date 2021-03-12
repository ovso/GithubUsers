package io.github.ovso.githubusers.data.prefs

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore

class ConfigPreference(context: Context) {

  private val applicationContext = context.applicationContext
  private val dataStore: DataStore<Preferences> = applicationContext.createDataStore("config_prefs")



}
