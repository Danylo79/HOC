package dev.dankom.hoc.util.math;

import dev.dankom.hoc.commands.CommandContext;
import dev.dankom.hoc.util.StringFormatter;

import java.util.Arrays;
import java.util.List;

public class MathHelper {
    public static void math(CommandContext ctx, Input i) {
        String answer = StringFormatter.format( "" + i.n1, " ", i.op.getOp(), " ", "" + i.n2, " = " + i.op.math(i.n1, i.n2));
        if (i.isOpValid()) {
            ctx.sendMessage(answer);
        } else {
            ctx.sendMessage("Operator " + i.op + " is not valid!");
        }
    }

    public static class Input {
        private final int n1;
        private final Operator op;
        private final int n2;

        public Input(int n1, Operator op, int n2) {
            this.n1 = n1;
            this.op = op;
            this.n2 = n2;
        }

        public boolean isOpValid() {
            return op != null;
        }
    }

    public static class Parser {
        public static Input parse(String text) {
            List<String> parsed = Arrays.asList(text.split(" "));
            int num1 = Integer.parseInt(parsed.get(0));
            int num2 = Integer.parseInt(parsed.get(2));
            Operator op = Operator.get(parsed.get(1));
            return new Input(num1, op, num2);
        }
    }

    public enum Operator {

        PLUS("+") {
            @Override
            public int math(int num1, int num2) {
                return num1 + num2;
            }
        },
        SUBTRACT("-") {
            @Override
            public int math(int num1, int num2) {
                return num1 - num2;
            }
        },
        DIVIDE("/") {
            @Override
            public int math(int num1, int num2) {
                return num1 / num2;
            }
        },
        MULTIPLY("*") {
            @Override
            public int math(int num1, int num2) {
                return num1 * num2;
            }
        }
        ;

        private final String op;

        Operator(String op) {
            this.op = op;
        }

        public String getOp() {
            return op;
        }

        public int math(int num1, int num2) {
            return 0;
        }

        public static Operator get(String op) {
            for (Operator o : values()) {
                if (o.getOp().equalsIgnoreCase(op)) {
                    return o;
                } else {
                    continue;
                }
            }
            return null;
        }
    }
}
