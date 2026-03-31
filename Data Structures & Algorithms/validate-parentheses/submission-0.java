class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for(Character str: s.toCharArray()){
            if (brackets.containsKey(str)){
                if(stack.isEmpty() || stack.removeLast() != brackets.get(str)){
                    return false;
                }

            } else {
                stack.addLast(str);
            }
        } 
        return stack.isEmpty()? true: false;

        
    }
}
