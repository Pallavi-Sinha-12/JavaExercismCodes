import java.util.*;
class BookStore
    {
        private static final int BOOK_PRICE = 8;
        private Map<Integer, Double> discountRates;
        private double final_discounted_price;

        private Map<Integer, Integer> booksCountMap;
        private List<Integer> discountGroups;
        
        public BookStore()
        {
            discountRates  = Map.of(1, 0.0, 2, 0.05, 3, 0.1, 4, 0.2, 5, 0.25);
        }


        public Map<Integer, Integer> getBooksCountMap(List<Integer> books)
        {
            booksCountMap = new HashMap<>();
            for (Integer book: books)
                {
                    if (booksCountMap.containsKey(book))
                    {
                        booksCountMap.put(book, booksCountMap.get(book) + 1);
                    }
                    else
                    {
                        booksCountMap.put(book , 1);
                    }
                }
            return booksCountMap;
        }

        public List<Integer> getDiscountGroups(Map<Integer, Integer> booksCountMap)
        {
            discountGroups = new ArrayList<>();
            
            while (booksCountMap.size()>0)
                {
                    discountGroups.add(booksCountMap.size());
                    Set<Integer> toBeRemoved = new HashSet<>();
                    for (Integer key : booksCountMap.keySet())
                        {
                            if (booksCountMap.get(key)==1)
                                toBeRemoved.add(key);
                            else
                                booksCountMap.put(key, booksCountMap.get(key)-1);
                        }
                    booksCountMap.keySet().removeAll(toBeRemoved);
                }
            return discountGroups;
        }
        public List<Integer> getOptimizedDiscountGroups(Map<Integer, Integer> booksCountMap)
        {
            discountGroups = getDiscountGroups(booksCountMap);
            while (discountGroups.contains(3) && discountGroups.contains(5))
                {
                    discountGroups.remove(new Integer(3));
                    discountGroups.remove(new Integer(5));
                    discountGroups.add(4);
                    discountGroups.add(4);
                }
            return discountGroups;
        }
        public double calculateBasketCost(List<Integer> books)
        {
            booksCountMap = getBooksCountMap(books);
            discountGroups = getOptimizedDiscountGroups(booksCountMap);
            for (Integer quantity : discountGroups)
                {
                    double discounted_group_price = (BOOK_PRICE - this.discountRates.get(quantity)*BOOK_PRICE)*quantity;
                    final_discounted_price += discounted_group_price;
                }
            return final_discounted_price;
            
            
        }
        
    }