package dev.lambdaurora.spruceui.test;

import dev.lambdaurora.spruceui.background.Background;
import dev.lambdaurora.spruceui.background.DefaultBackground;
import dev.lambdaurora.spruceui.background.DirtTexturedBackground;
import dev.lambdaurora.spruceui.widget.SpruceWidget;
import dev.lambdaurora.spruceui.widget.container.SpruceEntryListWidget;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public enum WidgetBackground {
    DIRT_NORMAL(w -> DirtTexturedBackground.NORMAL),
    DIRT_DARK(w -> DirtTexturedBackground.DARKENED),
    DEFAULT(w -> w instanceof SpruceEntryListWidget<?> ? DefaultBackground.LIST : DefaultBackground.DEFAULT);

    private final Function<SpruceWidget, Background> f;

    WidgetBackground(Function<SpruceWidget, Background> w){
        this.f = w;
    }

    public Background apply(SpruceWidget widget){
        return f.apply(widget);
    }

    /**
     * Returns the next enum value available.
     *
     * @return The next available enum value.
     */
    public @NotNull WidgetBackground next() {
        var v = values();
        if (v.length == this.ordinal() + 1)
            return v[0];
        return v[this.ordinal() + 1];
    }
}
