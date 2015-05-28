package choinski.zbigniew.irregularverbs.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import choinski.zbigniew.irregularverbs.R;

/**
 * The implementation of splash screen that is going to be hidden after specified amount of time.
 *
 * @author Zbigniew Choinski
 */
public class IrregularVerbSplash extends Fragment {

    //The tag specifier for current class.
    private static final String TAG = IrregularVerbSplash.class.getSimpleName();

    /**
     * Overridden onActivityCreated method of the ListFragment class.
     *
     * @param savedInstanceState {@link android.os.Bundle} The bundle object to save.
     */
    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * Overridden onCreateView method of the ListFragment class.
     *
     * @param inflater           {@link android.view.LayoutInflater}
     * @param container          {@link android.view.ViewGroup}
     * @param savedInstanceState {@link android.os.Bundle}
     * @return {@link android.view.View}
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View currentView = inflater
                .inflate(R.layout.fragment_irregular_verb_splash, container, false);

        final TextView[] labels = {
                (TextView) currentView.findViewById(R.id.vi_splash_label_first),
                (TextView) currentView.findViewById(R.id.vi_splash_label_second)};

        final Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),
                getString(R.string.iv_aux_font_mans_greback));

        for (final TextView label : labels) {
            label.setTypeface(typeface);
        }

        return currentView;
    }
}
