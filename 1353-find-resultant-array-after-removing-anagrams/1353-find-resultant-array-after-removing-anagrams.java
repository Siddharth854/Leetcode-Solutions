class Solution {
    public String sorter(String initial)
    {
        char[] ch = initial.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> arr = new ArrayList<>();
        for (String s: words)
        arr.add(s);

        while (true)
        {
            boolean flag = false;
            for (int i = 0; i < arr.size() - 1; i++)
            {
                String s1 = sorter(arr.get(i));
                String s2 = sorter(arr.get(i + 1));

                if (s1.equals(s2))
                {
                    flag = true;
                    arr.remove(i + 1);
                    break;
                }

                

            }
            if (!flag)
                return arr;
        }
    }
}