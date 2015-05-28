package choinski.zbigniew.irregularverbs.dao;

import android.content.Context;
import android.content.SharedPreferences;

import choinski.zbigniew.irregularverbs.R;

/**
 * The Data-Access-Object structure dedicated for retrieving data from shared preferences file.
 *
 * @author Zbigniew Choinski
 */
public class DAOSharedPreferences {

    //The holder of activity context.
    private final Context mContext;

    /**
     * Constructor of DAOSharedPreferences class.
     *
     * @param context {@link android.content.Context} The activity context.
     */
    public DAOSharedPreferences(final Context context) {
        this.mContext = context;
    }

    /**
     * Retrieves the information whether the application has been launch for the very first time.
     *
     * @return boolean Returns TRUE if it is the initial launch, FALSE otherwise.
     */
    public boolean isFirstLaunch() {
        final SharedPreferences sharedPreferences = mContext
                .getSharedPreferences(mContext
                .getString(R.string.iv_aux_shared_pref), Context.MODE_PRIVATE);
        final String launchStatusLabel = mContext.getString(R.string.iv_aux_launch_status);
        final boolean currentStatus = sharedPreferences.getBoolean(launchStatusLabel, true);

        if(currentStatus) {
            final SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(launchStatusLabel, false).commit();
        }
        return currentStatus;
    }

}
