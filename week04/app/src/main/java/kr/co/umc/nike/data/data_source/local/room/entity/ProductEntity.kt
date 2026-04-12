package kr.co.umc.nike.data.data_source.local.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ProductTable",
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],      // Category의 PK
            childColumns = ["categoryId"], // Product의 FK
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, //Primary Key (자동 생성)
    val name: String, //이름
    val content: String, // 상세 내용
    val productDescription: String, // 간단 설명
    val colorNum: Int, //컬러 개수
    val productImage: Int, //이미지 소스
    val price: Int, //가격
    val isWished: Boolean, //위시 여부
    val isNew: Boolean, //신상품 여부
    val isBestSeller: Boolean, //베스트셀러 여부
    val categoryId: Int //외래키
)