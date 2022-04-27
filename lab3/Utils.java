public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with'.
     */

    public static String[] findAndReplace( String[] in, String[] what, String[] with ) {

        String[] out = null; // The new array to be returned
        boolean valid = true; // True if the pre-conditions are satistified

        // Testing pre-conditions

        if ( in == null || what == null || with == null ) {
            valid = false;
        } else {
            if (what.length == with.length) {
                for (String a : what) {
                    if (a == null) {
                        valid = false;
                    }
                }
                for (String c : in) {
                    if (c==null) {
                        valid = false;
                    }
                }
                for (String b : with) {
                    if (b==null) {
                        valid = false;
                    }
                }

            } else {
                valid = false;
            }
            // more or less 16 lines missing
        }

        if ( valid ) {
            out = new String[ in.length ];
            for ( int i=0; i<in.length; i++ ) {
                int n=0;
                if (what.length!=0){
                    for (int a=0; a<what.length; a++ ) {
                        if (in[i].equals(what[a])) {
                            n++;
                            if (n == 1) {
                                out[i] = with[a];
                            }
                        }
                    }
                    if (out[i]==null){
                        out[i]=in[i];
                    }
                } else{
                    out[i]=in[i];
                }
            }
        } else {
            out=null;
        }

        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.

        return out;
    }
}
