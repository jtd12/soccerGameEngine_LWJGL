package entities;

import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import models.rawModel;
import models.texturedModel;
import renderEngine.DisplayManager;
import terrains.terrain;


public class AnimatedEntity extends entity {
    private List<texturedModel> frames;  // Liste des modèles texturés pour chaque frame
    private int currentFrame = 0;  // Frame actuelle de l'animation
    private float frameTime = 0f;  // Temps écoulé depuis le dernier changement de frame
    private float frameDuration = 0.1f;  // Durée entre chaque frame (0.1s par frame, ajustable)
	private   float speedMovementX=0.0f;
	private   float speedMovementZ=0.0f;
	private   float turnSpeed=0.0f;
	private   float speed=0.7f;
	private static final float gravity=-0.5f;
	private  static final float turn_speed=80;
	private float dx;
	private float dz;
	private boolean hastheball=false;
	//private static final float terrain_height=0;
	private int up,down,right,left=0;
	private  float currentSpeed=0;
	private  float currentTurnSpeed=0;
	private float maxSpeed=180.0f;
	private float acc=0.58f;
	private float dec=0.15f;
	private float dec2=0.85f;
	private int space=0;
	private float upwardspeed=0;
	private boolean enter=false;
	private boolean passer=false;
	private float velocityX=5.0f;
	private boolean follow=false;
	maths_vector vectors=new maths_vector();
    public AnimatedEntity(List<texturedModel> frames,Vector3f position, float rotX, float rotY, float rotZ, float scale,float scaleX,float scaleY,float scaleZ) {
    	super(frames, position, rotX, rotY, rotZ, scale,scaleX,scaleY,scaleZ);
        this.frames = frames;
    }

    // Mise à jour de l'animation en fonction du deltaTime
    public void updateAnimation(float deltaTime) {
        frameTime += deltaTime;
        if (frameTime >= frameDuration) {
            currentFrame = (currentFrame + 1) % frames.size();  // Passe à la frame suivante, boucle si nécessaire
            frameTime = 0;
        }
    }

    // Retourne la frame actuelle à utiliser pour le rendu
    public texturedModel getCurrentFrameModel() {
    	if (frames != null && !frames.isEmpty()) {
        return frames.get(currentFrame);
    	}
    	 return null;
    }
    
    public float getCurrentSpeed()
	{
		return speedMovementX;
	}
	public void setSpeedPlayer(float s)
	{
		currentSpeed=s;

	}
	
	public void setSpeedCar(float s)
	{
		currentSpeed=s;
	}
	public void setSpeedPlayer(float dx,float dz)
	{
		speedMovementX=dx;
		speedMovementZ=dz;
	}
	
    public void inputCar(List<roues> ww,List<roues> rr)
	{
		checkInputsCar(ww,rr);
	}
	
	public void move(terrain t,List<roues> ww,List<roues> rr)
	{
		System.out.print(currentSpeed);
	
		
		super.increaseRotation(0, currentTurnSpeed*DisplayManager.getTimeFrameSeconds(), 0);
		float dist=currentSpeed*DisplayManager.getTimeFrameSeconds();
		float dx= (float) (dist*Math.sin(Math.toRadians(super.getRotY())));
		float dz= (float) (dist*-Math.cos(Math.toRadians(super.getRotY())));
		super.increasePosition(dz, 0, dx);
		upwardspeed+=gravity*DisplayManager.getTimeFrameSeconds();
		super.increasePosition(0, upwardspeed*DisplayManager.getTimeFrameSeconds(), 0);
		float terrainHeights=t.getHeightTerrain(super.getPosition().x, super.getPosition().z);
		if(super.getPosition().y<terrainHeights+15)
		{
			upwardspeed=0;
			super.getPosition().y=terrainHeights+15;
		}
	}
	
	public void move(terrain t)
	{
		super.increaseRotation(0, currentTurnSpeed*DisplayManager.getTimeFrameSeconds(), 0);
		float dist=currentSpeed*DisplayManager.getTimeFrameSeconds();
		float dx= (float) (dist*Math.cos(Math.toRadians(super.getRotY())));
		float dz= (float) (dist*-Math.sin(Math.toRadians(super.getRotY())));
		super.increasePosition(dx, 0, dz);
		upwardspeed+=gravity*DisplayManager.getTimeFrameSeconds();
		super.increasePosition(0, upwardspeed*DisplayManager.getTimeFrameSeconds(), 0);
		float terrainHeights=t.getHeightTerrain(super.getPosition().x, super.getPosition().z);
		if(super.getPosition().y<terrainHeights+20)
		{
			upwardspeed=0;
			super.getPosition().y=terrainHeights+20;
		}
	}
	
