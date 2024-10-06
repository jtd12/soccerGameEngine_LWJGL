package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import models.texturedModel;
import terrains.terrain;

public class roues extends entity{
	double wheelRadius = 0.05;
	
	public roues(texturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale,1,1,1);
		
		// TODO Auto-generated constructor stub
	}
	
	public void setParent(player p,terrain t,float pos,float pos2)
	{
	if(p.getCurrentSpeed()>-70)
	{
	this.getPosition().x=(float) ((p.getPosition().x)+(pos*Math.cos((-Math.toRadians(p.getRotY())))));
	this.getPosition().y=(p.getPosition().y-5);
	this.getPosition().z=(float) ((p.getPosition().z)+(pos*Math.sin((-Math.toRadians(p.getRotY())))));
	

	 this.setRotY(p.getRotY());
	}
	else
	{
		this.getPosition().x=(float) ((p.getPosition().x)+(pos2*Math.cos((-Math.toRadians(p.getRotY())))));
		this.getPosition().y=(p.getPosition().y-5.5f);
		this.getPosition().z=(float) ((p.getPosition().z)+(pos2*Math.sin((-Math.toRadians(p.getRotY())))));
		

		 this.setRotY(p.getRotY());
	}

	
	
	//this.setIncrementeRotZ(0.5f);
	
	/*float terrainHeights=t.getHeightTerrain(this.getPosition().x, this.getPosition().z);
	
	if(this.getPosition().y<terrainHeights-4)
	{
		this.getPosition().y=terrainHeights-4;
	}
	*/
  }
	public void turnRotZ()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			this.increaseRotation(0,0,2.95f);
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			this.increaseRotation(0,0,-2.95f);
			
		}
	}
		
	
	
}
