package be.ehb.demo_databases_commentify.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import be.ehb.demo_databases_commentify.model.Comment;
import be.ehb.demo_databases_commentify.model.CommentDB;

public class CommentViewModel extends AndroidViewModel {

    private final LiveData<List<Comment>> COMMENTS;
    private CommentDB database;

    public CommentViewModel(@NonNull Application application) {
        super(application);

        database = CommentDB.getSharedInstance(application);
        COMMENTS = database.getCommentDAO().getAllComments();
    }

    public LiveData<List<Comment>> getCOMMENTS() {
        return COMMENTS;
    }

    public void insertComment(Comment c){
        CommentDB.databaseExecutor.execute(new Runnable() {
            @Override
            public void run() {
                database.getCommentDAO().insertComment(c);
            }
        });
    }
}
