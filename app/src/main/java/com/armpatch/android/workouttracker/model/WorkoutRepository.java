package com.armpatch.android.workouttracker.model;

import android.content.Context;

import com.armpatch.android.workouttracker.Tools;

import org.threeten.bp.LocalDate;

import java.util.List;

public class WorkoutRepository {

    private WorkoutCommentDao commentDao;
    private ExerciseDao exerciseDao;
    private ExerciseSetDao exerciseSetDao;
    private CategoryDao categoryDao;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples

    public WorkoutRepository(Context application) {
        WorkoutRoomDatabase db = WorkoutRoomDatabase.getDatabase(application);
        commentDao = db.commentDao();
        exerciseDao = db.exerciseDao();
        exerciseSetDao = db.exerciseSetDao();
        categoryDao = db.categoryDao();
    }

    // Retrieve

    public WorkoutComment getWorkoutComment(LocalDate localDate) {
        String date = Tools.stringFromDate(localDate);
        return commentDao.getWorkoutComment(date);
    }

    public Exercise getExercise(String name) {
        return exerciseDao.getExercise(name);
    }

    public List<Exercise> getExercises(Category category) {
        return exerciseDao.getExercises(category);
    }

    public List<Exercise> getExercises() {
        return exerciseDao.getExercises();
    }

    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    public Integer getExerciseCount(LocalDate localDate) {
        String date = Tools.stringFromDate(localDate);
        return exerciseSetDao.getExerciseCount(date);
    }

    public List<ExerciseSet> getExerciseSets(LocalDate localDate, int exerciseOrder) {
        String date = Tools.stringFromDate(localDate);
        return exerciseSetDao.getExerciseSets(date, exerciseOrder);
    }

    public List<ExerciseSet> getExerciseSets(LocalDate localDate) {
        String date = Tools.stringFromDate(localDate);
        return exerciseSetDao.getExerciseSets(date);
    }

    // Insert

    public void insert(final WorkoutComment comment) {
        WorkoutRoomDatabase.databaseWriteExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        commentDao.insert(comment);
                    }
                });
    }

    public void insert(final Exercise exercise) {
        WorkoutRoomDatabase.databaseWriteExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        exerciseDao.insert(exercise);
                    }
                });
    }
}
