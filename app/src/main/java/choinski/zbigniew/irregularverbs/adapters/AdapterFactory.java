package choinski.zbigniew.irregularverbs.adapters;

import android.content.Context;

import choinski.zbigniew.irregularverbs.dao.DAOFactory;
import choinski.zbigniew.irregularverbs.dao.DAONorwegianVerbs;

/**
 * The implementation of class responsible for preparation of DAO objects.
 *
 * @author Zbigniew Choinski
 */
public class AdapterFactory {

    //The tag specifier for current class.
    private static final String TAG = AdapterFactory.class.getSimpleName();

    //The language enum definition.
    public static enum Language {
        NORWEGIAN, ENGLISH, GERMAN
    }

    /**
     * Retrieves the instance of appropriate adapter.
     *
     * @param context  {@link android.content.Context} The application context.
     * @param language {@link choinski.zbigniew.irregularverbs.adapters.AdapterFactory.Language} The language selector.
     * @return {@link choinski.zbigniew.irregularverbs.adapters.BaseVerbsAdapter} Corresponding adapter.
     */
    public static <T extends BaseVerbsAdapter> T getInstance(final Context context,
                                                             final Language language) {
        BaseVerbsAdapter returnedAdapter = null;

        switch (language) {
            case NORWEGIAN:
                DAONorwegianVerbs norwegianVerbs = DAOFactory.getDAONorwegianVerbs(context);
                returnedAdapter = new NorwegianVerbsAdapter(context, norwegianVerbs.getAllVerbs());
                break;
            case ENGLISH:
                //Do nothing.
                break;
            case GERMAN:
                //Do nothing.
                break;
            default:

        }
        return (T) returnedAdapter;
    }
}
