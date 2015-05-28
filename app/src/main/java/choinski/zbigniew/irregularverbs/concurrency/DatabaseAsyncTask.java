package choinski.zbigniew.irregularverbs.concurrency;

import android.content.Context;
import android.os.AsyncTask;

import choinski.zbigniew.irregularverbs.dao.DAOFactory;
import choinski.zbigniew.irregularverbs.dao.DAONorwegianVerbs;
import choinski.zbigniew.irregularverbs.dao.DAOSharedPreferences;

/**
 * The DatabaseAsyncTask class is responsible for preparation of database that is going to be used
 * by the application.
 *
 * @author Zbigniew Choinski
 */
public class DatabaseAsyncTask extends AsyncTask<Context, Void, Void> {

    /**
     * Executes the creation of database.
     *
     * @param params {@link android.content.Context} The activity context.
     * @return The {@link java.lang.Void} object.
     */
    @Override
    protected Void doInBackground(final Context... params) {
        final Context context = params[0];

        synchronized (context) {
            final DAOSharedPreferences daoSharedPreferences = DAOFactory.getDAOSharedPreferences(context);
            final DAONorwegianVerbs daoNorwegianVerbs = DAOFactory.getDAONorwegianVerbs(context);
            if (daoSharedPreferences.isFirstLaunch()) {
                daoNorwegianVerbs.createDatabase();
            }
        }
        return null;
    }
}
