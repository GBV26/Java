import java.util.Stack;

public class ParenthesisChecker {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch); // Добавляем открывающую скобку в стек
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // Если стек пуст, значит нет соответствующей открывающей скобки
                }
                stack.pop(); // Удаляем последнюю открывающую скобку из стека
            }
        }

        return stack.isEmpty(); // Если стек пуст, все скобки корректны
    }

    public static void main(String[] args) {
        // Примеры для тестирования
        String[] testCases = {
            "()",
            "(()()((()))))",
            "(((())()",
            "((()))",
            "(()())"
        };

        for (String testCase : testCases) {
            System.out.println("Input: \"" + testCase + "\" => " + isValid(testCase));
        }
    }
}
