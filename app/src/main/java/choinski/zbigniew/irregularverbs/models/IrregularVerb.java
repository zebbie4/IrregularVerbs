package choinski.zbigniew.irregularverbs.models;

/**
 * The definition of the IrregularVerb class.
 *
 * @author Zbigniew Choinski
 */
public class IrregularVerb {

    //The holder for infinitive form of the verb.
    public final String mInfinitive;

    //The holder for meaning of the verb.
    public final String mMeaning;

    /**
     * The constructor of  IrregularVerb tuple.
     *
     * @param infinitive {@link java.lang.String} The infinitive form of the verb.
     * @param meaning {@link java.lang.String} The corresponding meaning of the verb.
     */
    public IrregularVerb(final String infinitive, final String meaning) {
        this.mInfinitive = infinitive;
        this.mMeaning = meaning;
    }
}
