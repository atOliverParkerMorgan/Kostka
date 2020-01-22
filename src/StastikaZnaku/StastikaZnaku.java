package StastikaZnaku;

public class StastikaZnaku {

    private final static char CR  = (char) 0x0D;
    private final static char LF  = (char) 0x0A;

    private int numDigit;
    private int numUpper;
    private int numLower;
    private int numWhiteSpace;
    private int numISO;

    private int numLines;
    private int longestLine;
    private int totalLengthOfAllLines;
    private double averageLengthOfAllLines;
    private char mostCommonChar;
    private final int tableRange;
    // basic ascii table
    private int[] ascii_table;


    public static void main(String[] args) {
        // ASCII range is 128
        StastikaZnaku s = new StastikaZnaku(128);

        String[] allLines = new String[]{"Vytvořte třídu, jejíž instance budou reprezentovat níže uvedené statistické údaje zadaného textu. Text se objektu předává opakovaným voláním jeho metody s jedním parametrem typu String. Každé jedno zavolání představuje zpravidla",
                                        "jeden řádek rozsáhlejšího textu, ovšem, pokud řetězec obsahuje znaky pro zalomení řádku (ASCII CR LF), je potřeba započítat více než jeden řádek na jedno zavolání (bonus, v základní variantě předpokládejte, že jedno volání je jeden řádek a CR LF považujte pouze za obyčejné řídící znaky).",
                                        "Analyzující metoda zpracuje řetězec znak po znaku a určí (průběžně) četnost (počet výskytů) následujících skupin znaků:",
                                        "Kromě toho si objekt udržuje i počet zpracovaných řádků. Všechny statistické údaje jsou celočíselné informace pouze pro čtení (tzn., že mají veřejný getter). ",
                                        "Přidejte také metodu, která statistiku vynuluje a připraví objekt pro novou dávku řetězců."};

        for(String text : allLines) {
            s.Analyze(text);
    }
        s.printStats();



    }

    StastikaZnaku(int tableRange){
        this.tableRange = tableRange;
        Reset();
    }

    public void Reset(){
        this.numDigit = 0;
        this.numUpper = 0;
        this.numLower = 0;
        this.numWhiteSpace = 0;
        this.numISO = 0;

        this.numLines = 0;
        this.longestLine = 0;
        this.totalLengthOfAllLines = 0;
        this.averageLengthOfAllLines = 0;
        this.ascii_table = new int[tableRange];
    }

    public void Analyze(String text){
        totalLengthOfAllLines += text.length();

        for(char c: text.toCharArray()){
            if(Character.isDigit(c)){
                this.numDigit++;
            }else if(Character.isUpperCase(c)){
                this.numUpper++;
            }else if(Character.isLowerCase(c)){
                this.numLower++;
            }else if(Character.isWhitespace(c)){
                this.numWhiteSpace++;
            }else if(Character.isISOControl(c)||c==CR||c==LF){
                this.numISO++;
            }
        }
        updateLongestList(text);
        getMostCommonChar(text);

        numLines++;

        updateAverageLengthOfLine();

    }
    private void updateLongestList(String text){
        // has to be called before you update the number of lines
        if(numLines==0){
            longestLine = text.length();
        }else if(longestLine<text.length()){
            longestLine = text.length();
        }
    }
    private void updateAverageLengthOfLine(){
        if(numLines!=0) {
            averageLengthOfAllLines = totalLengthOfAllLines / numLines;
        }
    }
    private void getMostCommonChar(String text){
        for(char c: text.toCharArray()){
            if(c<tableRange){
                ascii_table[c]++;

            }
        }
        int max = -1;
        int maxIndex = 0;

        for(int i = 0; i<ascii_table.length;i++){
            if(ascii_table[i]>max){
                max = ascii_table[i];
                maxIndex = i;
            }
        }
        mostCommonChar = (char) maxIndex;

    }

    public int getNumLines() { return numLines; }

    public int getNumDigit() {
        return numDigit;
    }

    public int getNumUpper() {
        return numUpper;
    }

    public int getNumLower() {
        return numLower;
    }

    public int getNumWhiteSpace() {
        return numWhiteSpace;
    }

    public int getNumISO() {
        return numISO;
    }

    public void printStats(){
        String numberOf = "number of ";

        System.out.println(numberOf+"digits: "+numDigit);
        System.out.println(numberOf+"upper characters: "+numUpper);
        System.out.println(numberOf+"lower characters: "+numLower);
        System.out.println(numberOf+"whitespaces: "+ numWhiteSpace);
        System.out.println(numberOf+"ISO commands: "+numISO);
        System.out.println(numberOf+"Lines: "+numLines);
        System.out.println("\nBONUS");
        System.out.println("longestLine: "+longestLine);
        System.out.println("averageLineLength: "+averageLengthOfAllLines);
        if((int)mostCommonChar==32){
            System.out.println("mostCommonChar: "+mostCommonChar+" (whiteSpace)");
        }else {
            System.out.println("mostCommonChar: " + mostCommonChar + " " + (int) mostCommonChar);
        }
    }



}

