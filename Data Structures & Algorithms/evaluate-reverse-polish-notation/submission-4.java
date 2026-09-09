class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> equation = new Stack<>();
        int a;
        int b;
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].equals("+")){
                a = equation.pop();
                b = equation.pop();
                equation.push(a+b);
            }else if (tokens[i].equals("-")){
                a = equation.pop();
                b = equation.pop();
                equation.push(b-a);
            }else if (tokens[i].equals("*")){
                a = equation.pop();
                b = equation.pop();
                equation.push(a*b);
            }else if (tokens[i].equals("/")){
                a = equation.pop();
                b = equation.pop();
                equation.push(b/a);
            }else {
                equation.push(Integer.parseInt(tokens[i]));
            }
        }
        return equation.pop();
    }
}
