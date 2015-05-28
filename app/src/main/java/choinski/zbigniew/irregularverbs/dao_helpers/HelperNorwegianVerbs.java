package choinski.zbigniew.irregularverbs.dao_helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import choinski.zbigniew.irregularverbs.R;

/**
 * The definition of helper for NorwegianVerbs database.
 *
 * @author Zbigniew Choinski
 */
public class HelperNorwegianVerbs extends SQLiteOpenHelper {

    //The holder for data version.
    private static final int DATA_VERSION = 1;

    //The holder for SQL create table statement.
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            ContractNorwegianVerbs.TABLE_NAME + " (" +
            ContractNorwegianVerbs.COLUMN_INFINITIVE + " VARCHAR(40) NOT NULL, " +
            ContractNorwegianVerbs.COLUMN_PREATERITUM + " VARCHAR(40) NOT NULL, " +
            ContractNorwegianVerbs.COLUMN_PARTICIPLE + " VARCHAR(40) NOT NULL, " +
            ContractNorwegianVerbs.COLUMN_MEANING + " VARCHAR(40) NOT NULL );";

    //The holder for SQL drop table statement.
    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " +
            ContractNorwegianVerbs.TABLE_NAME;


    /**
     * Constructor for the HelperNorwegianVerbs class.
     *
     * @param context {@link android.content.Context} The activity context.
     */
    public HelperNorwegianVerbs(final Context context) {
        super(context, context.getString(R.string.iv_aux_database_name), null,
                DATA_VERSION);
    }

    /**
     * The onCreate method of SQLiteOpenHelper class.
     *
     * @param db {@link android.database.sqlite.SQLiteDatabase} The database object.
     */
    @Override
    public void onCreate(final SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    /**
     * The onUpgrade method of SQLiteOpenHelper class. For upgrading the database the old one
     * is removed and new one is created.
     *
     * @param db {@link android.database.sqlite.SQLiteDatabase} The database object.
     * @param oldVersion int The old version of database.
     * @param newVersion int The new version of database.
     */
    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }
}
