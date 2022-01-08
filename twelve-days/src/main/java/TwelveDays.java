import java.util.*;
import java.lang.*;
class TwelveDays {
    String verse(int verseNumber) {
        Map<Integer, String> verseRecord = new HashMap<>();
        verseRecord.put(1, "a Partridge in a Pear Tree");
        verseRecord.put(2, "two Turtle Doves");
        verseRecord.put(3, "three French Hens");
        verseRecord.put(4, "four Calling Birds");
        verseRecord.put(5, "five Gold Rings");
        verseRecord.put(6, "six Geese-a-Laying");
        verseRecord.put(7, "seven Swans-a-Swimming");
        verseRecord.put(8, "eight Maids-a-Milking");
        verseRecord.put(9, "nine Ladies Dancing");
        verseRecord.put(10, "ten Lords-a-Leaping");
        verseRecord.put(11, "eleven Pipers Piping");
        verseRecord.put(12, "twelve Drummers Drumming");

        String[] day = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};
        String starting_verse = "On the ";
        String middle_verse = " day of Christmas my true love gave to me: ";
        String end_verse = "";
        for (int i= verseNumber; i>=1; i--)
            {
                if (i==1)
                    end_verse += verseRecord.get(i) + ".";
                else if (i==2)
                    end_verse += verseRecord.get(i) + ", and ";
                else
                    end_verse += verseRecord.get(i) + ", ";
            }
        String required_verse = starting_verse + day[verseNumber-1] + middle_verse + end_verse + "\n";
        return required_verse;
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder complete_verse = new StringBuilder();
        for (int i=startVerse; i<=endVerse; i++)
            {
                complete_verse.append(verse(i));
                if (i!=endVerse)
                    complete_verse.append("\n");
            }
        return complete_verse.toString();
    }
    
    String sing() {
        return verses(1,12);
    }
}