package entities;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

public class collision {

	public boolean isCollision(Vector3f playerPos, Vector3f playerScale, Vector3f entitiesPos,Vector3f entitiesScale) {

		 if ( 
			        ( playerPos.x <= entitiesScale.x + entitiesPos.x && playerScale.x+20 + playerPos.x >= entitiesPos.x-entitiesScale.x) 
			       // (playerPos.y <=   entitiesPos.y+entitiesScale.y ) && 
			       && ( playerPos.z <= (-1.5f*entitiesScale.z) + entitiesPos.z && playerScale.z+70 + playerPos.z >= (-3.5f*entitiesScale.z)+entitiesPos.z-entitiesScale.z)  
			       ) 
			 {
	        System.out.println("Player is colliding!!!");
	        return true;
	        //p.increasePosition(0,0,4.5f*invert);
	        
	    }
	    return false;
	 
	}

}
