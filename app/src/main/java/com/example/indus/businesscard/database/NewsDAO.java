package com.example.indus.businesscard.database;

import com.example.indus.businesscard.modeldto.NewsEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface NewsDAO {

    @Query("SELECT * FROM newstables")
    Observable<List<NewsEntity>> getAll();

    @Query("SELECT * FROM newstables WHERE section LIKE :category")
    Single<List<NewsEntity>> getNewsByCategory(String category);

    @Query("DELETE FROM newstables WHERE id IN (:id)")
    int deleteById (int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NewsEntity> entities);

    @Query("DELETE FROM newstables")
    void deleteAll();
}
