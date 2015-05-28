package choinski.zbigniew.irregularverbs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

import choinski.zbigniew.irregularverbs.concurrency.DatabaseAsyncTask;
import choinski.zbigniew.irregularverbs.fragments.AboutDialogFragment;
import choinski.zbigniew.irregularverbs.fragments.IrregularVerbDetailsFactory;
import choinski.zbigniew.irregularverbs.fragments.IrregularVerbList;
import choinski.zbigniew.irregularverbs.fragments.IrregularVerbSplash;
import choinski.zbigniew.irregularverbs.fragments_communicators.IrregularVerbCommunicator;
import choinski.zbigniew.irregularverbs.models.IrregularVerb;

/**
 * The implementation of MainActivity class.
 *
 * @author Zbigniew Choinski
 */
public class MainActivity extends ActionBarActivity implements IrregularVerbCommunicator {

    //The tag specifier for current class.
    @SuppressWarnings("unused")
    private static final String TAG = MainActivity.class.getSimpleName();

    //The time of displaying the splash screen.
    private static final int SPLASH_SCREEN_DELAY = 4000;

    //The holder for Timer object.
    private Timer mTimer = null;

    /**
     * Overridden onCreate method of the ActionBarActivity class.
     *
     * @param savedInstanceState The {@link android.os.Bundle} object.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
        getSupportActionBar().hide();

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new DismissSplashScreenRunnable());
            }
        }, SPLASH_SCREEN_DELAY);

        final Fragment currentFragment = new IrregularVerbSplash();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, currentFragment)
                    .commitAllowingStateLoss();
        }

        final DatabaseAsyncTask databaseAsyncTask = new DatabaseAsyncTask();
        databaseAsyncTask.execute(this);
    }

    /**
     * Overridden onPause method of the ActionBarActivity class.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mTimer.cancel();
    }

    /**
     * Overridden onCreateOptionsMenu method of the ActionBarActivity class.
     *
     * @param menu {@link android.view.Menu} The menu object of the activity.
     * @return boolean TRUE if display.
     */
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Overridden onOptionsItemSelected method of the ActionBarActivity class.
     *
     * @param item The {@link android.view.MenuItem} that has been selected.
     * @return TRUE if it allows normal menu processing to proceed, FALSE otherwise.
     */
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        final int id = item.getItemId();
        if (id == R.id.action_about) {
            AboutDialogFragment aboutDialog = new AboutDialogFragment();
            aboutDialog.show(getFragmentManager(), aboutDialog.getTag());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Transmits the irregularVerbData from IrregularVerbList fragment to appropriate
     * IrregularVerbDetail fragment.
     *
     * @param irregularVerb {@link choinski.zbigniew.irregularverbs.models.IrregularVerb} The irregular
     *                      verb to be sent.
     */
    @Override
    public <T extends IrregularVerb> void irregularVerbData(final T irregularVerb) {
        final Fragment nextFragment = IrregularVerbDetailsFactory.getFragment(irregularVerb);
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.addToBackStack(nextFragment.getTag());
        fragmentTransaction.replace(R.id.fragment_container, nextFragment);
        fragmentTransaction.commit();
    }

    /**
     * The helper class for dismissing the splash screen after exceeding  SPLASH_SCREEN_DELAY amount
     * of time.
     *
     * @author Zbigniew Choinski
     */
    public class DismissSplashScreenRunnable implements Runnable {

        /**
         * Overridden run method of the Runnable interface.
         */
        @Override
        public void run() {
            final Fragment nextFragment = new IrregularVerbList();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, nextFragment)
                    .commit();
            getSupportActionBar().show();
        }
    }
}

