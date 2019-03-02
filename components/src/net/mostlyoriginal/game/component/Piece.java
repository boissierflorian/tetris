package net.mostlyoriginal.game.component;

import com.artemis.Component;
import com.artemis.annotations.PooledWeaver;

@PooledWeaver
public class Piece extends Component {
	PieceType type;
}
