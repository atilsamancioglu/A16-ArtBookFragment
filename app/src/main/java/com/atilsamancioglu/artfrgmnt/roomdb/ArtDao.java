package com.atilsamancioglu.artfrgmnt.roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.atilsamancioglu.artfrgmnt.model.Art;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface ArtDao {

    @Query("SELECT name,id FROM Art")
    Flowable<List<Art>> getArtWithNameAndId();

    @Query("SELECT * FROM Art WHERE id = :id")
    Flowable<Art> getArtById(int id);

    @Insert
    Completable insert(Art art);

    @Delete
    Completable delete(Art art);

}
