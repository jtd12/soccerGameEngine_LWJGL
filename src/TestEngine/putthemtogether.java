package TestEngine;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import entities.AnimatedEntity;
import entities.entity;
import entities.passsytem;
import entities.player;
import entities.roues;
import models.rawModel;
import models.texturedModel;
import renderEngine.loader;
import renderEngine.objloader;
import terrains.terrain;
import textures.modelTexture;

public class putthemtogether {
	
	public boolean isCarInsideStadium=false;
	public float startGame=0.0f;
	public Vector3f[] target=new Vector3f[10];
	public Vector3f[] target2=new Vector3f[10];
	public Vector3f[] target3=new Vector3f[10];
	public Vector3f[] target4=new Vector3f[10];
	public Vector3f[] target5=new Vector3f[10];
	public Vector3f[] target6=new Vector3f[10];
	public Vector3f[] target7=new Vector3f[10];
	public Vector3f[] target8=new Vector3f[10];
	public Vector3f[] target9=new Vector3f[10];
	List<rawModel> frames = new ArrayList<>();
	int currentFrame = 0;
	
	
	public void init(loader loader,List<entity> murs,List<player> supporters_element,List<player> supporters, List<player> cars,List<roues>roues_,List<roues> roues2_,List<player> p,List<AnimatedEntity> manager,List<player> balle,List<player> pAI,List<player> goal,texturedModel textureModelBalle,texturedModel textureModelPlayer,texturedModel textureModelPlayer2,texturedModel textureModelGoal,
			texturedModel textureModelGoal2, texturedModel textureModelCars,texturedModel textureModelRoues,
			texturedModel textureModelRoues2,texturedModel textureModelSupporter,texturedModel textureModelSupporter_element, texturedModel textureModel_murs 
			)
	{
		
		List<texturedModel> frames=new ArrayList<>();
		
		instanceCars(loader,cars,roues_,roues2_,textureModelCars,textureModelRoues,textureModelRoues2);
		
		instancePlayersAndBall(loader,goal,p,pAI,balle,textureModelPlayer,textureModelBalle,textureModelPlayer2,textureModelGoal, textureModelGoal2);
		
		InstanceTarget();
		
		instanceManagerPlayer(frames,loader,manager);
		
		//instanceSupporters(loader loader,List<player> supporters,List<texturedModel> frames
				
		instanceSupporters(loader, supporters, textureModelSupporter);
		
		instanceSupporters(loader, supporters_element, textureModelSupporter_element);
		
		
	
		
	}
	

	private void instanceCars(loader loader,List<player> cars,List<roues>roues_,List<roues> roues2_, texturedModel textureModelCars,texturedModel textureModelRoues
			,texturedModel textureModelRoues2)
	{
		cars.add(new player(textureModelCars,new Vector3f(1900,80,1200),0,0,0,1,1,1,1));
		
		roues_.add(new roues(textureModelRoues,new Vector3f(380,25,360),0,0,0,10));
		roues_.add(new roues(textureModelRoues,new Vector3f(380,25,360),0,0,0,10));
		
		roues2_.add(new roues(textureModelRoues2,new Vector3f(380,25,360),0,0,0,10));
		roues2_.add(new roues(textureModelRoues2,new Vector3f(380,25,360),0,0,0,10));
	}
	
	private void instanceTarget(Vector3f[] targ,int i,int posX,int posZ)
	{
		
		targ[i]=new Vector3f(posX,-6,posZ);

		
	}
	
	private void InstanceTarget()
	{
		instanceTarget(target,0,780,470);
		instanceTarget(target,1,780,560);
		instanceTarget(target,2,750,500);
		instanceTarget(target,3,680,450);
		instanceTarget(target,4,680,430);
		instanceTarget(target,5,590,580);
		instanceTarget(target,6,590,460);
		instanceTarget(target,7,590,560);
		instanceTarget(target,8,510,500);
		instanceTarget(target,9,510,560);
		
		instanceTarget(target2,0,640,470);
		instanceTarget(target2,1,590,560);
		instanceTarget(target2,2,590,500);
		instanceTarget(target2,3,530,450);
		instanceTarget(target2,4,530,430);
		instanceTarget(target2,5,470,580);
		instanceTarget(target2,6,440,460);
		instanceTarget(target2,7,440,560);
		instanceTarget(target2,8,410,500);
		instanceTarget(target2,9,410,560);
		
		instanceTarget(target3,0,540,470);
		instanceTarget(target3,1,520,560);
		instanceTarget(target3,2,520,500);
		instanceTarget(target3,3,500,450);
		instanceTarget(target3,4,470,430);
		instanceTarget(target3,5,450,580);
		instanceTarget(target3,6,450,460);
		instanceTarget(target3,7,420,560);
		instanceTarget(target3,8,400,500);
		instanceTarget(target3,9,400,560);
		
		
		instanceTarget(target4,0,780,570);
		instanceTarget(target4,1,780,600);
		instanceTarget(target4,2,750,580);
		instanceTarget(target4,3,680,610);
		instanceTarget(target4,4,680,630);
		instanceTarget(target4,5,590,650);
		instanceTarget(target4,6,590,660);
		instanceTarget(target4,7,590,560);
		instanceTarget(target4,8,510,500);
		instanceTarget(target4,9,510,560);
		
		instanceTarget(target5,0,640,570);
		instanceTarget(target5,1,590,650);
		instanceTarget(target5,2,590,600);
		instanceTarget(target5,3,530,650);
		instanceTarget(target5,4,530,630);
		instanceTarget(target5,5,470,650);
		instanceTarget(target5,6,440,650);
		instanceTarget(target5,7,440,560);
		instanceTarget(target5,8,410,500);
		instanceTarget(target5,9,410,560);
		
		
		instanceTarget(target6,0,540,570);
		instanceTarget(target6,1,520,650);
		instanceTarget(target6,2,520,600);
		instanceTarget(target6,3,500,650);
		instanceTarget(target6,4,470,630);
		instanceTarget(target6,5,450,650);
		instanceTarget(target6,6,450,660);
		instanceTarget(target6,7,420,560);
		instanceTarget(target6,8,400,500);
		instanceTarget(target6,9,400,560);
		
		
		instanceTarget(target7,0,780,410);
		instanceTarget(target7,1,780,400);
		instanceTarget(target7,2,750,390);
		instanceTarget(target7,3,680,390);
		instanceTarget(target7,4,680,420);
		instanceTarget(target7,5,590,390);
		instanceTarget(target7,6,590,380);
		instanceTarget(target7,7,590,420);
		instanceTarget(target7,8,510,430);
		instanceTarget(target7,9,510,380);
		
		instanceTarget(target8,0,640,370);
		instanceTarget(target8,1,590,390);
		instanceTarget(target8,2,590,380);
		instanceTarget(target8,3,530,410);
		instanceTarget(target8,4,530,420);
		instanceTarget(target8,5,470,410);
		instanceTarget(target8,6,440,430);
		instanceTarget(target8,7,440,440);
		instanceTarget(target8,8,410,410);
		instanceTarget(target8,9,410,400);
		
		
		instanceTarget(target9,0,540,370);
		instanceTarget(target9,1,520,390);
		instanceTarget(target9,2,520,390);
		instanceTarget(target9,3,500,400);
		instanceTarget(target9,4,470,410);
		instanceTarget(target9,5,450,420);
		instanceTarget(target9,6,450,400);
		instanceTarget(target9,7,420,390);
		instanceTarget(target9,8,400,390);
		instanceTarget(target9,9,400,400);
	}
	
