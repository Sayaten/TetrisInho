
public class Plane {	
	private int[][] plane = null; 
	public int dy, dx; 	
	private void alloc(int cy, int cx) {
		dy = cy;
		dx = cx;
		plane = new int[dy][dx];
	}	
	public Plane() {
		alloc(0, 0); 
	}		
	public Plane(int cy, int cx){
		alloc(cy, cx); 
		for(int y = 0; y < dy; y++)
			for(int x = 0; x < dx; x++)
				plane[y][x] = 0; 	
	}	
	public Plane(Plane copy) {
		alloc(copy.dy, copy.dx);
		for(int y = 0; y < dy; y++)
			for(int x = 0; x < dx; x++)
				plane[y][x] = copy.plane[y][x]; 		
	}
	
	public Plane(int[][] arr){
		alloc(arr.length, arr[0].length); 
		for(int y = 0; y < dy; y++)
			for(int x = 0; x < dx; x++)
				plane[y][x] = arr[y][x]; 
	}

	public int[][] get_ref() {
		return plane;
	}
	
	public void paste(Plane pattern, int top, int left){
		if((dx == 0) ||(dy == 0)){
			System.out.println("not initialized"); 
			System.exit(0); 
		}
		for(int y = 0; y < pattern.dy; y++)
			for(int x = 0; x < pattern.dx; x++)
				plane[y + top][x + left] = pattern.plane[y][x]; 
	}
	
	public Plane clip(int top, int left, int bottom, int right){
		int cy = bottom - top; 
		int cx = right - left; 
		Plane Temp = new Plane(cy, cx);
		for(int y = 0; y < cy; y++){
			for(int x = 0; x < cx; x++){
				if(cy <= dy && cx <= dx) 
					Temp.plane[y][x] = plane[y+top][x+left];
				else{
					System.out.println("Cliped size is bigger than original.");
					System.exit(0); 
				}			
			}
		}
		return Temp; 
	}
	
	public void add(Plane obj){
		if((dx != obj.dx) && (dy != obj.dy)){
			System.out.println("different sizes"); 
			System.exit(0); 
		}
		for(int y = 0; y < obj.dy; y++)
			for(int x = 0; x < obj.dx; x++)
				this.plane[y][x] += obj.plane[y][x]; 
	}
	
	public int sum(){
		int total = 0;
		for(int y = 0; y < dy; y++)
			for(int x = 0; x < dx; x++)
				total += plane[y][x];
		return total;
	}	

	public void mulc(int coef){
		for(int y = 0; y < dy; y++)
			for(int x = 0; x < dx; x++)
				plane[y][x] = coef * plane[y][x];
	}	
	
	public boolean any_more_than(int val){
		for(int y = 0; y < plane.length; y++){
			for(int x = 0; x < plane[0].length ; x++){
				if (plane[y][x] > val) return true;  
			}
		}
		return false; 
	}	
	// end of Plane
}

