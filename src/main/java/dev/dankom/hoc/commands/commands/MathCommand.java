package dev.dankom.hoc.commands.commands;

import dev.dankom.hoc.commands.CommandContext;
import dev.dankom.hoc.commands.ICommand;
import dev.dankom.hoc.util.math.MathHelper;

public class MathCommand implements ICommand {
    @Override
    public String getName() {
        return "math";
    }

    @Override
    public void handle(CommandContext ctx) {
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
