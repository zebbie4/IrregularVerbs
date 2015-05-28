package choinski.zbigniew.irregularverbs.dao;

import android.content.Context;

/**
 * The implementation of Data-Access-Object factory.
 *
 * @author Zbigniew Choinski
 */
public class DAOFactory {

    /**
     * Retrieves the DAONorwegianVerbs object.
     *
     * @param context {@link Context} The activity context.
     * @return The {@link choinski.zbigniew.irregularverbs.dao.DAONorwegianVerbs} object.
     */
    public static final DAONorwegianVerbs getDAONorwegianVerbs(final Context context) {
        return new DAONorwegianVerbs(context);
    }

    /**
     * Retrieves the DAOSharedPreferences object.
     *
     * @param context {@link Context} The activity context.
     * @return The {@link choinski.zbigniew.irregularverbs.dao.DAOSharedPreferences} object.
     */
    public static final DAOSharedPreferences getDAOSharedPreferences(final Context context) {
        return new DAOSharedPreferences(context);
    }

}
