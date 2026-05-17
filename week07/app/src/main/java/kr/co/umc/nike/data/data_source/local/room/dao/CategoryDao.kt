package kr.co.umc.nike.data.data_source.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kr.co.umc.nike.data.data_source.local.room.entity.CategoryEntity

@Dao
interface CategoryDao {
    //새 카테고리를 삽입
    @Insert
    suspend fun insertCategory(category: CategoryEntity)

    //카테고리 정보를 수정
    @Update
    suspend fun updateCategory(category: CategoryEntity)

    //특정 카테고리를 삭제
    @Delete
    suspend fun deleteCategory(category: CategoryEntity)

    @Query("SELECT * FROM CategoryTable")
    fun getAllCategories(): Flow<List<CategoryEntity>>
}