	public void move(float maxGravity)
	{

		
		//super.increaseRotation(0, turnSpeed*DisplayManager.getTimeFrameSeconds(), 0);
		float distX=speedMovementX*DisplayManager.getTimeFrameSeconds();
		float distZ=speedMovementZ*DisplayManager.getTimeFrameSeconds();
		dx= (float) (-distX);
		 dz= (float) (distZ);
		//super.increasePosition(dx, 0, dz);
		upwardspeed+=gravity*DisplayManager.getTimeFrameSeconds();
		super.increasePosition(0, upwardspeed*DisplayManager.getTimeFrameSeconds(), 0);
		
		//float terrainHeights=t.getHeightTerrain(super.getPosition().x, super.getPosition().z);
		if(super.getPosition().y<maxGravity)
		{
			upwardspeed=0;
			super.getPosition().y=maxGravity;
		}
	}
	
	public void setRotation()
	{
		super.setRotY(turnSpeed);
	}
	

	public void setfollow(boolean v)
	{
		follow=v;
	}
	public boolean getfollow()
	{
		return follow;
	}
	public void AIMovement(Vector3f playerLoc)
	{
	
				
				
				Vector3f newpos = new Vector3f(super.getPosition());
			     
		
			      vectors.change(new Vector3f(playerLoc.x-super.getPosition().x,playerLoc.y-super.getPosition().y,playerLoc.z-super.getPosition().z));
			      vectors.normalize();
		
			      newpos.x+=vectors.x*speed;
			      newpos.y+=vectors.y*speed;
			      newpos.z+=vectors.z*speed;
			    	  
		
			      super.setPosition(newpos);

			      super.setRotY((float) ((float) Math.acos((float)vectors.x)*Math.PI/180));
					
			      if(vectors.z<0)
					{
						super.setRotY(-super.getRotY());
					}
			      
			
	}
	
	public void enterVehicule(AnimatedEntity p1,player p2)
	{
	float d = (float) Math.sqrt(((p1.getPosition().x - p2.getPosition().x) * (p1.getPosition().x - p2.getPosition().x)) + ((p1.getPosition().y - p2.getPosition().y) * (p1.getPosition().y - p2.getPosition().y)) + ((p1.getPosition().z - p2.getPosition().z)  * (p1.getPosition().z - p2.getPosition().z)));
		
		if(d<50 && Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			enter=true;
		}
		
	}
	
	public void exitVehicule(AnimatedEntity p1,player p2)
	{
		float d = (float) Math.sqrt(((p1.getPosition().x - p2.getPosition().x) * (p1.getPosition().x - p2.getPosition().x)) + ((p1.getPosition().y - p2.getPosition().y) * (p1.getPosition().y - p2.getPosition().y)) + ((p1.getPosition().z - p2.getPosition().z)  * (p1.getPosition().z - p2.getPosition().z)));
		
		if(d<50 && Keyboard.isKeyDown(Keyboard.KEY_P))
		{
			enter=false;
		}
		
	}
	public void inputControlManager()
	{
		checkInputsManager();
	}
	public void inputControl(AnimatedEntity p1,player p2)
	{
		float d = (float) Math.sqrt(((p1.getPosition().x - p2.getPosition().x) * (p1.getPosition().x - p2.getPosition().x)) + ((p1.getPosition().y - p2.getPosition().y) * (p1.getPosition().y - p2.getPosition().y)) + ((p1.getPosition().z - p2.getPosition().z)  * (p1.getPosition().z - p2.getPosition().z)));
		
		if(d<15)
		{
			  checkInputs();
		}
		else
		{
	
			setSpeedPlayer(0);
		}
	
	
	
	}
	
	public void inputControl()
	{
		
		
		  checkInputs();
	    
	}
	

	public void controlBall(AnimatedEntity p1,player p2)
	{
		float d = (float) Math.sqrt(((p1.getPosition().x - p2.getPosition().x) * (p1.getPosition().x - p2.getPosition().x)) + ((p1.getPosition().y - p2.getPosition().y) * (p1.getPosition().y - p2.getPosition().y)) + ((p1.getPosition().z - p2.getPosition().z)  * (p1.getPosition().z - p2.getPosition().z)));
		
		if(d<15)
		{
			hastheball=true;
			p2.setPosition(new Vector3f((float) (p1.getPosition().x+Math.cos(Math.toRadians(-p1.getRotY()))*3.5),p1.getPosition().y-6.5f,(float) (p1.getPosition().z-Math.sin(Math.toRadians(-p1.getRotY()))*3.5)));
		}
		else
		{
			hastheball=false;
		}
	}
	public boolean getHasTheBall()
	{
		return hastheball;
	}
	public void setPass(boolean f)
	{
		passer=f;
	}
	public float getVelocity()
	{
		return velocityX;
	}
	public void setVelocity(float v)
	{
		velocityX=v;
	}
	public void setVelocityIncrease(float v)
	{
		velocityX+=v;
	}
	public boolean getPass()
	{
		return passer;
	}
	public int getUP()
	{
		return up;
	}
	public int getDOWN()
	{
		return down;
	}
	public int getRIGHT()
	{
		return right;
	}
	public int getLEFT()
	{
		return left;
	}
	private void control()
	{
	
		
	
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			up=1;
			
			
		}
		
