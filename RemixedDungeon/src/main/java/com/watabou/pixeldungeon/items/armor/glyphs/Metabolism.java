/*
 * Pixel Dungeon
 * Copyright (C) 2012-2014  Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.items.armor.glyphs;

import com.nyrds.pixeldungeon.ml.R;
import com.nyrds.platform.game.Game;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.buffs.Hunger;
import com.watabou.pixeldungeon.items.armor.Armor;
import com.watabou.pixeldungeon.items.armor.Armor.Glyph;
import com.watabou.pixeldungeon.sprites.CharSprite;
import com.watabou.pixeldungeon.sprites.ItemSprite;
import com.watabou.pixeldungeon.sprites.ItemSprite.Glowing;
import com.watabou.pixeldungeon.ui.BuffIndicator;
import com.watabou.pixeldungeon.utils.Utils;
import com.watabou.utils.Random;

public class Metabolism extends Glyph {

	private static ItemSprite.Glowing RED = new ItemSprite.Glowing( 0xCC0000 );
	
	@Override
	public int defenceProc(Armor armor, Char attacker, Char defender, int damage) {

		int level = Math.max( 0, armor.level() );
		if (Random.Int( level / 2 + 5 ) >= 4) {
			
			int healing = Math.min( defender.ht() - defender.hp(), Random.Int( 1, defender.ht() / 5 ) );

			if (healing > 0) {
				if (!defender.isStarving()) {

					defender.hunger().satisfy(-Hunger.STARVING / 10);
					BuffIndicator.refreshHero();

					defender.heal(healing,this);
					defender.getSprite().showStatus( CharSprite.POSITIVE, Integer.toString( healing ) );
				}
			}
		}
		
		return damage;
	}
	
	@Override
	public String name( String weaponName) {
		return Utils.format( Game.getVar(R.string.Metabolism_Txt), weaponName );
	}

	@Override
	public Glowing glowing() {
		return RED;
	}
}
