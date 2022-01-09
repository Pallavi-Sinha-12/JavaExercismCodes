import java.util.*;
class ChangeCalculator
{
    private List<Integer> availableDenominations;
    private Map<Integer, List<Integer>> changeToCoins = new HashMap<>();
    private Queue<Integer> calculatedChanges = new LinkedList<>();
    private int targetChange;
    
    public ChangeCalculator(List<Integer> availableDenominations)
    {
        this.availableDenominations = availableDenominations;
    }
    
    public void calculateNewChangeCombinations(int calculatedChange)
    {
        for (Integer denomination: this.availableDenominations)
            {
                int nextChange = calculatedChange + denomination;
                if ((nextChange <= targetChange) && (!changeToCoins.containsKey(nextChange)))
                {
                    List<Integer> nextCoins = new ArrayList<>(changeToCoins.get(calculatedChange));
                    nextCoins.add(denomination);
            
                    changeToCoins.put(nextChange, nextCoins);
                    calculatedChanges.offer(nextChange);
                }
                
            }
        
    }
    public List<Integer> computeMostEfficientChange(int change)
    {
        targetChange = change;
        if (targetChange < 0)
            throw new IllegalArgumentException("Negative totals are not allowed.");
        
        changeToCoins.put(0, Collections.emptyList());
        calculatedChanges.offer(0);
        
        while (!calculatedChanges.isEmpty())
        {
            int calculatedChange = calculatedChanges.poll();
            
            if (calculatedChange == targetChange)
            {
                return changeToCoins.get(calculatedChange);
            }
            
            calculateNewChangeCombinations(calculatedChange);
        }
        
        throw new IllegalArgumentException("The total " + targetChange + " cannot be represented in the given currency." );
    }
}