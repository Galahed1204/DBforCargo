package `fun`.gladkikh.cargologistic.db.helpers

import `fun`.gladkikh.cargologistic.db.entities.BarcodeDB
import `fun`.gladkikh.cargologistic.db.entities.ProductDB
import androidx.room.Embedded
import androidx.room.Relation

data class ProductWithBarcode(
    @Embedded val productDB: ProductDB,
    @Relation(parentColumn = "guid",entityColumn = "guid")
    val barcodeList:List<BarcodeDB>
//    val guid: String,
//    val goodsName:String,
//    val barcodeList:List<BarcodeDB>
) {

}