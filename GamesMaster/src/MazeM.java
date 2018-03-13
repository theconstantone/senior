import java.util.*;
public class MazeM {
	int sx;
	int sy;
	Cell[][] cells;
	
	public MazeM() {
		sx = 20;
		sy = 20;
		cells = new Cell[sx][sy];
		initializeCells();
		generateMaze();
	}
	
	public MazeM(int x, int y) {
		sx = x;
		sy = y;
		cells = new Cell[sx][sy];
		initializeCells();
		generateMaze();
	}
	
	public void printCells() {
		for(int i = 0; i<sx; i ++) {
			for(int j = 0; j<sy; j++) {
				System.out.print(i + " " + j);
				cells[i][j].printCell();
				System.out.println("\n");
			}
		}
	}
	
	private void initializeCells() {
		for(int i = 0; i<sx; i ++) {
			for(int j = 0; j<sy; j++) {
				cells[i][j] = new Cell();
				cells[i][j].x = i;
				cells[i][j].y = j;
				if (i == 0) {
					cells[i][j].borders[0] = 1;
				}
				if (j == 0) {
					cells[i][j].borders[3] = 1;
				}				
				if (i == sx - 1) {
					cells[i][j].borders[2] = 1;
				}
				if (i == sy - 1) {
					cells[i][j].borders[1] = 1;
				}
			}
		}
	}
	
	private void generateMaze() {
	
		Random rand = new Random();
		int x = rand.nextInt(sx);
		int y = rand.nextInt(sy);
		
		Stack<Cell> cellStack = new Stack<Cell>();
		
		int totalCells = sx * sy;
		int visitedCells = 1;
		
		Cell currentCell = cells[x][y];
		
		ArrayList<Vertex> neighborCellList = new ArrayList<Vertex>();
		
		Vertex tmpV = new Vertex();
		
		while(visitedCells < totalCells) {
			neighborCellList.clear();
			
			tmpV = new Vertex();
			
			if(y-1 >= 0 && cells[x][y-1].checkWalls() == true) {
				tmpV.x1 = x;
				tmpV.y1 = y;
				tmpV.x2 = x;
				tmpV.y2 = y-1;
				tmpV.wall1 = 0;
				tmpV.wall2 = 2;
				neighborCellList.add(tmpV);
			}
			tmpV = new Vertex();
			if(y+1 < sy && cells[x][y+1].checkWalls() == true) {
				tmpV.x1 = x;
				tmpV.y1 = y;
				tmpV.x2 = x;
				tmpV.y2 = y+1;
				tmpV.wall1 = 2;
				tmpV.wall2 = 0;
				neighborCellList.add(tmpV);
			}
			tmpV = new Vertex();
			if(x-1 >= 0 && cells[x-1][y].checkWalls() == true) {
				tmpV.x1 = x;
				tmpV.y1 = y;
				tmpV.x2 = x-1;
				tmpV.y2 = y;
				tmpV.wall1 = 3;
				tmpV.wall2 = 1;
				neighborCellList.add(tmpV);
			}
			tmpV = new Vertex();
			if(x+1 < sx && cells[x+1][y].checkWalls() == true) {
				tmpV.x1 = x;
				tmpV.y1 = y;
				tmpV.x2 = x+1;
				tmpV.y2 = y;
				tmpV.wall1 = 1;
				tmpV.wall2 = 3;
				neighborCellList.add(tmpV);
			}
		
			if(neighborCellList.size() >= 1) {
				
				int r1 = rand.nextInt(neighborCellList.size());
				tmpV = neighborCellList.get(r1);
				
				cells[tmpV.x1][tmpV.y1].walls[tmpV.wall1] = 0;
				cells[tmpV.x2][tmpV.y2].walls[tmpV.wall2] = 0;
				
				cellStack.push(currentCell);
				currentCell = cells[tmpV.x2][tmpV.y2];
				
				x = currentCell.x;
				y = currentCell.y;
				
				visitedCells ++;
				
			}
			else {
				currentCell = cellStack.pop();
				x = currentCell.x;
				y = currentCell.y;
			}
		}
		Random rando = new Random();
		int r = rando.nextInt((3 - 1) + 1) + 1;
		int f = rando.nextInt((3 - 1) + 1) + 1;
		cells[0][0].walls[3] = 0;
		cells[sx-1][sy-1].walls[1] = 0;
	}
}
