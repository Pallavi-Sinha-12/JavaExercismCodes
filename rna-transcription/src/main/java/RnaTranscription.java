class RnaTranscription {

    String transcribe(String dnaStrand) {
        int size = dnaStrand.length();
        char arr[] = dnaStrand.toCharArray();
        for (int i=0; i<size; i++)
        {
            if (arr[i]=='G')
                arr[i] = 'C';
            else if (arr[i]=='C')
                arr[i] = 'G';
            else if (arr[i]=='T')
                arr[i] = 'A';
            else if (arr[i]=='A')
                arr[i] = 'U';
            else
                continue;
        }
        String rna_transcribed = new String(arr);
        return rna_transcribed;
    }

}
