package choinski.zbigniew.irregularverbs.models;

/**
 * The definition of norwegian irregular verb class.
 * It consists the following forms: Infinitive, Preatetitum, Participle, Meaning.
 *
 * @author Zbigniew Choinski
 */
public class NorwegianVerb extends IrregularVerb {

    //The holder for preateritum form of the verb.
    public final String mPreateritum;

    //The holder for participle form of the verb.
    public final String mParticiple;


    /**
     * The constructor of  IrregularVerb tuple.
     *
     * @param infinitive {@link java.lang.String} The infinitive form of the verb.
     * @param preateritum {@link java.lang.String} The preateritum form of the verb.
     * @param participle {@link java.lang.String} The perfect form of the verb.
     * @param meaning {@link java.lang.String} The corresponding meaning of the verb.
     */
    public NorwegianVerb(final String infinitive, final String preateritum, final String participle,
                         final String meaning) {
        super(infinitive, meaning);
        this.mPreateritum = preateritum;
        this.mParticiple = participle;
    }
}
