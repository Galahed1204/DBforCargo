package `fun`.gladkikh.cargologistic.db.entities

import `fun`.gladkikh.cargologistic.db.convert.UniversalListConverter
import `fun`.gladkikh.cargologistic.db.helpers.UnitMeasureHelp
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "product")
data class ProductDB(
            @PrimaryKey @ColumnInfo(name = "guid",index = true)
            val guid: String,
            val goodsName:String,
            @TypeConverters(UniversalListConverter::class) val listUnitMeasureDB: List<UnitMeasureHelp>
)