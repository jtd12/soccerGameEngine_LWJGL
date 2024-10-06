package entities;

import org.lwjgl.util.vector.Vector3f;

public class maths_vector {
	
	float x,y,z;
	
	public float length(){
	    return (float) Math.sqrt(x*x + y*y+ z*z);
	}

	public void normalize(){
		float len=length();
	    if(len !=0){
	    	x /= len;
	    	y /= len;
	    	z /= len;
	    }
	}

	   public void change(Vector3f vec)
	   {
		   x=vec.x;
		   y=vec.y;
		   z=vec.z;
	   }
}
