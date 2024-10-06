package entities;

import java.util.List;
import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

public class passsytem{

	private boolean tir;
	private float delay;
	private float speed;
	Random randomNumbers = new Random();
	int rand=0;
	
	public passsytem(){
		
	tir=false;
	delay=15;
	speed=0.002f;
	
	}

public void update(List<player> balle, player aiplayer ,float xpos,float xpos2,float zpos,float zpos2,int randX,int randZ,List <player> joueur,
		List<player > joueurAI){
	
		passer(balle,aiplayer, xpos, zpos2, zpos, zpos2,randX,randZ,joueur,joueurAI);
	}
	
private void passer(List<player> b, player aiplayer, float xpos,float xpos2,float zpos,float zpos2,int randX,int randZ,List<player> joueur,
		List<player>joueurAI){
	
	float distPlayerAIX= aiplayer.getPosition().x- b.get(0).getPosition().x;
	float distPlayerAIZ= aiplayer.getPosition().z- b.get(0).getPosition().z;
	
	float dist=(float) (Math.sqrt(distPlayerAIX*distPlayerAIX)+(distPlayerAIZ*distPlayerAIZ));


	if(tir && dist<40.5f && delay<=2)
	{
	rand=randomNumbers.nextInt(randZ)+1;

	}
	
	for(int i=0;i<joueur.size();i++)
	{
	
	 float distPlayerX= joueur.get(i).getPosition().x-b.get(0).getPosition().x;
	 
	 float distPlayerZ= joueur.get(i).getPosition().z-b.get(0).getPosition().z;
	
	float dist2=(float) (Math.sqrt(distPlayerX*distPlayerX)+(distPlayerZ*distPlayerZ));

	if( tir&& aiplayer.getHasTheBall() && delay<=2)
	{ 
		tir=false;
	}
	
	else if( tir&& joueur.get(i).getHasTheBall() && delay<=2)
	{ 
		tir=false;
	}
		
	
	

	
	if(dist<40.0f &&dist2<70.0f && aiplayer.getPosition().x<xpos && aiplayer.getPosition().x>xpos2 && aiplayer.getPosition().z<zpos && aiplayer.getPosition().z>zpos2 )
	{
		aiplayer.setHasTheBall(false);
		
		
		tir=true;
	
	
	}
	 }
	
	 if(delay<0)
	  delay=10;



	if(tir && aiplayer.getHasTheBall()==false)
	{
			setSpeed(0.004f);
			delay-=0.2f;	
			Vector3f dir=new Vector3f(joueurAI.get(rand).getPosition().x - b.get(0).getPosition().x,0,joueurAI.get(rand).getPosition().z - b.get(0).getPosition().z);
			b.get(0).increasePosition(dir.x*speed,0,dir.z*speed);

	}

}

public void setTir(boolean t)
{
	tir=t;
}
public boolean getTir()
{
	return tir;
}

public void setSpeed(float s)
{
	speed=s;
}


}
