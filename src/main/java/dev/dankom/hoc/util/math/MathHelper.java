package dev.dankom.hoc.util.math;

import dev.dankom.hoc.commands.CommandContext;
import dev.dankom.hoc.util.StringFormatter;

import java.util.Arrays;
import java.util.List;

public class MathHelper {
    public static void math(CommandContext ctx, Input i) {
        String answer = "";
        if (!i.isOpValid()) {
            ctx.sendMessage("Operator " + i.opRaw + " is not valid!");
            return;
        }
        if (i.op.type == 1) {
            answer = StringFormatter.format("" + i.n1, " ", i.opRaw, " ", "" + i.n2, " = " + i.op.math(i.n1, i.n2));
        } else {
            answer = StringFormatter.format("" + i.n1, " ", i.opRaw, " = " + i.op.math(i.n1));
        }
        ctx.sendMessage(answer);
    }

    public static class Input {
        public final int n1;
        public final int n2;
        public final Operator op;
        public final String opRaw;

        public Input(int n1, String op, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.opRaw = op;
            this.op = Operator.get(this.opRaw);
        }

        public Input(int n1, String op) {
            this.n1 = n1;
            this.n2 = -1;
            this.opRaw = op;
            this.op = Operator.get(this.opRaw);
        }

        public boolean isOpValid() {
            return op != null;
        }
    }

    public static class Parser {
        public static Input parse(String text) {
            List<String> parsed = Arrays.asList(text.split(" "));
            try {
                int num1 = Integer.parseInt(parsed.get(0));
                int num2 = Integer.parseInt(parsed.get(2));
                return new Input(num1, parsed.get(1), num2);
            } catch (Exception e) {
                int num1 = Integer.parseInt(parsed.get(0));
                return new Input(num1, parsed.get(1));
            }
        }
    }

    public enum Operator {

        ADD("+", 1) {
            @Override
            public int math(int num1, int num2) {
                return num1 + num2;
            }
        },
        SUBTRACT("-", 1) {
            @Override
            public int math(int num1, int num2) {
                return num1 - num2;
            }
        },
        DIVIDE("/", 1) {
            @Override
            public int math(int num1, int num2) {
                return num1 / num2;
            }
        },
        MULTIPLY("*", 1) {
            @Override
            public int math(int num1, int num2) {
                return num1 * num2;
            }
        },
        SQUARE("squared", 2) {
            @Override
            public int math(int num1) {
                return num1 * num1;
            }
        };

        private final String op;
        private final int type;

        Operator(String op, int type) {
            this.op = op;
            this.type = type;
        }

        public String getOp() {
            return op;
        }

        public int getType() {
            return type;
        }

        public int math(int num1, int num2) {
            return 0;
        }

        public int math(int num1) {
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
