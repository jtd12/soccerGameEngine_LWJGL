package TestEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import entities.AnimatedEntity;
import entities.camera;
import entities.collision;
import entities.entity;
import entities.light;
import entities.passsytem;
import entities.player;
import entities.roues;
import models.rawModel;
import models.texturedModel;
import postprocessing.Fbo;
import postprocessing.PostProcessing;
import renderEngine.DisplayManager;
import renderEngine.loader;
import renderEngine.masterRenderer;
import renderEngine.objloader;
import shaders.staticShader;
import terrains.terrain;
import textures.modelTexture;
import textures.terrainTexture;
import textures.terrainTexturePack;
import water.WaterShader;
import water.WaterTile;
import water.waterFrameBufferObject;
import water.waterRenderer;




public class gameLoop {


	
	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		Display.setResizable(true);
		loader loader = new loader();

		rawModel model=objloader.loadObjModel("stade_final", loader);
		rawModel model2=objloader.loadObjModel("componentUnity/tree_02", loader);
		rawModel model3=objloader.loadObjModel("cities/batiments", loader);
		rawModel model4=objloader.loadObjModel("cities/batiments2", loader);
		rawModel model5=objloader.loadObjModel("cities/batiments3", loader);
		rawModel model6=objloader.loadObjModel("cities/sole", loader);
		rawModel model7=objloader.loadObjModel("cities/mur", loader);
		texturedModel texture=new texturedModel(model,new modelTexture(loader.loadTextureJPG("nmodel_10_27_stadium_diff")));
		texturedModel texture2=new texturedModel(model2,new modelTexture(loader.loadTextureTGA("textures_objectUnity/LowPoly/Sycamore_MiddleEastern_A")));
		texturedModel texture3=new texturedModel(model3,new modelTexture(loader.loadTextureJPG("cities/TexturesCom_BuildingsHighRise0635_2_seamless_S")));
		texturedModel texture4=new texturedModel(model4,new modelTexture(loader.loadTextureJPG("cities/TexturesCom_BuildingsHighRise0495_1_seamless_S")));
		texturedModel texture5=new texturedModel(model5,new modelTexture(loader.loadTextureJPG("cities/TexturesCom_HighRiseGlass0042_1_seamless_S")));
		texturedModel texture6=new texturedModel(model6,new modelTexture(loader.loadTextureJPG("cities/grass2")));
		texturedModel texture7=new texturedModel(model7,new modelTexture(loader.loadTextureJPG("cities/path2")));
		texture.getModel_texture().setHasTransparency(true);
		texture2.getModel_texture().setHasTransparency(true);
	
		
		texture.getModel_texture().setFakeLight(true);
		texture2.getModel_texture().setFakeLight(true);
	
		
		terrainTexture backGroundTexture=new terrainTexture(loader.loadTextureJPG("grass"));
		
		terrainTexture rTexture=new terrainTexture(loader.loadTextureJPG("dirt"));
		terrainTexture gTexture=new terrainTexture(loader.loadTextureJPG("grass2"));
		terrainTexture bTexture=new terrainTexture(loader.loadTextureJPG("path"));
		
		terrainTexturePack texturePack=new terrainTexturePack(backGroundTexture,rTexture,gTexture,bTexture);
		terrainTexture blendMap=new terrainTexture(loader.loadTexture("blendMap"));
		

		Fbo fbo2=new Fbo(Display.getWidth(),Display.getHeight(),Fbo.DEPTH_RENDER_BUFFER);
		PostProcessing.init(loader);

		
		light light_=new light(new Vector3f(500,2,20),new Vector3f(3.1f,1.5f,1));
		List<entity> entities=new ArrayList<entity>();
		collision collid=new collision();
		putthemtogether together=new putthemtogether();
		
		List<terrain> terrains=new ArrayList<terrain>();
		
		List<AnimatedEntity> p=new ArrayList<AnimatedEntity>();
		List<AnimatedEntity> pAI=new ArrayList<AnimatedEntity>();
		List<AnimatedEntity> manager=new ArrayList<AnimatedEntity>();
		List<AnimatedEntity> goal=new ArrayList<AnimatedEntity>();
		List<player> balle=new ArrayList<player>();
		List<player> cars=new ArrayList<player>();
		List<roues> roues_=new ArrayList<roues>();
		List<roues> roues2_=new ArrayList<roues>();
		List<player> supporters=new ArrayList<player>();
		List<player> supporters_element=new ArrayList<player>();
		List<entity> murs=new ArrayList<entity>();
		
		 
		passsytem pass=new passsytem();
		
		terrains.add(new terrain(0,0,loader,texturePack,blendMap,"heightmap2"));
		