		else if(Keyboard.isKeyDown(Keyboard.KEY_UP)==false)
		{
			up=0;
			
	
			
		}
		
		 if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			down=1;
			
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)==false)
		{
			down=0;
		
			
		}
		
		 if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
		
			right=1;
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)==false)
		{
		
			right=0;
			
		}
		 if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			left=1;
		
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)==false)
		{
			left=0;
			
			
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			//jump();
		
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)==false)
		{
			//jump();
		
			
		}
	}
	
	private void checkInputs()
	{
	
		control();
		
		if(up==1)
		{
	
			turnSpeed=0.0f;
			super.increasePosition(0.5f, 0, 0);
			}
		
		 if(down==1)
		{
		
			 turnSpeed=180.0f;
			 super.increasePosition(-0.5f, 0, 0);
		}
	
		 
		 
		 if(right==1)
			{
		
			 turnSpeed=-90.0f;
			 super.increasePosition(0.0f, 0, 0.5f);
			}
		
		 
		 if(left==1)
			{
	
			 turnSpeed=90.0f;
			 super.increasePosition(0.0f, 0, -0.5f);
			}
			
			 
			 if(up==1 && right==1)
				{
				 turnSpeed=-45.0f;
				}
			 
			 if(up==1 && left==1)
				{
				 turnSpeed=45.0f;
				}
			 
			 if(down==1 && right==1)
				{
				 turnSpeed=-135.0f;
				}
			 
			 if(down==1 && left==1)
				{
				 turnSpeed=135.0f;
				}
	}
	
	private void checkInputsManager()
	{
	
		control();
		
		if(up==1)
		{
			currentSpeed+=0.1f;
			}
		
		else if(down==1)
		{
			 currentSpeed-=0.1f;
		}
		 else
		 {
			 currentSpeed=0.0f;
		 }
	
		 
		 
		 if(right==1)
			{
				
			 currentTurnSpeed-=2.5f;
			}
		 
		 
		 else if(left==1)
			{
			
			 currentTurnSpeed+=2.5f;
			}
		 else
		 {
			 currentTurnSpeed=0.0f;
		 }
			
	}
	
	public void setParentManager(Vector3f pos,Vector3f pos2)
	{
		pos.x=pos2.x;
		pos.z=pos2.z;
	}
	
	private void controlCar(List<roues> ww,List<roues> rr)
	{
		ww.get(0).turnRotZ();
		ww.get(1).turnRotZ();
		rr.get(0).turnRotZ();
		rr.get(1).turnRotZ();
		
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			up=1;
			
		
			
		}
		
		else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)==false)
		{
			up=0;
			
		
		
			
		}
		
		 if(Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			down=1;
			
			
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_UP)==false)
		{
			down=0;
		
		
			
		}
		
		 if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
		
			right=1;
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)==false)
		{
		
			right=0;
			
		}
		 if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			left=1;
		
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)==false)
		{
			left=0;
			
			
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			//jump();
			space=1;
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)==false)
		{
			//jump();
			space=0;
			
		}
		
	}
	
	private void checkInputsCar(List<roues> ww,List<roues> rr)
	{

		  controlCar(ww, rr);
		
		if(up==1 && currentSpeed<maxSpeed)
		{
		
			
			if(currentSpeed<0)
			{
				currentSpeed+=dec;
		 }
			else
			{
				currentSpeed+=acc;
			}
		}
		if(down==1 && currentSpeed>-maxSpeed)
		{
		
			
			
			if(currentSpeed>0)
			{
				currentSpeed-=dec;
			}
			else
			{
				currentSpeed-=acc;
			}
			
		}
		
		if(up==0 && down==0)
		{
			if(currentSpeed-dec>0)
			{
				currentSpeed-=dec;
			}
			else if(currentSpeed+dec<0)
			{
				currentSpeed+=dec;
			}
			else
			{
				currentSpeed=0;
			}
		}
		
			if(space==1)
		{
			if(currentSpeed-dec2>0)
			{
				currentSpeed-=dec2;
			}
			else if(currentSpeed+dec2<0)
			{
				currentSpeed+=dec2;
			}
			else
			{
				currentSpeed=0;
			}
		}
			if(right==1)
			{
				currentTurnSpeed=turn_speed*(currentSpeed/maxSpeed);
				//angle=turnSpeed;
			//	+=turnSpeed*(speed/maxSpeed);
			}
		
			else if(left==1)
			{
				currentTurnSpeed=-turn_speed*(currentSpeed/maxSpeed);
				//angle=turnSpeed;
			//	+=turnSpeed*(speed/maxSpeed);
			}
			else if(left==0 || right==0)
			{
				currentTurnSpeed=0;
				//angle=turnSpeed;
			//	+=turnSpeed*(speed/maxSpeed);
			}

	}
	
	public boolean getEnter()
	{
		return enter;
	}

	public void setHasTheBall(boolean h)
	{
		hastheball=h;
	}
}