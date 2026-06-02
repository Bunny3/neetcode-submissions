class Solution {
    public int evaulation(String a, String b, char operator) {
        int value =0;
        int op1 = Integer.parseInt(a);
        int op2 = Integer.parseInt(b);
        switch(operator) {
            case '+':return value=op2+op1;
            case '-':return value=op2-op1;
            case '*':return value=op2*op1;
            case '/':return value=op2/op1;
        }
        return 0;
    }
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int i=0;
        String operator ="+-*/";
        while(i<tokens.length) {
            String str = tokens[i];
            char ch = str.charAt(0);
            
            if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")) {
                String operand1 = stack.isEmpty()?"":stack.pop();
                String operand2 = stack.isEmpty()?"":stack.pop();
                int value = evaulation(operand1,operand2,ch);
                stack.push(value+"");
            } else {
                stack.push(str);
            }
            i++;
        }
        // while(!stack.isEmpty())
        
        return Integer.parseInt(stack.pop());
    }
}
