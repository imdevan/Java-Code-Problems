

public int findVolume(int x, int y, int[][] grid) {
	int color = grid[x][y];
	int count;
int [] c = {x,y};
int currentColor;
HashSet<Integer[]> seen = new HashSet<Integer[]>();
Queue<Integer[]> toVisit = new Queue<Integer[]>();

toVisit.add(c);

while(toVisit.size() > 0)
{	
	// set curent to first element in queue
	c = toVisit.remove();
	seen.add(c);
	
	
	// check if element is color
	if(grid[c[0]][c1]] != color)
	{
		continue;
	}
	else
	{
		count++;
	}
	
	// Adding neighbors to queue
	int[] top = {[c[0], c[1]-1};
	int[] b = {[c[0], c[1]+1};
	int[] r = {[c[0]+1, c[1]};
	int[] l = {[c[0]-1, c[1]};

	if(!seen.contains(top)
		toVisit.add(top);
	if(!seen.contains(b)
		toVisit.add(b);
	if(!seen.contains(r)
		toVisit.add(r);
	if(!seen.contains(l)
		toVisit.add(l);
	
}	

	return count;
}
