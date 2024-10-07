package renderEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

import models.rawModel;
import models.texturedModel;
import shaders.staticShader;
import shaders.terrainShader;
import shadows.ShadowMapMasterRenderer;
import skybox.skyboxRenderer;
import terrains.terrain;
import water.WaterShader;
import water.WaterTile;
import water.waterFrameBufferObject;
import water.waterRenderer;
import entities.AnimatedEntity;
import entities.camera;
import entities.entity;
import entities.light;
import entities.player;
import entities.roues;



public class masterRenderer {

	public static final float fov=70;
	public static final float nearPlane=0.1f;
	public static final float farPlane=250000.0f;
	public static final float RED=0.35f;
	public static final float BLUE=0.4f;
	public static final float GREEN=0.35f;
	
	private Matrix4f projectionMatrix;
	private staticShader shader=new staticShader();
	private entityRenderer render;
	private terrainRenderer terrainRender;
	private terrainShader terrainShader_=new terrainShader();
	private List<terrain> terrains=new ArrayList<terrain>();
	private Map<texturedModel,List<entity>> entities=new HashMap<texturedModel,List<entity>>();
	private Map<texturedModel,List<player>> players =new HashMap<texturedModel,List<player>>();
	//private Map<texturedModel,List<entityWater>> waters =new HashMap<texturedModel,List<entityWater>>();
	private skyboxRenderer skyboxRender;
	private static ShadowMapMasterRenderer shadows;
	   private List<rawModel> frames;  // List of models representing animation frames
	    private int currentFrame = 0;  // Current frame index
	    private float frameTime = 0f;  // Time spent on the current frame
	    private float frameDuration = 0.1f;  // Time per frame (adjust as needed)

	  
	
public masterRenderer(loader l,camera cam)
{
	//GL11.glEnable(GL11.GL_CULL_FACE);
	//GL11.glCullFace(GL11.GL_BACK);
	enableCulling();
	createProjectionMatrix();

	render=new entityRenderer(shader,projectionMatrix);
	terrainRender=new terrainRenderer(terrainShader_,projectionMatrix);
	skyboxRender=new skyboxRenderer(l,projectionMatrix);
	this.shadows=new ShadowMapMasterRenderer(cam);

}
public static void enableCulling()
{
	GL11.glEnable(GL11.GL_CULL_FACE);
	GL11.glCullFace(GL11.GL_BACK);
}
public static void disableCulling()
{
	GL11.glDisable(GL11.GL_CULL_FACE);
}
public Matrix4f getProjection()
{
	return this.projectionMatrix;
}



public void renderScene(List<player> supporters,List<player> supporters_element,List<AnimatedEntity> p,List<AnimatedEntity> pAI, List<player> balle,List<AnimatedEntity> goal,List<entity> entities, List<terrain> terrains, light lights,
		camera camera,Vector4f clipPlane) {
	for (terrain terrain : terrains) {
		processTerrain(terrain);
	}
	for (entity entity : entities) {
		processEntity(entity);
	}

	for(AnimatedEntity player_:p)
	{
		processEntity(player_);
	}
	
	for(AnimatedEntity player_:pAI)
	{
		processEntity(player_);
	}
	
	for(player player_:balle)
	{
		processEntity(player_);
	}
	
	for(AnimatedEntity player_:goal)
	{
		processEntity(player_);
	}
	for(player player_:supporters)
	{
	
		processEntity(player_);

		
	}
	
	for(player player_:supporters_element)
	{
	
		processEntity(player_);

		
	}

	
	render(lights, camera,clipPlane);
}

public void renderSceneTogether(List<AnimatedEntity> animatedEntities,List<entity> murs,List<player> cars,List<roues> roues_,
		List<roues> roues2_,List<entity> entities, List<terrain> terrains, light lights,
		camera camera,Vector4f clipPlane) {

	
	for (terrain terrain : terrains) {
		processTerrain(terrain);
	}
	for (entity entity : entities) {
		processEntity(entity);
	}
	
	for (AnimatedEntity animatedEntity : animatedEntities) {
        //animatedEntity.updateAnimation(deltaTime);  // Mets � jour l'animation avec le deltaTime
        processEntity(animatedEntity);  // Rends l'entit� anim�e (utilise la bonne frame)
    }

	
	for(entity player_:murs)
	{
		processEntity(player_);
	}
	
	for(player player_:cars)
	{
		processEntity(player_);
	}
	
	for(roues player_:roues_)
	{
		processEntity(player_);
	}
	
	for(roues player_:roues2_)
	{
		processEntity(player_);
	}
	

	
	render(lights, camera,clipPlane);
}

public void renderSceneTogether(List<entity> murs,List<player> cars,List<roues> roues_,
		List<roues> roues2_,List<entity> entities, List<terrain> terrains, light lights,
		camera camera,Vector4f clipPlane) {
	
	for (terrain terrain : terrains) {
		processTerrain(terrain);
	}
	for (entity entity : entities) {
		processEntity(entity);
	}
	for(entity player_:murs)
	{
		processEntity(player_);
	}
	
	for(player player_:cars)
	{
		processEntity(player_);
	}
	
	for(roues player_:roues_)
	{
		processEntity(player_);
	}
	
	for(roues player_:roues2_)
	{
		processEntity(player_);
	}
	

	
	render(lights, camera,clipPlane);
}

public void render(light Sun,camera cam,Vector4f clipPlane)
{
	
	prepare();
	shader.start();
	shader.loadClipPlane(clipPlane);
	shader.loadSkyColor(RED, GREEN, BLUE);
	shader.loadLight(Sun);
	shader.loadViewMatrix(cam);
	render.render(entities);
	shader.stop();
	terrainShader_.start();
	terrainShader_.loadClipPlane(clipPlane);
	terrainShader_.loadSkyColor(RED, GREEN, BLUE);
	terrainShader_.loadLight(Sun);
	terrainShader_.loadViewMatrix(cam);
	terrainRender.render(terrains,shadows.getToShadowMapSpaceMatrix());
	terrainShader_.stop();
	skyboxRender.render(cam);
	terrains.clear();
	entities.clear();
}
public void processTerrain(terrain terrain_)
{
	terrains.add(terrain_);
}
public void processEntity(entity entity_)
{
	texturedModel entityModel;
	
	if (entity_ instanceof AnimatedEntity) {
        AnimatedEntity animatedEntity = (AnimatedEntity) entity_;
        entityModel = animatedEntity.getCurrentFrameModel();  // Utilise la frame actuelle de l'entit� anim�e
    } else {
        entityModel = entity_.getModel();  // Entit� statique, r�cup�re le mod�le standard
    }
	
	List<entity> batch=entities.get(entityModel);
	
	if(batch!=null)
	{
		batch.add(entity_);
	}
	else
	{
		ArrayList<entity> newBatch=new ArrayList<entity>();
		newBatch.add(entity_);
		entities.put(entityModel, newBatch);
	}
	
}



public static void prepare() {
	GL11.glEnable(GL11.GL_DEPTH_TEST);
	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
	GL11.glClearColor(RED, GREEN, BLUE, 0.9f);
	GL13.glActiveTexture(GL13.GL_TEXTURE5);
	GL11.glBindTexture(GL11.GL_TEXTURE_2D, getShadowTextureMap());
}

private void createProjectionMatrix()
{
	/*float aspectRatio=(float)Display.getWidth()/(float)Display.getHeight();
	float yScale=(float) ((1f/Math.tan(Math.toRadians(fov/2f)))*aspectRatio);
	float xScale=yScale/aspectRatio;
	float frustrumLength=farPlane-nearPlane;
	
	projectionMatrix=new Matrix4f();
	projectionMatrix.m00=xScale;
	projectionMatrix.m11=yScale;
	projectionMatrix.m22=-((farPlane+nearPlane)/frustrumLength);
	projectionMatrix.m23=-1;
	projectionMatrix.m32=-((2*nearPlane*farPlane)/frustrumLength);
	projectionMatrix.m33=0;
	*/
	
	float aspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
	float y_scale = (float) ((1f / Math.tan(Math.toRadians(fov / 2f)))*aspectRatio);
	float x_scale = y_scale / aspectRatio;
	float frustum_length = farPlane - nearPlane;
	
	projectionMatrix = new Matrix4f();
	projectionMatrix.m00 = x_scale;
	projectionMatrix.m11 = y_scale;
	projectionMatrix.m22 = -((farPlane + nearPlane) / frustum_length);
	projectionMatrix.m23 = -1;
	projectionMatrix.m32 = -((2 * nearPlane * farPlane) / frustum_length);
	projectionMatrix.m33 = 0;
	
	
}

public void renderShadowMap(List<AnimatedEntity> animatedEntities,List<entity> murs,List<entity> entityList,List<player> cars,List<roues> roues_,
		List<roues> roues2_,List<AnimatedEntity> p,List<AnimatedEntity> pAI,List<player> balle,List<AnimatedEntity> goal,light sun)
{// add shader for player
	
	for (AnimatedEntity animatedEntity : animatedEntities) {
        processEntity(animatedEntity);  // Rends l'entit� anim�e (utilise la bonne frame)
    }
	
	for(entity entities:entityList)
	{
		processEntity(entities);
	}

	for(entity player_:murs)
	{
		processEntity(player_);
	}
	
	for(AnimatedEntity player_:p)
	{
		processEntity(player_);
	}
	
	for(AnimatedEntity player_:pAI)
	{
		processEntity(player_);
	}
	
	for(player player_:balle)
	{
		processEntity(player_);
	}
	
	for(AnimatedEntity player_:goal)
	{
		processEntity(player_);
	}
	
	for(player player_:cars)
	{
		processEntity(player_);
	}
	
	for(roues player_:roues_)
	{
		processEntity(player_);
	}
	
	for(roues player_:roues2_)
	{
		processEntity(player_);
	}
	
	
	shadows.render(entities, sun);

	entities.clear();
}
public static int getShadowTextureMap()
{
	return shadows.getShadowMap();
}
public void cleanUp()
{


	terrainShader_.cleanUp();
	shader.cleanUp();
	shadows.cleanUp();
}
}
