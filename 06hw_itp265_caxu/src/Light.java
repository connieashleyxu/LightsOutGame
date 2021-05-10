
/**
 * Light Class
 *
 * @author Connie Xu
 * @version Mar 16, 2021
 * ITP 265, Spring 2021, Coffee Section
 * Email: caxu@usc.edu
 * Homework 06
 *
 */
public class Light {
	//instance var
	boolean isOn;
	
	//class const
	public static final String ON = "💡";
	public static final String OFF = "⬛";
	
	//constructor
	public Light(boolean isOn) {
		this.isOn = isOn;
	}
	
	//method flip to change state of light
	public void flip() {
		if(isOn = true) {
			isOn = false;
		}
		else {
			isOn = true;
		}
	}
	
	//methods for indicating if light is on or off
	public String isOn() {
		if(isOn ) {
			return ON;
		}
		else {
			return OFF;
		}
	}
	
	public boolean isLightOn() {
		return isOn;
	}
}
