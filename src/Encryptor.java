public class Encryptor {
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    private int offset;

    /** Constructor*/
    public Encryptor(int r, int c) {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public Encryptor(int r, int c, int o) {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
        offset = o;
    }

    public String[][] getLetterBlock() {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
//    public void fillBlock(String str) {
//        int i=0;
//        while ( i<str.length() && i<numLetters() ) {
//            String letter = str.substring(i,i+1);
//            int row = i/numCols;
//            int col = i%numRows;
//
//            System.out.println("------");
//            System.out.println(i);
//            System.out.println(row);
//            System.out.println(col);
//
//            letterBlock[row][col]=letter;
//            i++;
//        }
//
//        while (i<numLetters()) {
//            int row = i/numCols;
//            int col = i%numRows;
//
//            letterBlock[row][col]="A";
//            i++;
//        }
//    }
    public void fillBlock(String str) {
        int i=0;
        for (int row=0; row<letterBlock.length; row++) {
            for (int col=0; col<letterBlock[row].length; col++) {
                if (i<str.length()) {
                    letterBlock[row][col]=str.substring(i,i+1);
                } else {
                    letterBlock[row][col]="A";
                }
                i++;
            }
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock() {
        String text = "";

        for (int col=0; col<letterBlock[0].length; col++) {
            for (int row=0; row<letterBlock.length; row++) {
                text+=letterBlock[row][col];
            }
        }

        return text;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message) {
        String encryptedMessage = "";
        int len = message.length();

        int i=0;
        int endI=0;
        boolean done = false;
        while (!done) {
            endI=i+numLetters();
            if (endI>=len) {
                endI=len;
                done=true;
            }

            fillBlock(message.substring(i,endI));
            encryptedMessage+=encryptBlock();

            i=endI;
        }

        return encryptedMessage;
    }

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage) {
        Encryptor decryptor = new Encryptor(numCols,numRows);
        String decryptedMessage = decryptor.encryptMessage(encryptedMessage);

        while (decryptedMessage.substring(decryptedMessage.length()-1).equals("A")) {
            decryptedMessage=decryptedMessage.substring(0,decryptedMessage.length()-1);
        }

        return decryptedMessage;
    }

    public void superFillBlock(String str) {
        int i=0;
        for (int normalR=0; normalR<letterBlock.length; normalR++) {
            int row = (normalR+offset)%numRows;
            for (int col=0; col<letterBlock[row].length; col++) {
                if (i<str.length()) {
                    letterBlock[row][col]=str.substring(i,i+1);
                } else {
                    letterBlock[row][col]="A";
                }
                i++;
            }
        }
    }

    public String superEncryptMessage(String message) {
        String encryptedMessage = "";
        int len = message.length();

        int i=0;
        int endI=0;
        boolean done = false;
        while (!done) {
            endI=i+numLetters();
            if (endI>=len) {
                endI=len;
                done=true;
            }

            superFillBlock(message.substring(i,endI));
            encryptedMessage+=encryptBlock();

            i=endI;
        }

        return encryptedMessage;
    }

    public String decryptBlock() { // Method for decryption
        String text = "";

        for (int row=0; row<letterBlock.length; row++) {
            for (int col=0; col<letterBlock.length; col++) {
                text+=letterBlock[row][col];
            }
        }

        return text;
    }
    public void superOppFillBlock(String str) { // Used for decryption
        int revOffset = numRows-offset;

        int i=0;
        for (int col=0; col<letterBlock[0].length; col++) {
            for (int normalR=0; normalR<letterBlock.length; normalR++) {
                int row = (normalR+revOffset)%numRows;
                if (i<str.length()) {
                    letterBlock[row][col]=str.substring(i,i+1);
                } else {
                    letterBlock[row][col]="A";
                }
                i++;
            }
        }
    }
    public String superDecryptMessage(String encryptedMessage) {
        String decryptedMessage = "";
        int len = encryptedMessage.length();

        int i=0;
        int endI=0;
        boolean done = false;
        while (!done) {
            endI=i+numLetters();
            if (endI>=len) {
                endI=len;
                done=true;
            }

            superOppFillBlock(encryptedMessage.substring(i,endI));
            decryptedMessage+=decryptBlock();

            i=endI;
        }

        return decryptedMessage;
    }


    // Private helper method
    private int numLetters() {
        return numRows*numCols;
    }
}