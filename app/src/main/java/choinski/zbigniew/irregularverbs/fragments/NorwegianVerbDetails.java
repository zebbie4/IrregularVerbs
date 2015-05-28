package choinski.zbigniew.irregularverbs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import choinski.zbigniew.irregularverbs.R;
import choinski.zbigniew.irregularverbs.models.NorwegianVerb;

/**
 * The implementation of NorwegianVerbDetails class.
 *
 * @author Zbigniew Choinski
 */
public class NorwegianVerbDetails extends Fragment {

    //The static instance of NorwegianVerbDetails class.
    private static NorwegianVerbDetails sNorwegianVerbDetails;

    //The holder of NorwegianVerb object.
    private NorwegianVerb mNorwegianVerb;

    /**
     * Default constructor for NorwegianVerbDetails class.
     */
    public NorwegianVerbDetails() {
        //Do nothing.
    }

    /**
     * Getter of new instance of NorwegianVerbDetails object.
     *
     * @param norwegianVerb The {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb} object.
     * @return The {@link choinski.zbigniew.irregularverbs.fragments.NorwegianVerbDetails} object.
     */
    public static NorwegianVerbDetails newInstance(final NorwegianVerb norwegianVerb) {
        if (sNorwegianVerbDetails == null) {
            sNorwegianVerbDetails = new NorwegianVerbDetails();
        }
        sNorwegianVerbDetails.setNorwegianVerb(norwegianVerb);
        return sNorwegianVerbDetails;
    }

    /**
     * Setter of the NorwegianVerb tuple with detailed data.
     *
     * @param norwegianVerb The {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb} object.
     */
    private void setNorwegianVerb(final NorwegianVerb norwegianVerb) {
        mNorwegianVerb = norwegianVerb;
    }

    /**
     * Overridden onCreate method of the NorwegianVerbDetails class.
     *
     * @param savedInstanceState The {@link android.os.Bundle} object.
     */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Overridden onCreateView method of the NorwegianVerbDetails class.
     *
     * @param inflater           The {@link android.view.LayoutInflater} object.
     * @param container          The {@link android.view.ViewGroup} object.
     * @param savedInstanceState The {@link android.os.Bundle} object.
     * @return Modified {@link android.view.View} object,
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {

        final View detailView = inflater
                .inflate(R.layout.fragment_irregular_verb_details, container, false);
        final ViewGroup detailLayout = (ViewGroup) detailView
                .findViewById(R.id.irregular_verbs_details_layout);
        final ViewGroup viewGroupContent = (ViewGroup) detailLayout
                .findViewById(R.id.irregular_verbs_details_content);

        final TextView meaning = (TextView) detailLayout
                .findViewById(R.id.irregular_verbs_details_meaning);
        final TextView infinitive = (TextView) viewGroupContent
                .findViewById(R.id.irregular_verbs_details_infinitive);
        final TextView preateritum = (TextView) viewGroupContent
                .findViewById(R.id.irregular_verbs_details_preateritum);
        final TextView participle = (TextView) viewGroupContent
                .findViewById(R.id.irregular_verbs_details_participle);

        meaning.setText(mNorwegianVerb.mMeaning);
        infinitive.setText(mNorwegianVerb.mInfinitive);
        preateritum.setText(mNorwegianVerb.mPreateritum);
        participle.setText(mNorwegianVerb.mParticiple);

        return detailView;
    }
}
