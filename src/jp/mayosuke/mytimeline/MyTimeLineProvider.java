//package jp.mayosuke.mytimeline;
//
//import android.content.ContentProvider;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.sqlite.SQLiteQueryBuilder;
//import android.net.Uri;
//import android.text.TextUtils;
//import android.util.Log;
//
///**
// * Provides access to a database of timelines.
// */
//public class MyTimeLineProvider extends ContentProvider {
//
//    private static final String TAG = MyTimeLineProvider.class.getSimpleName();
//
//    /**
//     * The database that the provider uses as its underlying data store
//     */
//    private static final String DATABASE_NAME = "mytimeline.db";
//
//    /**
//     * The database version
//     */
//    private static final int DATABASE_VERSION = 1;
//
//    // Handle to a new DatabaseHelper.
//    private DatabaseHelper mOpenHelper;
//
//    /**
//    * This class helps open, create, and upgrade the database file.
//    */
//   private static class DatabaseHelper extends SQLiteOpenHelper {
//
//       private DatabaseHelper(Context context) {
//           // calls the super constructor, requesting the default cursor factory.
//           super(context, DATABASE_NAME, null, DATABASE_VERSION);
//       }
//
//       /**
//        *
//        * Creates the underlying database with table name and column names taken from the
//        * TimeLines class.
//        */
//       @Override
//       public void onCreate(SQLiteDatabase db) {
//           db.execSQL("CREATE TABLE " + MyTimeLine.TABLE_NAME + " ("
//                   + MyTimeLine.Column._ID + " INTEGER PRIMARY KEY,"
//                   + MyTimeLine.Column.startTime + " INTEGER,"
//                   + MyTimeLine.Column.endTime + " INTEGER,"
//                   + MyTimeLine.Column.what + " TEXT,"
//                   + MyTimeLine.Column.where + " TEXT"
//                   + MyTimeLine.Column.notes + " TEXT"
//                   + MyTimeLine.Column.createdDate + " INTEGER"
//                   + MyTimeLine.Column.modifiedDate + " INTEGER"
//                   + ");");
//       }
//
//       @Override
//       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//           // Logs that the database is being upgraded
//           Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
//                   + newVersion + ", which will destroy all old data");
//
//           // Kills the table and existing data
//           db.execSQL("DROP TABLE IF EXISTS notes");
//
//           // Recreates the database with a new version
//           onCreate(db);
//       }
//   }
//
//   /**
//    *
//    * Initializes the provider by creating a new DatabaseHelper. onCreate() is called
//    * automatically when Android creates the provider in response to a resolver request from a
//    * client.
//    */
//   @Override
//   public boolean onCreate() {
//
//       // Creates a new helper object. Note that the database itself isn't opened until
//       // something tries to access it, and it's only created if it doesn't already exist.
//       mOpenHelper = new DatabaseHelper(getContext());
//
//       // Assumes that any failures will be reported by a thrown exception.
//       return true;
//   }
//
//   /**
//    * This method is called when a client calls
//    * {@link android.content.ContentResolver#query(Uri, String[], String, String[], String)}.
//    * Queries the database and returns a cursor containing the results.
//    *
//    * @return A cursor containing the results of the query. The cursor exists but is empty if
//    * the query returns no results or an exception occurs.
//    * @throws IllegalArgumentException if the incoming URI pattern is invalid.
//    */
//   @Override
//   public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
//
//       // Constructs a new query builder and sets its table name
//       SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
//       qb.setTables(MyTimeLine.TABLE_NAME);
//
//       final String orderBy;
//       if (TextUtils.isEmpty(sortOrder)) {
//           orderBy = MyTimeLine.DEFAULT_SORT_ORDER;
//       } else {
//           orderBy = sortOrder;
//       }
//
//       // Opens the database object in "read" mode, since no writes need to be done.
//       SQLiteDatabase db = mOpenHelper.getReadableDatabase();
//
//       /*
//        * Performs the query. If no problems occur trying to read the database, then a Cursor
//        * object is returned; otherwise, the cursor variable contains null. If no records were
//        * selected, then the Cursor object is empty, and Cursor.getCount() returns 0.
//        */
//       final Cursor c = qb.query(
//           db,            // The database to query
//           projection,    // The columns to return from the query
//           selection,     // The columns for the where clause
//           selectionArgs, // The values for the where clause
//           null,          // don't group the rows
//           null,          // don't filter by row groups
//           orderBy        // The sort order
//       );
//
//       // Tells the Cursor what URI to watch, so it knows when its source data changes
//       c.setNotificationUri(getContext().getContentResolver(), uri);
//
//       return c;
//   }
//
//    @Override
//    public Uri insert(Uri uri, ContentValues initialValues) {
//        // Opens the database object in "write" mode.
//        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
//
//        // If the insert didn't succeed, then the rowID is <= 0. Throws an exception.
//        throw new SQLException("Failed to insert row into " + uri);
//    }
//
//    @Override
//    public int delete(Uri uri, String where, String[] whereArgs) {
//        // Opens the database object in "write" mode.
//        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
//
//        throw new SQLException("Failed to delete:uri=" + uri);
//    }
//
//    @Override
//    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
//        // Opens the database object in "write" mode.
//        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
//
//        throw new SQLException("Failed to update:uri=" + uri);
//    }
//
//    @Override
//    public String getType(Uri uri) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//}
