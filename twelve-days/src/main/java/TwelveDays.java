import java.util.*;
import java.lang.*;
class TwelveDays {
    String verse(int verseNumber) {
        String[] verseRecord = {"a Partridge in a Pear Tree", "two Turtle Doves","three French Hens", "four Calling Birds", "five Gold Rings", "six Geese-a-Laying", "seven Swans-a-Swimming",  "eight Maids-a-Milking", "nine Ladies Dancing", "ten Lords-a-Leaping",  "eleven Pipers Piping", "twelve Drummers Drumming"};
        String[] day = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};
        String startingVerse = "On the ";
        String middleVerse = " day of Christmas my true love gave to me: ";
        String endVerse = "";
        for (int itemNumber= verseNumber; itemNumber>=1; itemNumber--)
            {
                if (itemNumber==1)
                    endVerse += verseRecord[itemNumber-1] + ".";
                else if (itemNumber==2)
                    endVerse += verseRecord[itemNumber-1] + ", and ";
                else
                    endVerse += verseRecord[itemNumber-1] + ", ";
            }
        String requiredVerse = startingVerse + day[verseNumber-1] + middleVerse + endVerse + "\n";
        return requiredVerse;
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder completeVerse = new StringBuilder();
        for (int dayNumber=startVerse; dayNumber<=endVerse; dayNumber++)
            {
                completeVerse.append(verse(dayNumber));
                if (dayNumber!=endVerse)
                    completeVerse.append("\n");
            }
        return completeVerse.toString();
    }
    
    String sing() {
        return verses(1,12);
    }
}