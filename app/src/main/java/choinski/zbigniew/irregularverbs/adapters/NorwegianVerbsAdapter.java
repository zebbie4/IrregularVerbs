package choinski.zbigniew.irregularverbs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import choinski.zbigniew.irregularverbs.R;
import choinski.zbigniew.irregularverbs.models.NorwegianVerb;

/**
 * The implementation of BaseVerbsAdapter class dedicated for elements defined as Norwegian verbs.
 *
 * @author Zbigniew Choinski
 */
public class NorwegianVerbsAdapter extends BaseVerbsAdapter {

    /**
     * The constructor of NorwegianVerbsAdapter class.
     *
     * @param context        {@link android.content.Context} The activity context..
     * @param irregularVerbs {@link android.content.Context} The list of norwegian irregular verbs.
     */
    public NorwegianVerbsAdapter(final Context context, final List<NorwegianVerb> irregularVerbs) {
        super(context, irregularVerbs);
    }

    /**
     * Retrieves the number of elements currently stored in NorwegianVerbAdapter object.
     *
     * @return int The number of items in the adapter.
     */
    @Override
    public int getCount() {
        return mIrregularVerbList.size();
    }

    /**
     * Retrieves the {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb} object based on
     * position of selected item.
     *
     * @param position int The position of selected item.
     * @return {@link choinski.zbigniew.irregularverbs.models.NorwegianVerb} The object
     */
    @Override
    public NorwegianVerb getItem(final int position) {
        return (NorwegianVerb) mIrregularVerbList.get(position);
    }

    /**
     * Provides the id of selected item.
     *
     * @param position long The position od selected item.
     * @return long The id of selected item.
     */
    @Override
    public long getItemId(final int position) {
        return position;
    }

    /**
     * Retrieves the view of individual element of the list view.
     *
     * @param position    int The position of the item in the list view.
     * @param convertView {@link android.view.View} The corresponding view.
     * @param parent      {@link android.view.ViewGroup} The corresponding view group.
     * @return {@link android.view.View} The individual view.
     */
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final NorwegianVerbsViewHolder viewHolder;
        View view = convertView;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.layout_irregular_verb, null, false);
            viewHolder = new NorwegianVerbsViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (NorwegianVerbsViewHolder) view.getTag();
        }

        final NorwegianVerb norwegianVerb = (NorwegianVerb) mIrregularVerbList.get(position);
        viewHolder.mMainLabel.setText(norwegianVerb.mInfinitive);
        viewHolder.mSubLabel.setText(norwegianVerb.mMeaning);

        return view;
    }

    /**
     * The definition of NorwegianVerbsViewHolder class.
     */
    class NorwegianVerbsViewHolder {

        //The holder of main label.
        public final TextView mMainLabel;

        //The holder of the sub-label.
        public final TextView mSubLabel;

        /**
         * The constructor of NorwegianVerbsViewHolder class.
         *
         * @param view {@link android.view.View} The view of single list item.
         */
        public NorwegianVerbsViewHolder(final View view) {
            final View linearLayout = view.findViewById(R.id.list_irregular_verbs_layout);
            mMainLabel = (TextView) linearLayout.findViewById(R.id.list_irregular_verbs_main);
            mSubLabel = (TextView) linearLayout.findViewById(R.id.list_irregular_verbs_sub);
        }
    }
}