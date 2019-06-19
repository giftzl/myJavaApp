package algorithum;

import java.util.Stack;

public class InFixToPostFix {   
	
	
    public static boolean isWord(String s) {
        return s.matches("\\w");
    }   
    public static boolean isOpr(String s) {
        return (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/"))?true:false;
    }

    public static void main(String[] args) {
       
        String string="2+5*(3+4)-(2*2)";
        String[] strings =string.split("");
        StringBuilder expr=new StringBuilder();
        Stack<String> oprStack=new Stack<>();

        for (int i = 0; i < strings.length; i++) {
            if (isWord(strings[i])) {
                // 如果是数字或者字母则直接组成表达式
                expr.append(strings[i]);
            }else if (strings[i].equals("(")) {
                // 如果是左括号则直接压入
                oprStack.push("(");
            }else if (isOpr(strings[i])) {
                // 如果是操作符需要考虑优先级
                if (strings[i].equals("+")||strings[i].equals("-")) {
                    // +-运算需要比较当前操作符栈顶的优先级才能入栈
                    if (oprStack.isEmpty()) {
                        oprStack.push(strings[i]);// 栈空则直接入栈
                    }else {
                        // 如果栈顶优先级更高，则要将栈顶出栈并组成表达式，直到栈顶的优先级和+-的一样
                        while(oprStack.peek().equals("*")||oprStack.peek().equals("/")){
                            expr.append(oprStack.pop());
                            if (oprStack.isEmpty()) {
                                break;
                            }
                        }
                        //将当前操作符入栈
                        oprStack.push(strings[i]);
                    }
                }else if (strings[i].equals("*")||strings[i].equals("/")) {
                    // 表达式中*/的优先级最高，不用比较
                    oprStack.push(strings[i]);
                }
            }else if (strings[i].equals(")")) {
                // 如果是右括号，则操作符出栈直到匹配到左括号
                while (!oprStack.peek().equals("(")) {
                    expr.append(oprStack.pop());
                }
                oprStack.pop();// 匹配到的左括号最后也要出栈
            }
        }
        // 将栈中剩余的操作符出栈组成表达式
        while (!oprStack.isEmpty()) {
            expr.append(oprStack.pop());
        }
        System.out.println(expr);
    }
}