package `fun`.gladkikh.cargologistic.db.dao

import `fun`.gladkikh.cargologistic.common.type.Either
import `fun`.gladkikh.cargologistic.common.type.Failure
import `fun`.gladkikh.cargologistic.db.entities.BarcodeDB
import `fun`.gladkikh.cargologistic.db.entities.PrintDB
import `fun`.gladkikh.cargologistic.db.entities.ProductDB
import `fun`.gladkikh.cargologistic.db.helpers.ProductWithBarcode
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface ProductDao {
    @Query("SELECT * FROM product WHERE guid = :guid")
    fun getProductByGuidFlowable(guid: String): Flowable<ProductDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductCompletable(ProductDB: ProductDB): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(ProductDB: ProductDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBarcode(barcode:BarcodeDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListBarcode(barcode:List<BarcodeDB>)

    @Query("DELETE FROM product")
    fun deleteAllProduct()

    @Query("DELETE FROM product WHERE guid = :guid")
    fun deleteProductByGuid(guid:String)


    @Query("SELECT * FROM product")
    fun getAllProduct(): Array<ProductDB>

    @Query("SELECT * FROM product WHERE guid = :guid")
    fun getProductByGuid(guid: String): ProductDB


    @Query("SELECT product.guid, product.goodsName,product.listUnitMeasureDB FROM product,barcode WHERE barcode = :barcode")
    fun getProductByBarcodeFlow(barcode:String):Flowable<ProductDB>

    @Query("SELECT product.guid, product.goodsName,product.listUnitMeasureDB,product.listUnitMeasureDB FROM product,barcode WHERE barcode = :barcode")
    fun getProductByBarcode(barcode:String):ProductDB

//    @Query("SELECT product.guid, product.goodsName,barcode.guid FROM product,barcode WHERE barcode = :barcode")
    @Query("SELECT * FROM product,barcode WHERE barcode = :barcode")
    fun getProductWithBarcodeByBarcode(barcode:String):ProductWithBarcode

    @Query("SELECT barcode.barcode FROM barcode WHERE guidProduct = :guidProduct")
    fun getBarcodesByProduct(guidProduct:String):List<String>


    //printDAO
    @Query("SELECT * FROM print")
    fun getAllPrintLiveData():LiveData<List<PrintDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPrintDB(printDB: PrintDB)

}