		float x=600;
		float z=500;
		float y=terrains.get(0).getHeightTerrain(x,z)+10;
	    entities.add(new entity(texture,new Vector3f(x,y,z),0,0,0,0.9f,5,5,5));
	    
	    float x3=600;
		float z3=500;
		float y3=terrains.get(0).getHeightTerrain(x3,z3);
		
		entities.add(new entity(texture3,new Vector3f(x3,y3,z3),0,0,0,0.9f,2,2,2));
		entities.add(new entity(texture4,new Vector3f(x3,y3,z3),0,0,0,0.9f,2,2,2));
		entities.add(new entity(texture5,new Vector3f(x3,y3,z3),0,0,0,0.9f,2,2,2));
		entities.add(new entity(texture6,new Vector3f(x3,y3,z3),0,0,0,0.9f,2,2,2));
		
		murs.add(new entity(texture7,new Vector3f(1900,10,1800),0,0,0,1,1200,55,25));
		murs.add(new entity(texture7,new Vector3f(1900,10,1200),0,0,0,1,1600,55,25));
		murs.add(new entity(texture7,new Vector3f(3500,10,2700),0,0,0,1,205,155,380));
		murs.add(new entity(texture7,new Vector3f(3500,10,4300),0,0,0,1,205,155,610));
		murs.add(new entity(texture7,new Vector3f(3500,10,4700),0,0,0,1,205,155,510));
		murs.add(new entity(texture7,new Vector3f(2900,10,4300),0,0,0,1,205,155,610));
		murs.add(new entity(texture7,new Vector3f(2900,10,4700),0,0,0,1,205,155,610));
		murs.add(new entity(texture7,new Vector3f(2900,10,3600),0,0,0,1,500,155,100));
		murs.add(new entity(texture7,new Vector3f(-100,10,2700),0,0,0,1,150,155,380));
		murs.add(new entity(texture7,new Vector3f(200,10,4100),0,0,0,1,150,150,580));
		murs.add(new entity(texture7,new Vector3f(200,10,4500),0,0,0,1,150,150,580));
		murs.add(new entity(texture7,new Vector3f(900,10,4100),0,0,0,1,150,150,580));
		murs.add(new entity(texture7,new Vector3f(900,10,4500),0,0,0,1,150,150,580));
		murs.add(new entity(texture7,new Vector3f(500,10,3700),0,0,0,1,350,100,180));
		murs.add(new entity(texture7,new Vector3f(0,10,2200),0,0,0,1,50,100,480));
		murs.add(new entity(texture7,new Vector3f(20,10,1280),0,0,0,1,450,30,80));
		
	    Random rand=new Random();
	  
	    // Load all OBJ files in a sequence (models for each frame)
   
        
	    rawModel ModelBalle=objloader.loadObjModel("balle", loader);
		texturedModel textureModelBalle=new texturedModel(ModelBalle,new modelTexture(loader.loadTextureJPG("balle")));
		
		rawModel ModelPlayer=objloader.loadObjModel("player", loader);
		texturedModel textureModelPlayer=new texturedModel(ModelPlayer,new modelTexture(loader.loadTextureJPG("texture")));
		
		rawModel ModelPlayer2=objloader.loadObjModel("playerAI", loader);
		texturedModel textureModelPlayer2=new texturedModel(ModelPlayer2,new modelTexture(loader.loadTextureJPG("texture2")));
		
		rawModel ModelGoal=objloader.loadObjModel("player", loader);
		texturedModel textureModelGoal=new texturedModel(ModelGoal,new modelTexture(loader.loadTextureJPG("texture2")));
		
		rawModel ModelGoal2=objloader.loadObjModel("playerAI", loader);
		texturedModel textureModelGoal2=new texturedModel(ModelGoal2,new modelTexture(loader.loadTextureJPG("texture")));
		
		rawModel ModelCar=objloader.loadObjModel("vehicules/vehicule0", loader);
		texturedModel textureModelCar=new texturedModel(ModelCar,new modelTexture(loader.loadTextureJPG("vehicules/Car_1_Diffuse_White")));
		
		rawModel ModelRoue=objloader.loadObjModel("vehicules/roues", loader);
		texturedModel textureModelRoue=new texturedModel(ModelRoue,new modelTexture(loader.loadTextureJPG("vehicules/map_vehicule")));
		
		rawModel ModelRoue2=objloader.loadObjModel("vehicules/roues2", loader);
		texturedModel textureModelRoue2=new texturedModel(ModelRoue2,new modelTexture(loader.loadTextureJPG("map_vehicule")));
		
		
		rawModel ModelSupporter=objloader.loadObjModel("robot/robot", loader);
		texturedModel textureModelSupporter=new texturedModel(ModelSupporter,new modelTexture(loader.loadTextureJPG("robot/gui01")));
		
		
		rawModel ModelSupporter_element=objloader.loadObjModel("robot/robot_bras", loader);
		texturedModel textureModel_ModelSupporter_element=new texturedModel(ModelSupporter_element,new modelTexture(loader.loadTextureJPG("robot/gui02")));
		
	
	      
