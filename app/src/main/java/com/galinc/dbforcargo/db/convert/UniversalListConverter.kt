package `fun`.gladkikh.cargologistic.db.convert

import `fun`.gladkikh.cargologistic.db.helpers.UnitMeasureHelp
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UniversalListConverter {

        @TypeConverter
        fun fromListUnitMeasureHelp(myObjects: List<UnitMeasureHelp>?): String? {
            val gson = Gson()
            return gson.toJson(myObjects)
        }

        @TypeConverter
        fun toListUnitMeasureHelp(data: String?): List<UnitMeasureHelp>? {
            val gson = Gson()
            if (data == null) {
                return emptyList<UnitMeasureHelp>()
            }
            val listType = object : TypeToken<List<UnitMeasureHelp>>() {

            }.type
            return gson.fromJson<List<UnitMeasureHelp>>(data, listType)
        }

}