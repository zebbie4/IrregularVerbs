package choinski.zbigniew.irregularverbs.dao_helpers;

import android.provider.BaseColumns;

/**
 * Definition of columns used in the NorwegianVerbs database.
 *
 * @author Zbigniew Choinski
 */
public abstract class ContractNorwegianVerbs  implements BaseColumns {

    //The holder for the table name.
    public static final String TABLE_NAME = "table_norsk";

    //The holder for the column that stores infinitive form of verb.
    public static final String COLUMN_INFINITIVE = "infinitive";

    //The holder for the column that stores preateritum form of verb.
    public static final String COLUMN_PREATERITUM = "preateritum";

    //The holder for the column that stores participle form of verb.
    public static final String COLUMN_PARTICIPLE = "participle";

    //The holder for the column that stores meaning form of verb.
    public static final String COLUMN_MEANING = "meaning";

}
