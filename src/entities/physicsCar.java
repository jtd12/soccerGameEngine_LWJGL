package entities;

import org.lwjgl.util.vector.Vector3f;

public class physicsCar {
	 private float CAR_MASS = 2000.0f;
     private  float SPRING_CONSTANT = 95000.0f; // N/m
     private float DAMPING_COEFFICIENT = 200.0f; // N*s/m
     private float SUSPENSION_TRAVEL = 0.2f; // m
     private float REST_SUSPENSION_HEIGHT = 0.8f; // Resting height of suspension (m)
     private float rollAngle; // Car body roll angle
     private float pitchAngle; // Car body pitch angle
     
	private	float vx, vz;        // Velocity
  	private float direction;     // Direction (angle in radians)
    private float steeringAngle; // Steering angle (radians)
    private float speed;         // Current speed
    private float[] suspensionHeight={REST_SUSPENSION_HEIGHT+0.4f, REST_SUSPENSION_HEIGHT+0.1f, REST_SUSPENSION_HEIGHT+0.1f, REST_SUSPENSION_HEIGHT}; // Height of the suspension
    private float[] suspensionVelocity={0.0f, 0.0f, 0.0f, 0.0f}; // Velocity of the suspension for each wheel
    private  float acceleration; 
    private  float brakingForce;
    private Vector3f position;
    
    float suspensionRestLength;
    float suspensionCurrentLength;
    float springConstant;
    float dampingConstant;
   
    
    public void updateSuspension(float verticalForce, float dt) {
        float compression = suspensionRestLength - suspensionCurrentLength;
        float springForce = -springConstant * compression;
        float dampingForce = -dampingConstant * (compression / dt);
        float suspensionForce = springForce + dampingForce + verticalForce;
        suspensionCurrentLength += suspensionForce * dt;
        suspensionCurrentLength = Math.max(0.1f, Math.min(suspensionRestLength, suspensionCurrentLength));
    }
 
	public void updatePhysics(float dt) {
		
		acceleration = -brakingForce / CAR_MASS;
	    speed += acceleration * dt;

	    // Stop the car if speed drops below zero
	    if (speed < 0.0f) {
	        speed = 0.0f;
	        acceleration = 0.0f;
	    }
	    
	 	float frontLoadIncrease = brakingForce / 2.0f;  // Apply extra load on front wheels
	    float rearLoadDecrease = brakingForce / 2.0f;   // Reduce load on rear wheels
	    
		 vx = (float) (speed * Math.cos(direction));
	     vz = (float) (-speed * Math.sin(direction));

	    position.x += vx * dt;
	    position.z += vz * dt;

	    // Simple suspension model
	    for (int i = 0; i < 4; i++) {
	    	  float suspensionLoad = (i < 2) ? frontLoadIncrease : -rearLoadDecrease;  // Front vs. rear 
	        
	    float displacement = suspensionHeight[i] - SUSPENSION_TRAVEL;
	    // Calculate spring force
	    float springForce = -SPRING_CONSTANT *  displacement;
	    // Calculate damping force
	    float dampingForce = -DAMPING_COEFFICIENT * suspensionVelocity[i];
	    
	    float totalForce = springForce + dampingForce + suspensionLoad;
	    // Update suspension height
	       suspensionVelocity[i] += (totalForce / (CAR_MASS / 4)) *dt;
	        suspensionHeight[i] += suspensionVelocity[i] * dt;
	        
	        if (suspensionHeight[i] > REST_SUSPENSION_HEIGHT) suspensionHeight[i] = REST_SUSPENSION_HEIGHT;
	        if (suspensionHeight[i] < 0.0f) suspensionHeight[i] = 0.0f;
	        
	    }
	pitchAngle = (suspensionHeight[0]-suspensionHeight[2]) * 40.0f;  // Left-to-right tilt
	rollAngle = (suspensionHeight[1]-suspensionHeight[3]) * 30.0f; // Front-to-back tilt

	direction += steeringAngle * dt;
	}
}