		 //together.loadAnimatedEntity(List<texturedModel> frames,String basePath, String texturePath, loader loader, int frameCount)
		together.init(loader,murs,supporters_element,supporters,cars,roues_,roues2_, p,manager, balle, pAI,goal, textureModelBalle, textureModelPlayer,textureModelPlayer2,textureModelGoal,textureModelGoal2,textureModelCar,textureModelRoue
				,textureModelRoue2,textureModelSupporter,textureModel_ModelSupporter_element,texture7);
		
	    
		for(int i=4;i<20;i++)
		{
			float x2=rand.nextFloat()*300;
			float z2=rand.nextFloat()*300;
			float y2=terrains.get(0).getHeightTerrain(x2,z2);
			
			entities.add(new entity(texture2,new Vector3f(x2,y2,z2),0,0,0,0.9f,10,10,10));
		
		}
		
		for(int i=20;i<30;i++)
		{
			float x2=rand.nextFloat()*800;
			float z2=rand.nextFloat()*600;
			float y2=terrains.get(0).getHeightTerrain(x2,z2);
			
			entities.add(new entity(texture2,new Vector3f(0+x2,y2,1200+z2),0,0,0,0.9f,20,20,20));
		
		}
		
		for(int i=30;i<45;i++)
		{
			float x2=rand.nextFloat()*1000;
			float z2=rand.nextFloat()*900;
			float y2=terrains.get(0).getHeightTerrain(x2,z2);
			
			entities.add(new entity(texture2,new Vector3f(1200+x2,y2,0+z2),0,0,0,0.9f,15,15,15));
		
		}
		
	
		
			camera cam=new camera(manager.get(0));
			camera cam2=new camera(balle.get(0));

			
			Vector3f carPos=cars.get(0).getPosition();
			Vector3f managerPos=manager.get(0).getPosition();
			waterFrameBufferObject fbo=new waterFrameBufferObject();
			masterRenderer master=new masterRenderer(loader,cam);
			masterRenderer master2=new masterRenderer(loader,cam2);
			WaterShader waterShader=new WaterShader();
			

			waterRenderer waterRender=new waterRenderer(loader,waterShader,master.getProjection(),fbo);
			WaterTile water=new WaterTile(800,800,-90);
			List<WaterTile> waters=new ArrayList<WaterTile>();
			waters.add(water);
		
		
		