	private void instancePlayersAndBall(loader loader,List<player> goal,List<player> p,List<player> pAI,List<player> balle,texturedModel  textureModelPlayer,texturedModel textureModelBalle,texturedModel textureModelPlayer2, texturedModel textureModelGoal,
			texturedModel textureModelGoal2)
	{
		
		balle.add(new player(textureModelBalle,new Vector3f(600,10,500),0,0,0,1,12,12,12));
		
		
		p.add(new player(textureModelPlayer,new Vector3f(500,10,330),0,0,0,1,5,5,5));
		p.add(new player(textureModelPlayer,new Vector3f(500,10,340),0,0,0,1,5,5,5));
		p.add(new player(textureModelPlayer,new Vector3f(500,10,350),0,0,0,1,5,5,5));
		p.add(new player(textureModelPlayer,new Vector3f(500,10,360),0,0,0,1,5,5,5));
		p.add(new player(textureModelPlayer,new Vector3f(500,10,370),0,0,0,1,5,5,5));
		p.add(new player(textureModelPlayer,new Vector3f(500,10,380),0,0,0,1,5,5,5));
		p.add(new player(textureModelPlayer,new Vector3f(500,10,390),0,0,0,1,5,5,5));
		p.add(new player(textureModelPlayer,new Vector3f(500,10,400),0,0,0,1,5,5,5));
		p.add(new player(textureModelPlayer,new Vector3f(500,10,410),0,0,0,1,5,5,5));
		p.add(new player(textureModelPlayer,new Vector3f(500,10,420),0,0,0,1,5,5,5));
		
		
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,330),0,180,0,1,5,5,5));
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,340),0,180,0,1,5,5,5));
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,350),0,180,0,1,5,5,5));
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,360),0,180,0,1,5,5,5));
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,370),0,180,0,1,5,5,5));
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,380),0,180,0,1,5,5,5));
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,390),0,180,0,1,5,5,5));
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,400),0,180,0,1,5,5,5));
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,410),0,180,0,1,5,5,5));
		pAI.add(new player(textureModelPlayer2,new Vector3f(550,10,420),0,180,0,1,5,5,5));
		
		goal.add(new player(textureModelGoal,new Vector3f(500,10,430),0,0,0,1,5,5,5));
		goal.add(new player(textureModelGoal2,new Vector3f(550,10,430),0,180,0,1,5,5,5));
	}
	

	public AnimatedEntity loadAnimatedEntity(List<texturedModel> frames,String basePath, String texturePath, loader loader, int frameCount) {
	    //List<texturedModel> frames = new ArrayList<>();

	    for (int i = 1; i <= frameCount; i++) {  // Chargement de 100 frames, ou plus selon tes besoins
	        String modelFilePath = String.format(basePath+"player_%06d", i);  // Chargement des modèles frame par frame
	        rawModel rawModelPP = objloader.loadObjModel(modelFilePath, loader);  // Chargement du modèle brut
	        texturedModel textureModelPP = new texturedModel(rawModelPP, new modelTexture(loader.loadTextureJPG(texturePath)));  // Associe une texture
	        frames.add(textureModelPP);  // Ajoute ce modèle texturé à la liste des frames
	    }

	    return new AnimatedEntity(frames,new Vector3f(1900,100,1300),0,0,0,1,5,5,5);  // Retourne une instance de l'entité animée avec toutes les frames chargées
	}
	 	
	

	
	private void instanceManagerPlayer(List<texturedModel> frames,loader loader,List<AnimatedEntity> p
			)
	{
		AnimatedEntity playerEntity =loadAnimatedEntity( frames,"/playerAnim/", "texture", loader, 60);
		p.add(playerEntity);
		//loadAnimateModels( loader,textureModelPlayer);
		//p.add(new animatedEntity(frames,new Vector3f(1900,80,1300),0,0,0,1,15,15,15));
	}
	
	private void instanceSupporters(loader loader,List<player> supporters,texturedModel frames
			) {
	
		for(int i=0;i<45;i++)
		supporters.add(new player(frames,new Vector3f(400+(i*10),10,720),0,90,0,2,3,3,3));
		
		for(int i=0;i<45;i++)
			supporters.add(new player(frames,new Vector3f(400+(i*10),20,740),0,90,0,2,3,3,3));
		
		

		for(int i=0;i<45;i++)
		supporters.add(new player(frames,new Vector3f(400+(i*10),30,750),0,90,0,2,3,3,3));
		
		for(int i=0;i<45;i++)
			supporters.add(new player(frames,new Vector3f(400+(i*10),40,760),0,90,0,2,3,3,3));
		
		
		
		
		
		for(int i=0;i<45;i++)
			supporters.add(new player(frames,new Vector3f(400+(i*10),10,280),0,-90,0,2,3,3,3));
			
			for(int i=0;i<45;i++)
				supporters.add(new player(frames,new Vector3f(400+(i*10),20,260),0,-90,0,2,3,3,3));
			
			

			for(int i=0;i<45;i++)
			supporters.add(new player(frames,new Vector3f(400+(i*10),30,250),0,-90,0,2,3,3,3));
			
			for(int i=0;i<45;i++)
				supporters.add(new player(frames,new Vector3f(400+(i*10),40,240),0,-90,0,2,3,3,3));
			
			
			
			for(int i=0;i<35;i++)
				supporters.add(new player(frames,new Vector3f(300,10,350+(i*8)),0,0,0,2,3,3,3));
				
				for(int i=0;i<35;i++)
					supporters.add(new player(frames,new Vector3f(280,20,350+(i*8)),0,0,0,2,3,3,3));
				
				

				for(int i=0;i<35;i++)
				supporters.add(new player(frames,new Vector3f(270,30,350+(i*8)),0,0,0,2,3,3,3));
				
				for(int i=0;i<35;i++)
					supporters.add(new player(frames,new Vector3f(260,40,350+(i*8)),0,0,0,2,3,3,3));
	
				
				
				for(int i=0;i<35;i++)
					supporters.add(new player(frames,new Vector3f(900,10,350+(i*8)),0,180,0,2,3,3,3));
					
					for(int i=0;i<35;i++)
						supporters.add(new player(frames,new Vector3f(920,20,350+(i*8)),0,180,0,2,3,3,3));
					
					

					for(int i=0;i<35;i++)
					supporters.add(new player(frames,new Vector3f(930,30,350+(i*8)),0,180,0,2,3,3,3));
					
					for(int i=0;i<35;i++)
						supporters.add(new player(frames,new Vector3f(940,40,350+(i*8)),0,180,0,2,3,3,3));
		
}
	
	private void updateMovementSupporters(List<player> supporters_element)
	{
		for(int i=0;i<supporters_element.size();i++)
		{
		if(supporters_element.get(i).getPosition().y<18 )
		{
			supporters_element.get(i).increasePosition(0.0f, 0.05f, 0f);
			
			if(supporters_element.get(i).getPosition().y>=15)
			{
				supporters_element.get(i).setPosition(new Vector3f(supporters_element.get(i).getPosition().x, 10, supporters_element.get(i).getPosition().z));
			}
		}
		
		if(supporters_element.get(i).getPosition().y<28 )
		{
			supporters_element.get(i).increasePosition(0.0f, 0.05f, 0f);
			
			if(supporters_element.get(i).getPosition().y>=25)
			{
				supporters_element.get(i).setPosition(new Vector3f(supporters_element.get(i).getPosition().x, 20, supporters_element.get(i).getPosition().z));
			}
		}
		
		if(supporters_element.get(i).getPosition().y<38 )
		{
			supporters_element.get(i).increasePosition(0.0f, 0.05f, 0f);
			
			if(supporters_element.get(i).getPosition().y>=35)
			{
				supporters_element.get(i).setPosition(new Vector3f(supporters_element.get(i).getPosition().x, 30, supporters_element.get(i).getPosition().z));
			}
		}
		
		if(supporters_element.get(i).getPosition().y<48 )
		{
			supporters_element.get(i).increasePosition(0.0f, 0.05f, 0f);
			
			if(supporters_element.get(i).getPosition().y>=45)
			{
				supporters_element.get(i).setPosition(new Vector3f(supporters_element.get(i).getPosition().x, 40, supporters_element.get(i).getPosition().z));
			}
		}
	
	   }
	}
	
	private void setGravityEntities(List<player> p,List<player> balle,List<player> pAI,List<player>goal)
	{
		
		 
		balle.get(0).move(-12.5f);
	
	for(int i=0;i<p.size();i++)
	  p.get(i).move(-6.0f);
	
	for(int i=0;i<pAI.size();i++)
		 pAI.get(i).move(-6.0f);
	
	for(int i=0;i<goal.size();i++)
		 goal.get(i).move(-6.0f);
	
	}
	
	private void setLimit(player joueur)
	{
		if(joueur.getPosition().x<300)
		{
			joueur.setPosition(new Vector3f(600,40,500));
		}
		if(joueur.getPosition().x>800)
		{
			joueur.setPosition(new Vector3f(600,40,500));
		}
		if(joueur.getPosition().z>800)
		{
			joueur.setPosition(new Vector3f(600,40,500));
		}
		if(joueur.getPosition().z<300)
		{
			joueur.setPosition(new Vector3f(600,40,500));
		}
	}
	
	private void separatePlayers(List<player> joueur,player balle)
	{

				
		
				  Vector3f Distance = new Vector3f(joueur.get(0).getPosition().x-balle.getPosition().x,joueur.get(0).getPosition().y-balle.getPosition().y,joueur.get(0).getPosition().z-balle.getPosition().z);
				  Vector3f Distance2 = new Vector3f(joueur.get(1).getPosition().x-balle.getPosition().x,joueur.get(1).getPosition().y-balle.getPosition().y,joueur.get(1).getPosition().z-balle.getPosition().z);
				  Vector3f Distance3 = new Vector3f(joueur.get(2).getPosition().x-balle.getPosition().x,joueur.get(2).getPosition().y-balle.getPosition().y,joueur.get(2).getPosition().z-balle.getPosition().z);
				  Vector3f Distance4 = new Vector3f(joueur.get(3).getPosition().x-balle.getPosition().x,joueur.get(3).getPosition().y-balle.getPosition().y,joueur.get(3).getPosition().z-balle.getPosition().z);
				  Vector3f Distance5 = new Vector3f(joueur.get(4).getPosition().x-balle.getPosition().x,joueur.get(4).getPosition().y-balle.getPosition().y,joueur.get(4).getPosition().z-balle.getPosition().z);
				  Vector3f Distance6 = new Vector3f(joueur.get(5).getPosition().x-balle.getPosition().x,joueur.get(5).getPosition().y-balle.getPosition().y,joueur.get(5).getPosition().z-balle.getPosition().z);
				  Vector3f Distance7= new Vector3f(joueur.get(6).getPosition().x-balle.getPosition().x,joueur.get(6).getPosition().y-balle.getPosition().y,joueur.get(6).getPosition().z-balle.getPosition().z);
				  Vector3f Distance8 = new Vector3f(joueur.get(7).getPosition().x-balle.getPosition().x,joueur.get(7).getPosition().y-balle.getPosition().y,joueur.get(7).getPosition().z-balle.getPosition().z);
				  Vector3f Distance9 = new Vector3f(joueur.get(8).getPosition().x-balle.getPosition().x,joueur.get(8).getPosition().y-balle.getPosition().y,joueur.get(8).getPosition().z-balle.getPosition().z);
				  Vector3f Distance10 = new Vector3f(joueur.get(9).getPosition().x-balle.getPosition().x,joueur.get(9).getPosition().y-balle.getPosition().y,joueur.get(9).getPosition().z-balle.getPosition().z);
				

		float hypotenuse = (float) Math.sqrt((Distance.x * Distance.x) + (Distance.z * Distance.z));
		float hypotenuse2 = (float) Math.sqrt((Distance2.x * Distance2.x) + (Distance2.z * Distance2.z));
		float hypotenuse3 = (float) Math.sqrt((Distance3.x * Distance3.x) + (Distance3.z * Distance3.z));
		float hypotenuse4 = (float) Math.sqrt((Distance4.x * Distance4.x) + (Distance4.z * Distance4.z));
		float hypotenuse5 = (float) Math.sqrt((Distance5.x * Distance5.x) + (Distance5.z * Distance5.z));
		float hypotenuse6 = (float) Math.sqrt((Distance6.x * Distance6.x) + (Distance6.z * Distance6.z));
		float hypotenuse7 = (float) Math.sqrt((Distance7.x * Distance7.x) + (Distance7.z * Distance7.z));
		float hypotenuse8 = (float) Math.sqrt((Distance8.x * Distance8.x) + (Distance8.z * Distance8.z));
		float hypotenuse9 = (float) Math.sqrt((Distance9.x * Distance9.x) + (Distance9.z * Distance9.z));
		float hypotenuse10 = (float) Math.sqrt((Distance10.x * Distance10.x) + (Distance10.z * Distance10.z));
	
		for(int i=0;i<joueur.size();i++)
		{

													if(joueur.get(i).getHasTheBall()==true && joueur.get(0).getHasTheBall()==false && hypotenuse<30)
													{
														joueur.get(0).increasePosition(-0.5f,0,0.5f);
													}
															if(joueur.get(i).getHasTheBall()==true && joueur.get(1).getHasTheBall()==false&& hypotenuse2<30)
													{
														joueur.get(1).increasePosition(-0.5f,0,0.5f);
													}
															if(joueur.get(i).getHasTheBall()==true && joueur.get(2).getHasTheBall()==false&& hypotenuse3<30)
													{
														joueur.get(2).increasePosition(-0.5f,0,0.5f);
													}
															if(joueur.get(i).getHasTheBall()==true && joueur.get(3).getHasTheBall()==false&& hypotenuse4<30)
													{
														joueur.get(3).increasePosition(-0.5f,0,0.5f);
													}
															if(joueur.get(i).getHasTheBall()==true && joueur.get(4).getHasTheBall()==false&& hypotenuse5<30)
													{
														joueur.get(4).increasePosition(-0.5f,0,0.5f);
													}
															if(joueur.get(i).getHasTheBall()==true && joueur.get(5).getHasTheBall()==false&& hypotenuse6<30)
													{
														joueur.get(5).increasePosition(-0.5f,0,0.5f);
													}
															if(joueur.get(i).getHasTheBall()==true && joueur.get(6).getHasTheBall()==false&& hypotenuse7<30)
													{
														joueur.get(6).increasePosition(-0.5f,0,0.5f);
													}
															if(joueur.get(i).getHasTheBall()==true && joueur.get(7).getHasTheBall()==false&& hypotenuse8<30)
													{
														joueur.get(7).increasePosition(-0.5f,0,0.5f);
													}
															if(joueur.get(i).getHasTheBall()==true && joueur.get(8).getHasTheBall()==false&& hypotenuse9<30)
													{
														joueur.get(8).increasePosition(-0.5f,0,0.5f);
													}
															if(joueur.get(i).getHasTheBall()==true && joueur.get(9).getHasTheBall()==false && hypotenuse10<30)
													{
														joueur.get(9).increasePosition(-0.5f,0,0.5f);
													}
												}
												
											
		

	}
	
	private void setGravityManager(List<AnimatedEntity>manager,List<terrain> terrains)
	{
		 manager.get(0).move(terrains.get(0));

	}
	
	private void setGravityEntitiesCar(List<AnimatedEntity> manager,List<player>cars,List<terrain> terrains,List<roues> roues_,
			List<roues> roues2_)
	{

		cars.get(0).move(terrains.get(0),roues_,roues2_);
		
		
	}
	
	private void passerBall(player p, List<player> balle,Vector3f[] target_)
	{
	if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
	{
		System.out.print(balle.get(0).getVelocity());
		if(p.getHasTheBall())
		{
			p.setPass(true);
		}
		
	  }
	if(p.getPass())
	{
		balle.get(0).setVelocityIncrease(1.5f);
		balle.get(0).increasePosition((float) (balle.get(0).getVelocity()*Math.cos(p.getRotY())), 0, (float) (balle.get(0).getVelocity()*-Math.sin(p.getRotY())));
	}
	if(p.getPass() && p.getHasTheBall()==false && balle.get(0).getVelocity()>15.0f)
	{
		balle.get(0).setVelocity(0.01f);
		p.setPass(false);
	
	}
	}
	
	private void followBall(List<player> joueur,player balle)
	{
	 Vector3f Distance = new Vector3f(joueur.get(0).getPosition().x-balle.getPosition().x,joueur.get(0).getPosition().y-balle.getPosition().y,joueur.get(0).getPosition().z-balle.getPosition().z);
	 Vector3f Distance2 = new Vector3f(joueur.get(1).getPosition().x-balle.getPosition().x,joueur.get(1).getPosition().y-balle.getPosition().y,joueur.get(1).getPosition().z-balle.getPosition().z);
	 Vector3f Distance3 = new Vector3f(joueur.get(2).getPosition().x-balle.getPosition().x,joueur.get(2).getPosition().y-balle.getPosition().y,joueur.get(2).getPosition().z-balle.getPosition().z);
	 Vector3f Distance4 = new Vector3f(joueur.get(3).getPosition().x-balle.getPosition().x,joueur.get(3).getPosition().y-balle.getPosition().y,joueur.get(3).getPosition().z-balle.getPosition().z);
	 Vector3f Distance5 = new Vector3f(joueur.get(4).getPosition().x-balle.getPosition().x,joueur.get(4).getPosition().y-balle.getPosition().y,joueur.get(4).getPosition().z-balle.getPosition().z);
	 Vector3f Distance6 = new Vector3f(joueur.get(5).getPosition().x-balle.getPosition().x,joueur.get(5).getPosition().y-balle.getPosition().y,joueur.get(5).getPosition().z-balle.getPosition().z);
	 Vector3f Distance7 = new Vector3f(joueur.get(6).getPosition().x-balle.getPosition().x,joueur.get(6).getPosition().y-balle.getPosition().y,joueur.get(6).getPosition().z-balle.getPosition().z);
	 Vector3f Distance8 = new Vector3f(joueur.get(7).getPosition().x-balle.getPosition().x,joueur.get(7).getPosition().y-balle.getPosition().y,joueur.get(7).getPosition().z-balle.getPosition().z);
	 Vector3f Distance9 = new Vector3f(joueur.get(8).getPosition().x-balle.getPosition().x,joueur.get(8).getPosition().y-balle.getPosition().y,joueur.get(8).getPosition().z-balle.getPosition().z);
	 Vector3f Distance10 = new Vector3f(joueur.get(9).getPosition().x-balle.getPosition().x,joueur.get(9).getPosition().y-balle.getPosition().y,joueur.get(9).getPosition().z-balle.getPosition().z);
	 
		float dist = (float) Math.sqrt((Distance.x * Distance.x) + (Distance.z * Distance.z));
		float dist2 = (float) Math.sqrt((Distance2.x * Distance2.x) + (Distance2.z * Distance2.z));
		float dist3 = (float) Math.sqrt((Distance3.x * Distance3.x) + (Distance3.z * Distance3.z));
		float dist4 = (float) Math.sqrt((Distance4.x * Distance4.x) + (Distance4.z * Distance4.z));
		float dist5 = (float) Math.sqrt((Distance5.x * Distance5.x) + (Distance5.z * Distance5.z));
		float dist6 = (float) Math.sqrt((Distance6.x * Distance6.x) + (Distance6.z * Distance6.z));
		float dist7 = (float) Math.sqrt((Distance7.x * Distance7.x) + (Distance7.z * Distance7.z));
		float dist8 = (float) Math.sqrt((Distance8.x * Distance8.x) + (Distance8.z * Distance8.z));
		float dist9 = (float) Math.sqrt((Distance9.x * Distance9.x) + (Distance9.z * Distance9.z));
		float dist10 = (float) Math.sqrt((Distance10.x * Distance10.x) + (Distance10.z * Distance10.z));
	
		if(dist<dist2 && dist<dist3 && dist<dist4 && dist<dist5 && dist<dist6 &&
				dist<dist7 && dist<dist8 && dist<dist9 && dist<dist10)
		{
				joueur.get(0).setfollow(true);
			
		}
		else
		{
			
		}
		
		if(dist2<dist && dist2<dist3 && dist2<dist4 && dist2<dist5 && dist2<dist6 &&
				dist2<dist7 && dist2<dist8 && dist2<dist9 && dist2<dist10)
		{
			joueur.get(1).setfollow(true);
		}
		else
		{
		
		}
		
		if(dist3<dist2 && dist3<dist && dist3<dist4 && dist3<dist5 && dist3<dist6 &&
				dist3<dist7 && dist3<dist8 && dist3<dist9 && dist3<dist10)
		{
			joueur.get(2).setfollow(true);
		}
		else
		{
		
		}
		if(dist4<dist2 && dist4<dist3 && dist4<dist && dist4<dist5 && dist4<dist6 &&
				dist4<dist7 && dist4<dist8 && dist4<dist9 && dist4<dist10)
		{
			joueur.get(3).setfollow(true);
		}
		else
		{
			
		}
		
		if(dist5<dist2 && dist5<dist3 && dist5<dist4 && dist6<dist && dist5<dist6 &&
				dist5<dist7 && dist5<dist8 && dist5<dist9 && dist5<dist10)
		{
			joueur.get(4).setfollow(true);
		}
		else
		{
		
		}
		
		
		if(dist6<dist2 && dist6<dist3 && dist6<dist4 && dist6<dist5 && dist6<dist6 &&
				dist6<dist7 && dist6<dist && dist6<dist9 && dist6<dist10)
		{
			joueur.get(5).setfollow(true);
		}
		else
		{
		
		}
		
		if(dist7<dist2 && dist7<dist3 && dist7<dist4 && dist7<dist5 && dist7<dist6 &&
				dist7<dist && dist7<dist8 && dist7<dist9 && dist7<dist10)
		{
			joueur.get(6).setfollow(true);
		}
		else
		{
			
		}
		
		if(dist8<dist2 && dist8<dist3 && dist8<dist4 && dist8<dist5 && dist8<dist6 &&
				dist8<dist7 && dist8<dist && dist8<dist9 && dist8<dist10)
		{
			joueur.get(7).setfollow(true);
		}
		else
		{
			
		}
		
		if(dist9<dist2 && dist9<dist3 && dist9<dist4 && dist9<dist5 && dist9<dist6 &&
				dist9<dist7 && dist9<dist8 && dist9<dist && dist9<dist10)
		{
			joueur.get(8).setfollow(true);
		}
		else
		{
			
		}
		
		if(dist10<dist2 && dist10<dist3 && dist10<dist4 && dist10<dist5 && dist10<dist6 &&
				dist10<dist7 && dist10<dist8 && dist10<dist9 && dist10<dist)
		{
			joueur.get(9).setfollow(true);
		}
		else
		{
			
		}
		
	
		
	}
	
	private void recupererBall(List<player> joueur,player balle)
	{
		Vector3f Distance = new Vector3f(joueur.get(0).getPosition().x-balle.getPosition().x,joueur.get(0).getPosition().y-balle.getPosition().y,joueur.get(0).getPosition().z-balle.getPosition().z);
		 Vector3f Distance2 = new Vector3f(joueur.get(1).getPosition().x-balle.getPosition().x,joueur.get(1).getPosition().y-balle.getPosition().y,joueur.get(1).getPosition().z-balle.getPosition().z);
		 Vector3f Distance3 = new Vector3f(joueur.get(2).getPosition().x-balle.getPosition().x,joueur.get(2).getPosition().y-balle.getPosition().y,joueur.get(2).getPosition().z-balle.getPosition().z);
		 Vector3f Distance4 = new Vector3f(joueur.get(3).getPosition().x-balle.getPosition().x,joueur.get(3).getPosition().y-balle.getPosition().y,joueur.get(3).getPosition().z-balle.getPosition().z);
		 Vector3f Distance5 = new Vector3f(joueur.get(4).getPosition().x-balle.getPosition().x,joueur.get(4).getPosition().y-balle.getPosition().y,joueur.get(4).getPosition().z-balle.getPosition().z);
		 Vector3f Distance6 = new Vector3f(joueur.get(5).getPosition().x-balle.getPosition().x,joueur.get(5).getPosition().y-balle.getPosition().y,joueur.get(5).getPosition().z-balle.getPosition().z);
		 Vector3f Distance7 = new Vector3f(joueur.get(6).getPosition().x-balle.getPosition().x,joueur.get(6).getPosition().y-balle.getPosition().y,joueur.get(6).getPosition().z-balle.getPosition().z);
		 Vector3f Distance8 = new Vector3f(joueur.get(7).getPosition().x-balle.getPosition().x,joueur.get(7).getPosition().y-balle.getPosition().y,joueur.get(7).getPosition().z-balle.getPosition().z);
		 Vector3f Distance9 = new Vector3f(joueur.get(8).getPosition().x-balle.getPosition().x,joueur.get(8).getPosition().y-balle.getPosition().y,joueur.get(8).getPosition().z-balle.getPosition().z);
		 Vector3f Distance10 = new Vector3f(joueur.get(9).getPosition().x-balle.getPosition().x,joueur.get(9).getPosition().y-balle.getPosition().y,joueur.get(9).getPosition().z-balle.getPosition().z);
		 
			float dist = (float) Math.sqrt((Distance.x * Distance.x) + (Distance.z * Distance.z));
			float dist2 = (float) Math.sqrt((Distance2.x * Distance2.x) + (Distance2.z * Distance2.z));
			float dist3 = (float) Math.sqrt((Distance3.x * Distance3.x) + (Distance3.z * Distance3.z));
			float dist4 = (float) Math.sqrt((Distance4.x * Distance4.x) + (Distance4.z * Distance4.z));
			float dist5 = (float) Math.sqrt((Distance5.x * Distance5.x) + (Distance5.z * Distance5.z));
			float dist6 = (float) Math.sqrt((Distance6.x * Distance6.x) + (Distance6.z * Distance6.z));
			float dist7 = (float) Math.sqrt((Distance7.x * Distance7.x) + (Distance7.z * Distance7.z));
			float dist8 = (float) Math.sqrt((Distance8.x * Distance8.x) + (Distance8.z * Distance8.z));
			float dist9 = (float) Math.sqrt((Distance9.x * Distance9.x) + (Distance9.z * Distance9.z));
			float dist10 = (float) Math.sqrt((Distance10.x * Distance10.x) + (Distance10.z * Distance10.z));
		
			
		if(joueur.get(0).getHasTheBall()==false && joueur.get(1).getHasTheBall()==false 
				&& joueur.get(2).getHasTheBall()==false 
				&& joueur.get(3).getHasTheBall()==false 
				&& joueur.get(4).getHasTheBall()==false 
				&& joueur.get(5).getHasTheBall()==false 
				&& joueur.get(6).getHasTheBall()==false 
				&& joueur.get(7).getHasTheBall()==false 
				&& joueur.get(8).getHasTheBall()==false 
				&& joueur.get(9).getHasTheBall()==false 
				)
		{
			if(dist<150)
			{
			joueur.get(0).setfollow(true);
			}
			else
			{
				joueur.get(0).setfollow(false);
			}
			if(dist2<150)
			{
			joueur.get(1).setfollow(true);
			}
			else
			{
				joueur.get(1).setfollow(false);
			}
			if(dist3<150)
			{
			joueur.get(2).setfollow(true);
			}
			else
			{
				joueur.get(2).setfollow(false);
			}
			if(dist4<150)
			{
			joueur.get(3).setfollow(true);
			}
			else
			{
				joueur.get(3).setfollow(false);
			}
			if(dist5<150)
			{
			joueur.get(4).setfollow(true);
			}
			else
			{
				joueur.get(4).setfollow(false);
			}
			
			if(dist6<150)
			{
			joueur.get(5).setfollow(true);
			}
			else
			{
				joueur.get(5).setfollow(false);
			}
			if(dist7<150)
			{
			joueur.get(6).setfollow(true);
			}
			else
			{
				joueur.get(6).setfollow(false);
			}
			if(dist8<150)
			{
			joueur.get(7).setfollow(true);
			}
			else
			{
				joueur.get(7).setfollow(false);
			}
			if(dist9<150)
			{
			joueur.get(8).setfollow(true);
			}
			else
			{
				joueur.get(8).setfollow(false);
			}
			if(dist10<150)
			{
			joueur.get(9).setfollow(true);
			}
			else
			{	
				joueur.get(9).setfollow(false);
				
			}
			
		}
		
	}
	private void followBall(player joueur)
	{
		if(joueur.getfollow())
		{
			joueur.inputControl();
			joueur.setfollow(false);
		}
		
	}
	
	private void followBall(player joueur,player balle)
	{
		if(joueur.getfollow())
		{
		joueur.AIMovement(new Vector3f(balle.getPosition()));
		joueur.setfollow(false);
		}
		
	}
	
	private void attaquerAI(List<player> pAI,List<player> ball,float posBalleMinX, float posBalleMaxX,float posBalleMinZ,float posBalleMaxZ,Vector3f[] target)
	{
		for(int i=0;i<pAI.size();i++)
		{
		if(pAI.get(i).getHasTheBall() && ball.get(0).getPosition().x>posBalleMinX && 
				ball.get(0).getPosition().x<posBalleMaxX &&  ball.get(0).getPosition().z>posBalleMinZ && 
				ball.get(0).getPosition().z<posBalleMaxZ)
		
		{
			pAI.get(i).AIMovement(new Vector3f(450,pAI.get(i).getPosition().y,500));
			
			for(int j=0;j<pAI.size();j++)
			{
			if(pAI.get(j).getHasTheBall()==false)
			{
			pAI.get(j).AIMovement(target[j]);
			}
		   }
		}
	  }
	}
	
	private void stopMovementPlayer(player p)
	{
		if(p.getHasTheBall()==false)
		{
			//p.setSpeedPlayer(0,0);
		}
	}
	
	private void attaquer(List<player> p,List<player> pAI,List<player> balle,float posBalleMinX, float posBalleMaxX,float posBalleMinZ,float posBalleMaxZ,Vector3f[] target_)
	{
	   for(int i=0;i<p.size();i++)
		if(p.get(i).getUP()==1 || p.get(i).getDOWN()==1 || p.get(i).getRIGHT()==1 || p.get(i).getLEFT()==1)
		{
		if(p.get(i).getHasTheBall() && balle.get(0).getPosition().x>posBalleMinX && 
				balle.get(0).getPosition().x<posBalleMaxX &&  balle.get(0).getPosition().z>posBalleMinZ && 
				balle.get(0).getPosition().z<posBalleMaxZ)
		{
		  for(int j=0;j<p.size();j++)
			if(p.get(j).getHasTheBall()==false)
			{
				p.get(j).AIMovement(target_[j]);
				defendreAI( p,  pAI, balle,posBalleMinX, posBalleMaxX, posBalleMinZ, posBalleMaxZ, target_);
				//p.get(j).setSpeedPlayer(0.02f,0.02f);
			}
		
		}
		
		//600  1000 450 600
	  }
	 
		
	}
	
	private void defendreAI(List<player> p, List<player> pAI,List<player> balle,float posBalleMinX, float posBalleMaxX,float posBalleMinZ,float posBalleMaxZ,Vector3f[] target_)
	{
	   for(int i=0;i<p.size();i++)
		if(p.get(i).getHasTheBall() && balle.get(0).getPosition().x>posBalleMinX && 
				balle.get(0).getPosition().x<posBalleMaxX &&  balle.get(0).getPosition().z>posBalleMinZ && 
				balle.get(0).getPosition().z<posBalleMaxZ)
		{
			for(int j=0;j<pAI.size();j++)
				pAI.get(j).AIMovement(new Vector3f(target_[j].x-15,target_[j].y,target_[j].z-15));
			
		}
		
	}
	
	public void updateCar(List<AnimatedEntity>manager,List<player> cars,List<terrain> terrains,List<roues> roues_,
			List<roues> roues2_)
	{
		setGravityEntitiesCar(manager,cars, terrains,roues_,roues2_);
		parentRouesCars( roues_,
				roues2_, cars, terrains);
		
		if(manager.get(0).getEnter())
		{
		cars.get(0).inputCar(roues_,roues2_);
		manager.get(0).setParentManager(manager.get(0).getPosition(),cars.get(0).getPosition());
		}
	}
	
	
	public void enter_exitManager(List<AnimatedEntity>manager,List<player>car)
	{
		manager.get(0).enterVehicule(manager.get(0),car.get(0));
		manager.get(0).exitVehicule(manager.get(0),car.get(0));
	}
	
	public void updateManager(List<AnimatedEntity>manager,List<player>car,List<terrain> terrains)
	{
		

		
		if(manager.get(0).getEnter()==false)
		{
		setGravityManager(manager,terrains);
		manager.get(0).inputControlManager();
		}
		
	}
	public void update(List<player> p,List<player> balle,List<player> pAI,List<player> goal,
			List<player> supporters_element,passsytem pass)
	{
		startGame+=0.05f;
		updateMovementSupporters(supporters_element);
		setGravityEntities(p,balle,pAI,goal);
		initPositions(p,balle,pAI,goal,pass);
		
		attaquer(p,pAI,balle,620,1000,450,600,target);
		attaquer(p,pAI,balle,490,620,450,600,target2);
		attaquer(p,pAI,balle,350,490,450,600,target3);
		attaquer(p,pAI,balle,620,1000,600,750,target4);
		attaquer(p,pAI,balle,490,620,600,750,target5);
		attaquer(p,pAI,balle,350,490,600,750,target6);
		attaquer(p,pAI,balle,620,1000,300,400,target7);
		attaquer(p,pAI,balle,490,620,300,400,target8);
		attaquer(p,pAI,balle,350,490,300,400,target9);
		
		attaquerAI(pAI,balle, 620,1000,450,600,target);
		attaquerAI(pAI,balle, 490,620,450,600,target2);
		attaquerAI(pAI,balle, 350,490,450,600,target3);
		attaquerAI(pAI,balle, 620,1000,600,600,target4);
		attaquerAI(pAI,balle, 490,620,600,750,target5);
		attaquerAI(pAI,balle, 350,490,600,750,target6);
		attaquerAI(pAI,balle, 620,1000,300,750,target7);
		attaquerAI(pAI,balle, 490,620,300,400,target8);
		attaquerAI(pAI,balle, 350,490,300,400,target9);
	
		
		separatePlayers(p, balle.get(0));
		separatePlayers(pAI, balle.get(0));
		
		
		
		
	
	}
	
	private void parentRouesCars(List<roues> roues_,
			List<roues> roues2_,List<player> cars,List<terrain> terrains)
	{
		roues_.get(0).setParent(cars.get(0),terrains.get(0),33,14);
		roues_.get(1).setParent(cars.get(0),terrains.get(0),-29.0f,-1.5f);
		roues2_.get(0).setParent(cars.get(0),terrains.get(0),33,14);
		roues2_.get(1).setParent(cars.get(0),terrains.get(0),-29.0f,-1.5f);
	}
	
	private void initPositions(List<player> p,List<player> balle,List<player> pAI,List<player> goal,
			passsytem pass)
	{
		if(startGame>25)
		{
	   for(int i=0;i<p.size();i++)
			p.get(i).setRotation();	
	   

	   for(int i=0;i<p.size();i++)
	   	  p.get(i).inputControl(p.get(i), balle.get(0));
	   
	   for(int i=0;i<p.size();i++)
	   {

		   p.get(i).controlBall(p.get(i), balle.get(0));
	   }
	   
	   for(int i=0;i<pAI.size();i++)
	   {
		   if(pass.getTir()==false)
		      pAI.get(i).controlBall(pAI.get(i), balle.get(0));
	   }
	   
	   
	   passerBall(p.get(0),balle,target);
	   passerBall(p.get(1),balle,target);
	   passerBall(p.get(2),balle,target);
	   passerBall(p.get(3),balle,target);
	   passerBall(p.get(4),balle,target);
	   passerBall(p.get(5),balle,target);
	   passerBall(p.get(6),balle,target);
	   passerBall(p.get(7),balle,target);
	   passerBall(p.get(8),balle,target);
	   passerBall(p.get(9),balle,target);
	   
	   
	    setLimit(p.get(0));
		setLimit(p.get(1));
		setLimit(p.get(2));
		setLimit(p.get(3));
		setLimit(p.get(4));
		setLimit(p.get(5));
		setLimit(p.get(6));
		setLimit(p.get(7));
		setLimit(p.get(8));
		setLimit(p.get(9));
		
		setLimit(pAI.get(0));
		setLimit(pAI.get(1));
		setLimit(pAI.get(2));
		setLimit(pAI.get(3));
		setLimit(pAI.get(4));
		setLimit(pAI.get(5));
		setLimit(pAI.get(6));
		setLimit(pAI.get(7));
		setLimit(pAI.get(8));
		setLimit(pAI.get(9));
		
		setLimit(balle.get(0));
		
		
		stopMovementPlayer(p.get(0));
		stopMovementPlayer(p.get(1));
		stopMovementPlayer(p.get(2));
		stopMovementPlayer(p.get(3));
		stopMovementPlayer(p.get(4));
		stopMovementPlayer(p.get(5));
		stopMovementPlayer(p.get(6));
		stopMovementPlayer(p.get(7));
		stopMovementPlayer(p.get(8));
		stopMovementPlayer(p.get(9));
		
		followBall(p,balle.get(0));
		followBall(pAI,balle.get(0));

		followBall(p.get(0));
		followBall(p.get(1));
		followBall(p.get(2));
		followBall(p.get(3));
		followBall(p.get(4));
		followBall(p.get(5));
		followBall(p.get(6));
		followBall(p.get(7));
		followBall(p.get(8));
		followBall(p.get(9));
		
		followBall(pAI.get(0),balle.get(0));
		followBall(pAI.get(1),balle.get(0));
		followBall(pAI.get(2),balle.get(0));
		followBall(pAI.get(3),balle.get(0));
		followBall(pAI.get(4),balle.get(0));
		followBall(pAI.get(5),balle.get(0));
		followBall(pAI.get(6),balle.get(0));
		followBall(pAI.get(7),balle.get(0));
		followBall(pAI.get(8),balle.get(0));
		followBall(pAI.get(9),balle.get(0));

		
		recupererBall(p,balle.get(0));

		
		pass.update(balle,pAI.get(0),1000,620,600,450,4,9,p,pAI);
		pass.update(balle,pAI.get(1),620,600,600,450,6,9,p,pAI);
		pass.update(balle,pAI.get(2),590,490,600,450,3,9,p,pAI);
		pass.update(balle,pAI.get(3),1000,350,700,450,5,9,p,pAI);
		pass.update(balle,pAI.get(4),640,620,750,600,7,9,p,pAI);
		pass.update(balle,pAI.get(5),520,490,750,600,1,3,p,pAI);
		pass.update(balle,pAI.get(6),1000,350,750,600,1,3,p,pAI);
		pass.update(balle,pAI.get(7),640,620,400,300,1,3,p,pAI);
		pass.update(balle,pAI.get(8),640,620,400,300,1,3,p,pAI);
		pass.update(balle,pAI.get(9),490,350,400,300,1,3,p,pAI);
		
		
	
		
		}
		
		else
		{

		   p.get(0).AIMovement(new Vector3f(600,-6,500));
		   p.get(1).AIMovement(new Vector3f(600,-6,560));
		   p.get(2).AIMovement(new Vector3f(580,-6,500));
		   p.get(3).AIMovement(new Vector3f(480,-6,450));
		   p.get(4).AIMovement(new Vector3f(550,-6,430));
		   p.get(5).AIMovement(new Vector3f(550,-6,580));
		   p.get(6).AIMovement(new Vector3f(450,-6,380));
		   p.get(7).AIMovement(new Vector3f(450,-6,550));
		   p.get(8).AIMovement(new Vector3f(410,-6,600));
		   p.get(9).AIMovement(new Vector3f(410,-6,470));
		   
		   
		   pAI.get(0).AIMovement(new Vector3f(810,-6,470));
		   pAI.get(1).AIMovement(new Vector3f(810,-6,600));
		   pAI.get(2).AIMovement(new Vector3f(790,-6,550));
		   pAI.get(3).AIMovement(new Vector3f(750,-6,380));
		   pAI.get(4).AIMovement(new Vector3f(750,-6,580));
		   pAI.get(5).AIMovement(new Vector3f(750,-6,430));
		   pAI.get(6).AIMovement(new Vector3f(720,-6,450));
		   pAI.get(7).AIMovement(new Vector3f(720,-6,500));
		   pAI.get(8).AIMovement(new Vector3f(680,-6,560));
		   pAI.get(9).AIMovement(new Vector3f(680,-6,500));
		   
		   goal.get(0).AIMovement(new Vector3f(400,-6,500));
		   goal.get(1).AIMovement(new Vector3f(790,-6,500));
		}
	}
	
	public void changeScene(List<player> cars, List<entity> entities)
	{
		float d = (float) Math.sqrt(((cars.get(0).getPosition().x - entities.get(0).getPosition().x) * (cars.get(0).getPosition().x - entities.get(0).getPosition().x)) + ((cars.get(0).getPosition().y - entities.get(0).getPosition().y) * (cars.get(0).getPosition().y - entities.get(0).getPosition().y)) + ((cars.get(0).getPosition().z - entities.get(0).getPosition().z)  * (cars.get(0).getPosition().z - entities.get(0).getPosition().z)));
		
		if(d<1500 && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL))
		{
			isCarInsideStadium=true;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RCONTROL) && d<1500 && isCarInsideStadium)
		{
			isCarInsideStadium=false;
		}
	}
	
	public boolean getCarInsideStadium()
	{
		return isCarInsideStadium;
	}
	public boolean getPlayerInsideCar(List<AnimatedEntity> manager)
	{
		return manager.get(0).getEnter();
	}
}
