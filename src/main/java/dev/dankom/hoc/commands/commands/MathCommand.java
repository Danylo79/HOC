package dev.dankom.hoc.commands.commands;

import dev.dankom.hoc.commands.CommandContext;
import dev.dankom.hoc.commands.ICommand;
import dev.dankom.hoc.util.ListHelper;
import dev.dankom.hoc.util.math.MathHelper;

public class MathCommand implements ICommand {
    @Override
    public String getName() {
        return "math";
    }

    @Override
    public String[] getHelps() {
        return ListHelper.toArray("~math [num1] [operator] [num2]: Performs Math statement passed in", "~math operators: Lists Operators");
    }

    @Override
    public void handle(CommandContext ctx) {
        if (ctx.args.get(0).equalsIgnoreCase("operators")) {
            for (MathHelper.Operator s : MathHelper.Operator.values()) {
                ctx.sendMessage(s.name().toUpperCase() + " - " + s.getOp());
            }
        } else {
            String text = "";
            for (int i = 0; i < ctx.args.size(); i++) {
                if (i == ctx.args.size() - 1) {
                    text += ctx.args.get(i);
                } else {
                    text += ctx.args.get(i) + " ";
                }
            }

            MathHelper.math(ctx, MathHelper.Parser.parse(text));
        }
    }
}
