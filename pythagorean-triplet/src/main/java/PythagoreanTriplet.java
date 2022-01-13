import java.util.List;
import java.util.ArrayList;

class PythagoreanTriplet
{
    private int tripletMemberOne, tripletMemberTwo, tripletMemberThree;
    private int sum;
    
    private List<PythagoreanTriplet> tripletsList = new ArrayList<>();
    
    public PythagoreanTriplet()
    {
        
    }
    
    public PythagoreanTriplet(int tripletMemberOne, int tripletMemberTwo, int tripletMemberThree)
    {
        this.tripletMemberOne = tripletMemberOne;
        this.tripletMemberTwo = tripletMemberTwo;
        this.tripletMemberThree  = tripletMemberThree;

    }
    
    public PythagoreanTriplet makeTripletsList()
    {
        return new PythagoreanTriplet();
    }
    
    public PythagoreanTriplet withFactorsLessThanOrEqualTo(int limit)
    {
        sum = sum;
        return this;
    }
    
    public PythagoreanTriplet thatSumTo(int sum)
    {
        for(int member1 = 1; member1<=sum/3; member1++)
        {
            for(int member2 = member1+1; member2<=(sum-member1)/2; member2++)
            {
                int member3 = sum - (member1 + member2);
                if (isFollowingPythagoreanTheorem(member1, member2, member3))
                {
                    tripletsList.add(new PythagoreanTriplet(member1, member2, member3));
                }
            }
        }
        return this;
    }

    private boolean isFollowingPythagoreanTheorem(int member1, int member2, int member3) {
        return Math.pow(member1, 2) + Math.pow(member2, 2) == Math.pow(member3, 2);
    }

    public List<PythagoreanTriplet> build()
    {
        return tripletsList;
    }
    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof PythagoreanTriplet))
        {
            return false;
        }
        PythagoreanTriplet triplet = (PythagoreanTriplet) other;
        if ((this.tripletMemberOne == triplet.tripletMemberOne ) && (this.tripletMemberTwo==triplet.tripletMemberTwo) && (this.tripletMemberThree== triplet.tripletMemberThree))
        {
            return true;
        }
        return false;
        
    }
}