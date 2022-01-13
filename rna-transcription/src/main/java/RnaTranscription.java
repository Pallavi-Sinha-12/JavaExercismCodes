class RnaTranscription {

    private final char adenine = 'A';
    private final char cytosine = 'C';
    private final char guanine = 'G';
    private char thymine = 'T';
    private char uracil = 'U';

    String transcribe(String dnaStrand) {
        int size = dnaStrand.length();
        char strandArray[] = dnaStrand.toCharArray();
        for (int nucleotide=0; nucleotide<size; nucleotide++)
        {
            if (strandArray[nucleotide]==guanine)
                strandArray[nucleotide] = cytosine;
            else if (strandArray[nucleotide] ==cytosine)
                strandArray[nucleotide] = guanine;
            else if (strandArray[nucleotide] == thymine)
                strandArray[nucleotide] = adenine;
            else if (strandArray[nucleotide]== adenine)
                strandArray[nucleotide] = uracil;
            else
                continue;
        }
        String rna_transcribed = new String(strandArray);
        return rna_transcribed;
    }

}
