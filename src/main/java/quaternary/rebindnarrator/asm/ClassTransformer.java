package quaternary.rebindnarrator.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import java.util.ListIterator;

public class ClassTransformer implements IClassTransformer, Opcodes {
	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) {
		if(transformedName.equals("net.minecraft.client.Minecraft")) {
			ClassReader reader = new ClassReader(basicClass);
			ClassNode mc = new ClassNode();
			reader.accept(mc, 0);
			
			for(MethodNode method : mc.methods) {
				if(method.name.equals("dispatchKeypresses") || method.name.equals("func_152348_aa")) {
					InsnList instructions = method.instructions;
					
					ListIterator<AbstractInsnNode> inserator = instructions.iterator();
					
					//Search for the "BIPUSH 48", this marks the start of the
					//block responsible for toggling the narrator
					//0x30 is the LWJGL key code for "B". Check in Keyboard.java
					while(inserator.hasNext()) {
						AbstractInsnNode instruction = inserator.next();
						if(instruction.getOpcode() == BIPUSH && ((IntInsnNode)instruction).operand == 0x30) {
							//Rewrite it to a number that's not assigned to anything in Keyboard.java
							//Least invasive fix? :thonk:
							((IntInsnNode) instruction).operand = 0x54;
							break;
						}
					}
					
					break;
				}
			}
			
			ClassWriter writer = new ClassWriter(0); //No need for flags since I don't change the size or frames of this class
			mc.accept(writer);
			return writer.toByteArray();
		}
		
		return basicClass;
	}
}