		while (!Display.isCloseRequested()) {
			
			together.changeScene(cars, entities);
			
			if(together.getCarInsideStadium())
			{
			  cam2.move();
			}
			else
			{
				cam.move();
			}
			
		master.renderShadowMap(manager,murs,entities,cars,roues_,roues2_,p,pAI,balle,goal,light_);
		
		together.enter_exitManager(manager,cars);
		
		if(together.getCarInsideStadium())
		{
		together.update(p,balle,pAI,goal,supporters_element,pass);
		}
		else
			{
			if(carPos.getX()>0 && carPos.getX()<3600 && carPos.getZ()>0 && carPos.getZ()<3600)
			{
				 terrains.get(0).setTerrain1(true);
				
				 System.out.println("terrain1!");
			}
			else if(managerPos.getX()>0 && managerPos.getX()<3600 && managerPos.getZ()>0 && managerPos.getZ()<3600)
			{
				 terrains.get(0).setTerrain1(true);
				
				 System.out.println("terrain1!");
			}
			
			if(terrains.get(0).getTerrain1())
			{
			together.updateManager(manager,cars,terrains);
			together.updateCar(manager,cars,terrains,roues_,roues2_);
			
			for(int i=0;i<murs.size();i++)
			{
			if(collid.isCollision(cars.get(0).getPosition(),new Vector3f(cars.get(0).getScaleX(),cars.get(0).getScaleY(),cars.get(0).getScaleZ()),
					murs.get(i).getPosition(),new Vector3f(murs.get(i).getScaleX(),
					murs.get(i).getScaleY(),murs.get(i).getScaleZ())))
			{
				if(cars.get(0).getUP()==1)
				  cars.get(0).setSpeedCar(0.5f);
				
				if(cars.get(0).getDOWN()==1)
					  cars.get(0).setSpeedCar(-0.5f);
		
			}
			}
			
			for(int i=0;i<murs.size();i++)
			{
			 if(collid.isCollision(manager.get(0).getPosition(),new Vector3f(manager.get(0).getScaleX(),manager.get(0).getScaleY(),manager.get(0).getScaleZ()),
					murs.get(i).getPosition(),new Vector3f(murs.get(i).getScaleX(),
					murs.get(i).getScaleY(),murs.get(i).getScaleZ())))
			{
				if(manager.get(0).getUP()==1)
				  manager.get(0).setSpeedPlayer(0.5f);
				if(manager.get(0).getDOWN()==1)
					  manager.get(0).setSpeedPlayer(-0.5f);
			}
			}
			}
		}
			

			GL11.glEnable(GL30.GL_CLIP_DISTANCE0);
			//player_.move(terrains2);
			
			float distance=3*(cam2.getPosition().y-water.getHeight());
			cam2.getPosition().y-=distance;
			cam2.invertPitch();
			
			float distance2=3*(cam.getPosition().y-water.getHeight());
			cam.getPosition().y-=distance2;
			cam.invertPitch();
			
			//fbo.bindReflectionFrameBuffer();
			if(together.getCarInsideStadium())
			{
			master2.renderScene(supporters,supporters_element,p,pAI,balle,goal,entities, terrains, light_, cam2,new Vector4f(0,1,0,-waters.get(0).getHeight()+1));
			}
			else
			{
		    if(together.getPlayerInsideCar( manager))
			{
		    	 master.renderSceneTogether(murs,cars,roues_,roues2_,entities, terrains, light_, cam,new Vector4f(0,1,0,-waters.get(0).getHeight()+1));
			}
		    else
		    {
		    	master.renderSceneTogether(manager,murs,cars,roues_,roues2_,entities, terrains, light_, cam,new Vector4f(0,1,0,-waters.get(0).getHeight()+1));
		    }
		 }
			
			if(together.getCarInsideStadium())
			{
			cam2.getPosition().y+=distance;
			cam2.invertPitch();
			}
			else
			{
				cam.getPosition().y+=distance2;
				cam.invertPitch();
			}
		
			fbo.bindReflectionFrameBuffer();
			if(together.getCarInsideStadium())
			{
		    master2.renderScene(supporters,supporters_element,p,pAI,balle,goal,entities, terrains, light_, cam2,new Vector4f(0,1,0,-water.getHeight()));
			}
			else
			{
			 if(together.getPlayerInsideCar( manager))
			 {
		    master.renderSceneTogether(murs,cars,roues_,roues2_,entities, terrains, light_, cam,new Vector4f(0,1,0,-waters.get(0).getHeight()+1));
			}
			 else
			 {
				 master.renderSceneTogether(manager,murs,cars,roues_,roues2_,entities, terrains, light_, cam,new Vector4f(0,1,0,-waters.get(0).getHeight()+1));
			 }
		  }
		    fbo.bindRefractionFrameBuffer();
			if(together.getCarInsideStadium())
			{
			master2.renderScene(supporters,supporters_element,p,pAI,balle,goal,entities, terrains, light_, cam2,new Vector4f(0,-1,0,waters.get(0).getHeight()+0.2f));
			}
			else {
				 if(together.getPlayerInsideCar( manager))
				 {
			master.renderSceneTogether(murs,cars,roues_,roues2_,entities, terrains, light_, cam,new Vector4f(0,1,0,-waters.get(0).getHeight()+1));
			}
				 else
				 {
					 master.renderSceneTogether(manager,murs,cars,roues_,roues2_,entities, terrains, light_, cam,new Vector4f(0,1,0,-waters.get(0).getHeight()+1));
				 }
			}
			GL11.glDisable(GL30.GL_CLIP_DISTANCE0);

			
			fbo2.bindFrameBuffer();
			if(together.getCarInsideStadium())
			{
			master2.renderScene(supporters,supporters_element,p,pAI,balle,goal,entities, terrains, light_,cam2,new Vector4f(0,-1,0,10000));
			}
			else {
				if(together.getPlayerInsideCar( manager))
				{
			master.renderSceneTogether(murs,cars,roues_,roues2_,entities, terrains, light_, cam,new Vector4f(0,1,0,-waters.get(0).getHeight()+1));
			}
			else
			{
				 master.renderSceneTogether(manager,murs,cars,roues_,roues2_,entities, terrains, light_, cam,new Vector4f(0,1,0,-waters.get(0).getHeight()+1));
			}
		}
			if(together.getCarInsideStadium())
			{
			waterRender.render(waters,cam2);
			}
			else {
			waterRender.render(waters,cam);
			}
			fbo2.unbindFrameBuffer();
			
			PostProcessing.doPostProcessing(fbo2.getColourTexture());
			
			DisplayManager.updateDisplay();
		}



		PostProcessing.cleanUp();
		fbo.cleanUp();
		fbo2.cleanUp();
		waterShader.cleanUp();
		master.cleanUp();
		master2.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	     }
		
	  
	  
	}

