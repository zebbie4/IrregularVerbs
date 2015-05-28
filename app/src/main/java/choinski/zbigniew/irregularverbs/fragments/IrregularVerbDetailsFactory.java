package choinski.zbigniew.irregularverbs.fragments;

import android.support.v4.app.Fragment;

import choinski.zbigniew.irregularverbs.models.IrregularVerb;
import choinski.zbigniew.irregularverbs.models.NorwegianVerb;

/**
 * The implementation of class responsible for preparation of Fragments objects.
 *
 * @author Zbigniew Choinski
 */
public class IrregularVerbDetailsFactory {

    /**
     * Retrieves a corresponding fragment containing relevant irregular verb presentation.
     *
     * @param irregularVerb {@link choinski.zbigniew.irregularverbs.models.IrregularVerb} The irregular
     *                      verb object for comparison.
     * @return The object that inherits from IrregularVerb class.
     */
    public static <T extends IrregularVerb> Fragment getFragment(final T irregularVerb) {
        Fragment nextFragment = null;
        if (irregularVerb instanceof NorwegianVerb) {
            nextFragment = NorwegianVerbDetails.newInstance((NorwegianVerb) irregularVerb);
        }
        return nextFragment;
    }

}
