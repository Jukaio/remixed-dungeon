package com.nyrds.pixeldungeon.items.guts;

import com.nyrds.pixeldungeon.ml.R;
import com.nyrds.pixeldungeon.mobs.guts.SpiritOfPain;
import com.nyrds.platform.game.Game;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.mobs.Mob;
import com.watabou.pixeldungeon.items.rings.Artifact;
import com.watabou.pixeldungeon.items.rings.ArtifactBuff;
import com.watabou.pixeldungeon.ui.BuffIndicator;

public class HeartOfDarkness extends Artifact {

	public HeartOfDarkness() {
		imageFile = "items/artifacts.png";
		image = 18;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}

	@Override
	protected ArtifactBuff buff() {
		return new HeartOfDarknessBuff();
	}

	public static class HeartOfDarknessBuff extends ArtifactBuff {
		@Override
		public int icon() {
			return BuffIndicator.DARKVEIL;
		}

		@Override
		public String name() {
			return Game.getVar(R.string.DarkVeil_Buff);
		}

		@Override
		public int defenceProc(Char defender, Char enemy, int damage) {
			int defenderPos = defender.getPos();
			int spiritPos = defender.level().getEmptyCellNextTo(defenderPos);

			if (defender.level().cellValid(spiritPos)) {
				SpiritOfPain spirit = new SpiritOfPain();
				spirit.setPos(spiritPos);
				Mob.makePet(spirit, defender.getId());
				defender.level().spawnMob(spirit, 0, defenderPos);
			}
			return damage;
		}
	}
}
