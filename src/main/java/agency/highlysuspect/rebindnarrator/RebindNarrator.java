package agency.highlysuspect.rebindnarrator;

public abstract class RebindNarrator {
	public static RebindNarrator IMPL;
	
	/**
	 * @return the GLFW key token of the narrator key, or -1 if the narrator key is not bound.
	 */
	public abstract int getNarratorKeyToken();
}
