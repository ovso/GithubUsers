package io.github.ovso.githubusers.data.prefs

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ConfigPreference(context: Context) {

  private val applicationContext = context.applicationContext
  private val dataStore: DataStore<Preferences> = applicationContext.createDataStore("config_prefs")


  companion object {
    val CONFIG_FIRST_RUN = booleanPreferencesKey("CONFIG_FIRST_RUN")
  }

  suspend fun storeFirstRun(flag: Boolean) {
    dataStore.edit {
      it[CONFIG_FIRST_RUN] = flag
    }
  }

  suspend fun isFirstRun(): Flow<Boolean> {
    return dataStore.data.map {
      it[CONFIG_FIRST_RUN] ?: false
    }
  }
}
