package choinski.zbigniew.irregularverbs.fragments;

import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import choinski.zbigniew.irregularverbs.R;

/**
 * The implementation of AboutDialogFragment class.
 *
 * @author Zbigniew Choinski
 */
public class AboutDialogFragment extends DialogFragment {

    /**
     * Overridden onCreateView method of the AboutDialogFragment class.
     *
     * @param inflater           The {@link android.view.LayoutInflater} object.
     * @param container          The {@link android.view.ViewGroup} object.
     * @param savedInstanceState The {@link android.os.Bundle} object.
     * @return Modified {@link android.view.View} object,
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View currentView = inflater.inflate(R.layout.fragment_dialog_about, container, false);
        getDialog().setTitle(getActivity().getString(R.string.iv_gen_action_about));

        final TextView[] labels = {
                (TextView) currentView.findViewById(R.id.vi_dialog_label_first),
                (TextView) currentView.findViewById(R.id.vi_dialog_label_second)};

        final Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),
                getString(R.string.iv_aux_font_mans_greback));

        for (final TextView label : labels) {
            label.setTypeface(typeface);
        }

        return currentView;
    }
}
