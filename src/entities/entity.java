package entities;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import models.texturedModel;

public class entity {
	
private texturedModel  model_;
private List<texturedModel>  model;
private Vector3f position;
private float rotX,rotY,rotZ;
private float scale;
private float scaleX,scaleY,scaleZ;

public entity(List<texturedModel>  model, Vector3f position, float rotX, float rotY, float rotZ, float scale,float scaleX,float scaleY,float scaleZ) {
	super();
	this.model = model;
	this.position = position;
	this.rotX = rotX;
	this.rotY = rotY;
	this.rotZ = rotZ;
	this.scale = scale;
	this.scaleX = scaleX;
	this.scaleY = scaleY;
	this.scaleZ = scaleZ;
}

public entity(texturedModel  model_, Vector3f position, float rotX, float rotY, float rotZ, float scale,float scaleX,float scaleY,float scaleZ) {
	super();
	this.model_ = model_;
	this.position = position;
	this.rotX = rotX;
	this.rotY = rotY;
	this.rotZ = rotZ;
	this.scale = scale;
	this.scaleX = scaleX;
	this.scaleY = scaleY;
	this.scaleZ = scaleZ;
}

public void increasePosition(float dx,float dy,float dz)
{
	this.position.x+=dx;
	this.position.y+=dy;
	this.position.z+=dz;
}
public void increaseRotation(float dx,float dy,float dz)
{
	this.rotX+=dx;
	this.rotY+=dy;
	this.rotZ+=dz;
}
public texturedModel getModel() {
	return model_;
}

public List<texturedModel> getModel_() {
	return model;
}

public void setModel(texturedModel model) {
	this.model_ = model;
}

public void setModelList(List<texturedModel> model) {
	this.model = model;
}


public Vector3f getPosition() {
	return position;
}

public void setPosition(Vector3f position) {
	this.position = position;
}

public float getRotX() {
	return rotX;
}

public void setRotX(float rotX) {
	this.rotX = rotX;
}

public float getRotY() {
	return rotY;
}

public void setRotY(float rotY) {
	this.rotY = rotY;
}

public float getRotZ() {
	return rotZ;
}


public void setRotZ(float rotZ) {
	this.rotZ = rotZ;
}

public void setIncrementeRotZ(float rotZ) {
	this.rotZ += rotZ;
}

public float getScale() {
	return scale;
}


public void setScale(float scale) {
	this.scale = scale;
}
public  float getScaleX()
{
	return scaleX;
}
public float getScaleY()
{
	return scaleY;
}
public float getScaleZ()
{
	return scaleZ;
}

}
