package jp.mayosuke.mytimeline;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Defines a contract between the Note Pad content provider and its clients. A contract defines the
 * information that a client needs to access the provider as one or more data tables. A contract
 * is a public, non-extendable (final) class that contains constants defining column names and
 * URIs. A well-written client depends only on the constants in the contract.
 */
public final class MyTimeLine {
    public static final String AUTHORITY = "jp.mayosuke.provider.MyTimeLine";

    // This class cannot be instantiated
    private MyTimeLine() {
    }

    /**
     * TimeLine table contract
     */
    public static final class TimeLines implements BaseColumns {

        // This class cannot be instantiated
        private TimeLines() {}

        /**
         * The table name offered by this provider
         */
        public static final String TABLE_NAME = "timelines";

        /*
         * URI definitions
         */

        /**
         * The scheme part for this provider's URI
         */
        private static final String SCHEME = "content://";

        /**
         * Path parts for the URIs
         */

        /**
         * Path part for the Notes URI
         */
        private static final String PATH_TIMELINES = "/timelines";

        /**
         * Path part for the Note ID URI
         */
        private static final String PATH_TIMELINE_ID = "/timelines/";

        /**
         * 0-relative position of a timeline ID segment in the path part of a timeline ID URI
         */
        public static final int TIMELINE_ID_PATH_POSITION = 1;

        /**
         * Path part for the Live Folder URI
         */
        private static final String PATH_LIVE_FOLDER = "/live_folders/timelines";

        /**
         * The content:// style URL for this table
         */
        public static final Uri CONTENT_URI =  Uri.parse(SCHEME + AUTHORITY + PATH_TIMELINES);

        /**
         * The content URI base for a single timeline. Callers must
         * append a numeric note id to this Uri to retrieve a timeline
         */
        public static final Uri CONTENT_ID_URI_BASE
            = Uri.parse(SCHEME + AUTHORITY + PATH_TIMELINE_ID);

        /**
         * The content URI match pattern for a single timeline, specified by its ID. Use this to match
         * incoming URIs or to construct an Intent.
         */
        public static final Uri CONTENT_ID_URI_PATTERN
            = Uri.parse(SCHEME + AUTHORITY + PATH_TIMELINE_ID + "/#");

        /**
         * The content Uri pattern for a notes listing for live folders
         */
        public static final Uri LIVE_FOLDER_URI
            = Uri.parse(SCHEME + AUTHORITY + PATH_LIVE_FOLDER);

        /*
         * MIME type definitions
         */

        /**
         * The MIME type of {@link #CONTENT_URI} providing a directory of notes.
         */
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.mayosuke.timeline";

        /**
         * The MIME type of a {@link #CONTENT_URI} sub-directory of a single
         * note.
         */
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.mayosuke.timeline";

        /**
         * The default sort order for this table
         */
        public static final String DEFAULT_SORT_ORDER = "modified DESC";

        /*
         * Column definitions
         */

        public enum ColumnName {
            START_TIME,
            END_TIME,
            WHAT,
            WHERE,
            NOTES;
        }
    }
}
