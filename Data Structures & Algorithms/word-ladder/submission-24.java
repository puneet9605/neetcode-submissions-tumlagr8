class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        int steps = 0;
        Deque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
                steps++;
                while(size>0){
                    String curr = queue.removeFirst();
                    char[] currArray = curr.toCharArray();
                    for(int i =0; i<currArray.length ;i++){
                        char original = currArray[i];
                        for(char c = 'a'; c<='z'; c++){
                            if(c==original) continue;
                            currArray[i] = c;
                            String next = new String(currArray);
                            if(next.equals(endWord)){
                                return steps+1;
                            }
                            if(dict.contains(next)){
                                queue.add(next);
                                dict.remove(next);
                            }

                        }
                         currArray[i] = original;
                    }

                    size--;
                }
           
        }
        return 0;
        
    }
}
