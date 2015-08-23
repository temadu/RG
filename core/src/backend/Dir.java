package backend;


public enum Dir { 
	NORTH,
	SOUTH,
	WEST,
	EAST;
	
	public Dir getOpposite(Dir dir){
		switch (dir) {
		case NORTH:
			return SOUTH;
		case SOUTH:
			return NORTH;
		case EAST:
			return WEST;
		case WEST:
			return EAST;
		}
		return dir;
		
	}
}


