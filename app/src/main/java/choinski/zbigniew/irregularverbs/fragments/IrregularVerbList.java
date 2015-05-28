package choinski.zbigniew.irregularverbs.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import choinski.zbigniew.irregularverbs.R;
import choinski.zbigniew.irregularverbs.adapters.AdapterFactory;
import choinski.zbigniew.irregularverbs.adapters.BaseVerbsAdapter;
import choinski.zbigniew.irregularverbs.fragments_communicators.IrregularVerbCommunicator;
import choinski.zbigniew.irregularverbs.models.IrregularVerb;

/**
 * The fragment that contains a list view required for presentation irregular verbs.
 *
 * @author Zbigniew Choinski
 */
public class IrregularVerbList extends ListFragment {

    //The tag specifier for current class.
    private static final String TAG = IrregularVerbList.class.getSimpleName();

    //The holder for BaseVerbsAdapter class.
    private BaseVerbsAdapter mBaseAdapter;

    /**
     * Overridden onActivityCreated method of the ListFragment class.
     *
     * @param savedInstanceState {@link android.os.Bundle} The bundle object to save.
     */
    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBaseAdapter = AdapterFactory.getInstance(getActivity(), AdapterFactory.Language.NORWEGIAN);
        setListAdapter(mBaseAdapter);
    }

    /**
     * Overridden onCreateView method of the ListFragment class.
     *
     * @param inflater           The {@link android.view.LayoutInflater} object.
     * @param container          The {@link android.view.ViewGroup} object.
     * @param savedInstanceState The {@link android.os.Bundle} object.
     * @return Modified {@link android.view.View} object,
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_irregular_verb_list, container, false);
    }

    /**
     * Overridden onListItemClick method of the ListFragment class.
     *
     * @param listView {@link android.widget.ListView} The list view object.
     * @param view     {@link android.view.View} The view selected.
     * @param position int The position of item that has been clicked.
     * @param id       long The id of the record.
     */
    @Override
    public void onListItemClick(final ListView listView, final View view, int position, long id) {
        ((IrregularVerbCommunicator) getActivity())
                .irregularVerbData((IrregularVerb) mBaseAdapter.getItem(position));
    }
}
