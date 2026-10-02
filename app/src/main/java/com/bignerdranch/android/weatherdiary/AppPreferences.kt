import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object AppPreferences {
    private const val PREFS_NAME = "WeatherDiaryPrefs"
    private const val KEY_USER = "user_json"
    private const val KEY_RECORDS = "records_json"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }


    fun saveUser(context: Context, user: User) {
        val json = Gson().toJson(user)
        getPrefs(context).edit().putString(KEY_USER, json).apply()
    }


    fun getUser(context: Context): User? {
        val json = getPrefs(context).getString(KEY_USER, null) ?: return null
        return Gson().fromJson(json, User::class.java)
    }


    fun saveRecords(context: Context, records: List<WeatherEntry>) {
        val json = Gson().toJson(records)
        getPrefs(context).edit().putString(KEY_RECORDS, json).apply()
    }


    fun getRecords(context: Context): List<WeatherEntry> {
        val json = getPrefs(context).getString(KEY_RECORDS, null) ?: return emptyList()
        val type = object : TypeToken<List<WeatherEntry>>() {}.type
        return Gson().fromJson(json, type)
    }


    fun clearUser(context: Context) {
        getPrefs(context).edit().remove(KEY_USER).apply()
    }
}