package com.nyrds.platform.game;

import com.nyrds.pixeldungeon.game.GameLoop;
import com.watabou.pixeldungeon.scenes.BadgesScene;
import com.watabou.pixeldungeon.scenes.PixelScene;
import com.watabou.pixeldungeon.scenes.TitleScene;

public class RemixedDungeon extends Game {
    public static final double[] MOVE_TIMEOUTS = new double[]{250, 500, 1000, 2000, 5000, 10000, 30000, 60000, Double.POSITIVE_INFINITY };

    public RemixedDungeon() {
        super(TitleScene.class);

        // remix 0.5
        com.watabou.utils.Bundle.addAlias(
                com.watabou.pixeldungeon.items.food.Ration.class,
                "com.watabou.pixeldungeon.items.food.Food");
        // remix 23.1.alpha
        com.watabou.utils.Bundle.addAlias(
                com.nyrds.pixeldungeon.mobs.guts.SuspiciousRat.class,
                "com.nyrds.pixeldungeon.mobs.guts.Wererat");
        // remix 23.2.alpha
        com.watabou.utils.Bundle.addAlias(
                com.nyrds.pixeldungeon.items.guts.weapon.melee.Claymore.class,
                "com.nyrds.pixeldungeon.items.guts.weapon.melee.BroadSword");
        // remix 24
        com.watabou.utils.Bundle.addAlias(
                com.nyrds.pixeldungeon.items.accessories.Bowknot.class,
                "com.nyrds.pixeldungeon.items.accessories.BowTie");
        // remix 24
        com.watabou.utils.Bundle.addAlias(
                com.nyrds.pixeldungeon.items.accessories.Nightcap.class,
                "com.nyrds.pixeldungeon.items.accessories.SleepyHat");
        // remix 27.2.beta
        com.watabou.utils.Bundle.addAlias(
                com.nyrds.pixeldungeon.items.books.TomeOfKnowledge.class,
                "com.nyrds.pixeldungeon.items.books.SpellBook");

        com.watabou.utils.Bundle.addAlias(
                com.nyrds.pixeldungeon.mechanics.buffs.RageBuff.class,
                "com.watabou.pixeldungeon.items.quest.CorpseDust.UndeadRageAuraBuff"
        );

        com.watabou.utils.Bundle.addAlias(
                com.watabou.pixeldungeon.actors.mobs.FireElemental.class,
                "com.watabou.pixeldungeon.actors.mobs.Elemental"
        );

    }

    public static boolean isAlpha() {
        return version.contains("alpha") || version.contains("in_dev");
    }

    public static boolean isDev() {
        return version.contains("in_dev");
    }

    public static void updateImmersiveMode() {
    }
    public static void landscape(boolean value) {

    }
    public static boolean landscape() {
        return false;
    }

    public static void switchNoFade(Class<? extends PixelScene> c) {
        PixelScene.noFade = true;
        GameLoop.switchScene(c);
    }

    public static boolean canDonate() {
        return false; // For now we can not donate in the libgdx version
    }

    public static boolean storedLandscape() {
        return false;
    }
}
