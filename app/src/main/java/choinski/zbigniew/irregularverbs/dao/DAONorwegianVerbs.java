package choinski.zbigniew.irregularverbs.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import choinski.zbigniew.irregularverbs.dao_helpers.ContractNorwegianVerbs;
import choinski.zbigniew.irregularverbs.dao_helpers.HelperNorwegianVerbs;
import choinski.zbigniew.irregularverbs.models.NorwegianVerb;

/**
 * The Data-Access-Object structure dedicated for retrieving data from SQLite database.
 *
 * @author Zbigniew Choinski
 */
public class DAONorwegianVerbs {

    //The tag specifier for current class.
    private static final String TAG = DAONorwegianVerbs.class.getSimpleName();

    //The holder of the asset name.
    private static final String FILE_NAME = "norwegian.sql";

    //The holder of activity context.
    private final Context mContext;

    //The holder of projection array required to query required records.
    private final String[] mProjection = {
            ContractNorwegianVerbs.COLUMN_INFINITIVE,
            ContractNorwegianVerbs.COLUMN_PREATERITUM,
            ContractNorwegianVerbs.COLUMN_PARTICIPLE,
            ContractNorwegianVerbs.COLUMN_MEANING
    };

    //The holder of selection array required to query required records.
    private final String[] mSelectionById = {
            ContractNorwegianVerbs._ID
    };

    //The holder of selection array required to query required records.
    private final String[] mSelectionByInfinitive = {
            ContractNorwegianVerbs.COLUMN_INFINITIVE
    };

    //The constructor of DAONorwegianVerbs class.
    public DAONorwegianVerbs(final Context context) {
        this.mContext = context;
    }

    /**
     * Creates the database. For simplicity database is being created from appropriate asset file
     * stored in the project. This method should be triggered only once during the application file
     * cycle. Ultimately database is going to be downloaded from website.
     */
    public void createDatabase() {
        final SQLiteDatabase mDatabase = new HelperNorwegianVerbs(mContext).getWritableDatabase();
        try {
            InputStream inputStream = mContext.getAssets().open(FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String sqlStatement = null;
            while ((sqlStatement = reader.readLine()) != null) {
                mDatabase.execSQL(sqlStatement);
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            mDatabase.close();
        }
    }

    /**
     * Retrieves the {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb}
     * object from the database based on provided infinitive form.
     *
     * @param infinitive {@link java.lang.String} The infinitive form of the verb.
     * @return The {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb} object.
     */
    public NorwegianVerb getVerb(final String infinitive) {
        final SQLiteDatabase mDatabase = new HelperNorwegianVerbs(mContext).getReadableDatabase();
        final Cursor cursor = mDatabase.query(ContractNorwegianVerbs.TABLE_NAME, mProjection,
                ContractNorwegianVerbs.COLUMN_INFINITIVE + "=?", new String[]{infinitive},
                null, null, null, null);

        cursor.moveToFirst();
        final NorwegianVerb norwegianVerb = new NorwegianVerb(cursor.getString(
                cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_INFINITIVE)),
                cursor.getString(cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_PREATERITUM)),
                cursor.getString(cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_PARTICIPLE)),
                cursor.getString(cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_MEANING)));
        mDatabase.close();
        return norwegianVerb;
    }

    /**
     * Retrieves the {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb}
     * object from the database based on its position in database.
     *
     * @param id int The position of item in the database.
     * @return The {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb} object.
     */
    public NorwegianVerb getVerb(final int id) {
        final SQLiteDatabase mDatabase = new HelperNorwegianVerbs(mContext).getReadableDatabase();
        final Cursor cursor = mDatabase.query(ContractNorwegianVerbs.TABLE_NAME, mProjection,
                ContractNorwegianVerbs._ID + "=?", new String[]{String.valueOf(id)},
                null, null, null, null);

        cursor.moveToFirst();
        final NorwegianVerb norwegianVerb = new NorwegianVerb(cursor.getString(
                cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_INFINITIVE)),
                cursor.getString(cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_PREATERITUM)),
                cursor.getString(cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_PARTICIPLE)),
                cursor.getString(cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_MEANING)));
        mDatabase.close();
        return norwegianVerb;
    }

    /**
     * Retrieves the entire list of {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb}
     * elements.
     *
     * @return The entire list of {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb}
     * elements
     */
    public List<NorwegianVerb> getAllVerbs() {
        final SQLiteDatabase mDatabase = new HelperNorwegianVerbs(mContext).getReadableDatabase();
        final Cursor cursor = mDatabase.query(ContractNorwegianVerbs.TABLE_NAME, null, null, null,
                null, null, null);
        final List<NorwegianVerb> irregularVerbList = new ArrayList<NorwegianVerb>();
        cursor.moveToFirst();
        for (int i = 0, end = cursor.getCount(); i < end; i++) {
            irregularVerbList.add(new NorwegianVerb(cursor.getString(
                    cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_INFINITIVE)),
                    cursor.getString(cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_PREATERITUM)),
                    cursor.getString(cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_PARTICIPLE)),
                    cursor.getString(cursor.getColumnIndex(ContractNorwegianVerbs.COLUMN_MEANING))));
            cursor.moveToNext();
        }
        mDatabase.close();
        return irregularVerbList;
    }
}
