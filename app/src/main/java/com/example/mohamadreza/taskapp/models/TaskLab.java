//package com.example.mohamadreza.taskapp.models;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//
//import com.example.mohamadreza.taskapp.Dao.App;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//public class TaskLab {
//
//    private static TaskLab instance;
//    private TaskDao mTaskDao;
//
//    private TaskLab() {
//        DaoSession mDaoSession = (App.getApp()).getDaoSession();
//        mTaskDao = mDaoSession.getTaskDao();
//    }
//
//    public static TaskLab getInstance() {
//        if (instance == null)
//            instance = new TaskLab();
//
//        return instance;
//    }
//
//    public List<Task> getTasks(int userId) {
//        List<Task> tasks =
//
//    }
//
//    public Task getTask(UUID id) {
//        String whereClause = TaskDbSchema.TaskTable.Cols.UUID + " = ?";
//        String[] whereArgs = new String[]{id.toString()};
//
//        TaskCursorWrapper crimeCursorWrapper = queryTask(whereClause, whereArgs);
//
//        try {
//            if (crimeCursorWrapper.getCount() == 0)
//                return null;
//
//            crimeCursorWrapper.moveToFirst();
//            return crimeCursorWrapper.getTask();
//        } finally {
//            crimeCursorWrapper.close();
//        }
//    }
//
//    private TaskCursorWrapper queryTask(String whereClause, String[] whereArgs) {
//        Cursor cursor = mDatabase.query(
//                TaskDbSchema.TaskTable.NAME,
//                null,
//                whereClause,
//                whereArgs,
//                null,
//                null,
//                null);
//
//        return new TaskCursorWrapper(cursor);
//    }
//
//    public void addTask(Task task) {
//        ContentValues values = getContentValues(task);
//        mDatabase.insert(TaskDbSchema.TaskTable.NAME, null, values);
//    }
//
//    public void update(Task task) {
//        ContentValues values = getContentValues(task);
//        String whereClause = TaskDbSchema.TaskTable.Cols.UUID + " = ? ";
//        mDatabase.update(TaskDbSchema.TaskTable.NAME, values,
//                whereClause, new String[]{task.getId().toString()});
//    }
//
//
//    public ContentValues getContentValues(Task task) {
//        ContentValues values = new ContentValues();
//        values.put(TaskDbSchema.TaskTable.Cols.UUID, task.getId().toString());
//        values.put(TaskDbSchema.UserTable.Cols.USERID, CurrentPosition.getUserId());
//        values.put(TaskDbSchema.TaskTable.Cols.TITLE, task.getTitle());
//        values.put(TaskDbSchema.TaskTable.Cols.DESCRIPTION, task.getTitle());
//        values.put(TaskDbSchema.TaskTable.Cols.DATE, task.getDate().getTime());
//        values.put(TaskDbSchema.TaskTable.Cols.DONE, task.isDone() ? 1 : 0);
//
//        return values;
//    }
//
////    public void removeTask(Task task) {
////        UUID id=task.getId();
////        mDatabase.delete(TaskDbSchema.TaskTable.NAME, TaskDbSchema.TaskTable.Cols.UUID + " = ?",
////                new String[] { String.valueOf(id) });
////    }
//
//    public void deleteAll(int userId) {
//        mDatabase.execSQL("delete from " + TaskDbSchema.TaskTable.NAME + " where " + TaskDbSchema.TaskTable.Cols.USERID + " = " + userId);
//    }
//
//}
//
