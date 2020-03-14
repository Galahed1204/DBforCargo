package `fun`.gladkikh.cargologistic.db.helpers

import androidx.room.Entity
import androidx.room.PrimaryKey


data class UnitMeasureHelp(
    //@PrimaryKey(autoGenerate = true) val id:Long,
    val code: String,
    val name: String,
    val coff: Float,
    val current: Boolean){

}