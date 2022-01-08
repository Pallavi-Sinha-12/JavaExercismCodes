import java.util.List;
import java.util.ArrayList;

class PythagoreanTriplet
{
    private int a,b,c;
    private static int N;
    
    private static List<PythagoreanTriplet> tripletsList = new ArrayList<>();
    private static PythagoreanTriplet instance = new PythagoreanTriplet();
    
    public PythagoreanTriplet()
    {
        
    }
    
    public PythagoreanTriplet(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static PythagoreanTriplet makeTripletsList()
    {
        tripletsList = new ArrayList<>();
        return instance;
    }
    
    public static PythagoreanTriplet withFactorsLessThanOrEqualTo(int limit)
    {
        return instance;
    }
    
    public static PythagoreanTriplet thatSumTo(int sum)
    {
        N = sum;
        return instance;
    }
    
    public static List<PythagoreanTriplet> build()
    {
        for(int i = 1; i<=N/3; i++)
        {
            for(int j=i+1; j<=(N-i)/2; j++)
            {
                int k = N-i-j;
                if (Math.pow(i,2) + Math.pow(j,2) == Math.pow(k,2))
                {
                    tripletsList.add(new PythagoreanTriplet(i,j,k));
                }
            }
        }
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
        if ((this.a == triplet.a ) && (this.b==triplet.b) && (this.c == triplet.c))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}