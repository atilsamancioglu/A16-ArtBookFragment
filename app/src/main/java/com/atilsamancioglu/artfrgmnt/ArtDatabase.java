package com.atilsamancioglu.artfrgmnt;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Art.class}, version = 1)
public abstract class ArtDatabase extends RoomDatabase {
    public abstract ArtDao artDao();
}
