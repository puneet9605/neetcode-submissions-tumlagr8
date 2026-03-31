class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s: tokens){
            Character c = s.charAt(0);
            if (s.length()>1 || Character.isDigit(c)){
                stack.addLast(Integer.parseInt(s));
            } else {
                int op=0;
                int a = stack.removeLast();
                int b = stack.removeLast();
                if (c=='+'){
                    op = a+b;
                }
                if (c=='-'){
                    op = b-a;   
                }
                if (c=='*'){
                    op = b*a;
                }
                if (c=='/'){
                    op = b/a;
                }
                stack.addLast(op);
            }
        }
        return stack.peekLast();
        
    }
}
