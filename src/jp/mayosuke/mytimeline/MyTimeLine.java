package jp.mayosuke.mytimeline;

import java.util.ArrayList;
import java.util.List;

public class MyTimeLine {

    private final static MyTimeLine sInstance = new MyTimeLine();
    private MyTimeLine() {}
    public static MyTimeLine getInstance() {
        return sInstance;
    }

    private final List<TimeLine> mTimeLines = new ArrayList<TimeLine>();

    public void insertTimeLine(final TimeLine timeLine) {
        mTimeLines.add(timeLine);
    }

    public List<TimeLine> getTimeLines() {
        return mTimeLines;
    }

    public static class TimeLine {
        public final long mStartTime;
        public final long mEndTime;
        public final String mWhat;
        public final String mWhere;
        public final String mNotes;
        public final long mCreatedDate;
        public final long mModifiedDate;

        public TimeLine(long startTime, long endTime,
                String what, String where, String notes) {
            mStartTime = startTime;
            mEndTime = endTime;
            mWhat = what;
            mWhere = where;
            mNotes = notes;
            mCreatedDate = System.currentTimeMillis();
            mModifiedDate = mCreatedDate;
        }

        public String toString() {
            return "mStartTime=" + mStartTime + ",mEndTime=" + mEndTime + ",mWhat=" + mWhat + ",mWhere=" + mWhere + ",mNotes=" + mNotes + ",mCreatedDate=" + mCreatedDate + ",mModifiedDate=" + mModifiedDate;
        }
    }



//    public static final String AUTHORITY = "jp.mayosuke.provider.MyTimeLine";
//
//    /**
//     * The table name offered by this provider
//     */
//    public static final String TABLE_NAME = "timelines";
//
//    // URI definitions
//
//    /**
//     * The scheme part for this provider's URI
//     */
//    private static final String SCHEME = "content://";
//
//    /**
//     * Path part for the timelines URI
//     */
//    private static final String PATH_TIMELINES = "/timelines/";
//
//    /**
//     * The content:// style URL for this table
//     */
//    public static final Uri CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + PATH_TIMELINES);
//
//    // MIME type definitions
//
//    /**
//     * The MIME type of {@link #CONTENT_URI} providing a directory of timelines.
//     */
//    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.mayosuke.timeline";
//
//    /**
//     * The MIME type of a {@link #CONTENT_URI} sub-directory of a single
//     * note.
//     */
//    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.mayosuke.timeline";
//
//    /**
//     * The default sort order for this table
//     */
//    public static final String DEFAULT_SORT_ORDER = "modified DESC";
//
//    // Column definitions
//
//    public enum Column implements BaseColumns {
//        startTime,
//        endTime,
//        what,
//        where,
//        notes,
//        createdDate,
//        modifiedDate;
//    }
//
//    private MyTimeLine() {} // This class cannot be instantiated
}
