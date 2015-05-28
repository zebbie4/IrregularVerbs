package choinski.zbigniew.irregularverbs.adapters;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

import choinski.zbigniew.irregularverbs.models.IrregularVerb;

/**
 * The declaration of BaseVerbsAdapter.
 *
 * @author Zbigniew Choinski
 */
public abstract class BaseVerbsAdapter<T extends IrregularVerb> extends BaseAdapter {

    //The tag specifier for current class.
    protected static final String TAG = BaseVerbsAdapter.class.getSimpleName();

    //The holder of irregular verbs.
    protected List<? extends IrregularVerb> mIrregularVerbList;

    //The holder of current activity context
    protected final Context mContext;

    /**
     * The constructor of BaseVerbsAdapter abstract class.
     *
     * @param irregularVerbList {@link java.util.List} The activity context.
     */
    public BaseVerbsAdapter(final Context context, final List<? extends IrregularVerb> irregularVerbList) {
        this.mContext = context;
        this.mIrregularVerbList = irregularVerbList;
    }
}
