package choinski.zbigniew.irregularverbs.fragments_communicators;

import choinski.zbigniew.irregularverbs.models.IrregularVerb;

/**
 * The declaration of IrregularVerbCommunicator interface. It takes the IrregularVerb object
 * as a parameter to be passed into appropriate VerbDetails activity.
 *
 * @author Zbigniew Choinski
 */
public interface IrregularVerbCommunicator {

    /**
     * The method required to pass the detail data to appropriate DetailView activity.
     *
     * @param irregularVerb {@link choinski.zbigniew.irregularverbs.models.IrregularVerb} The irregular
     *                      verb to be sent.
     */
    public <T extends IrregularVerb> void irregularVerbData(final T irregularVerb);
}
