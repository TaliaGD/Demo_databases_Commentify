package be.ehb.demo_databases_commentify.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CommentDAO {

    @Insert
    void insertComment(Comment c);

    @Query(value = "SELECT * FROM Comment")
    //er kan geen annotatie zijn zonder methode
    LiveData<List<Comment>> getAllComments();


}
